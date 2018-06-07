package projekthotel;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
	
	private Socket socket;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private Boolean shouldRun = true;
	
	
	public ServerThread(Socket aSocket) {
		super("ServerThread");
		socket = aSocket;
	}
	
	public Boolean shouldRun() {
		return shouldRun;
	}
	
	public void exit() {
		shouldRun = false;
	}
	
	public ObjectOutputStream getOutputStream() {
		return outputStream;
	}
	
	public ObjectInputStream getInputStream() {
		return inputStream;
	}
	
	@Override
	public void run() {
		try {
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream = new ObjectInputStream(socket.getInputStream());
			
			while(shouldRun()) {
				Action service = (Action)inputStream.readObject();
				System.out.println("Przechwycono: " + service.getClass());
				
				new ActionLayout(service, this);
			}
			outputStream.close();
			inputStream.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Client disconnected - closing connection");
			this.exit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}