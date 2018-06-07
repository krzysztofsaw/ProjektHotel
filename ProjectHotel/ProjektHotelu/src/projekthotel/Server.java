    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import static projekthotel.BazaSql.StartConnectBase;

/**
 *
 * @author użytkownik
 */
public class Server {

    public static BazaSql baza;

    private ServerSocket aServerSocket;
    private volatile Boolean shouldRun = true;

    public Server() {
        try {
            aServerSocket = new ServerSocket(24001);
        } catch (IOException e) {
            this.exit();
            e.printStackTrace();
        }

    }

    public Boolean shouldRun() {
        return shouldRun;
    }

    public void exit() {
        shouldRun = false;
    }

    ServerSocket getServerSocket() {
        return aServerSocket;
    }

    public static void main(String[] args) {
        baza = new BazaSql();
        //new WindowLogged().setVisible(true);
        Server aServer = new Server();
        Socket aSocket;

        while (aServer.shouldRun()) {
            try {
                aSocket = aServer.getServerSocket().accept();
                System.out.println("Client connected");
                ServerThread thread = new ServerThread(aSocket);
                thread.start();

            } catch (Exception e) {
                e.printStackTrace();

                aServer.exit();
            }
        }
    }

}
