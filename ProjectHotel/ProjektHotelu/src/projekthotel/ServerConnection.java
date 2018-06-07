package projekthotel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerConnection {
	
	private static ServerConnection firstInstance = null;
	private static Socket socket;
	private static ObjectOutputStream outputStream;
	private static ObjectInputStream inputStream;
	
	public static ServerConnection getInstance() {
		if(null == firstInstance) {
			firstInstance = new ServerConnection();
		}
		return firstInstance;
	}

	public ObjectOutputStream getOutputStream() {
		return outputStream;
	}
	
	public ObjectInputStream getInputStream() {
		return inputStream;
	}
	
	private ServerConnection() {
		try {
			socket = new Socket("127.0.0.1", 24001);
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream = new ObjectInputStream(socket.getInputStream());
		}
		catch(IOException e) {
			e.printStackTrace();	
		}	
	}
}
