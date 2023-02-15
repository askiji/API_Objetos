package Servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class ConexionServidor {
	public ServerSocket socket;
	public Socket socket_cli;
	public void init() {
		try {
			socket = new ServerSocket(7000);
			this.socket_cli = socket.accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
