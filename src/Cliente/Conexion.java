package Cliente;

import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;



public class Conexion implements Serializable {
	public static Socket socket;
	
	public void init() {
		try {
			do {
				socket = new Socket("127.0.0.1",7000);
				socket.close();
			} while (true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
