package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	public Object recivirObjeto() {
		ObjectInputStream in ;
		try {
			in = new ObjectInputStream( socket_cli.getInputStream() );
			return in.readObject();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Err reciviendo objetos en servidor");
		}
		return null;
	}
	
	public void enviarObjeto(Object obj) {
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream( socket_cli.getOutputStream() );
			out.writeObject(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Err recivir objeto ");
			e.printStackTrace();
		}
	}
	
	public String inString() {
		String info="No tenemos informacion";
		try {
			DataInputStream in = new DataInputStream(socket_cli.getInputStream());
			info = in.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Err primera decision server");
			e.printStackTrace();
		}
		return info;
	}

	public void enviarBoolean(boolean decision) {
		try {
			DataOutputStream out = new DataOutputStream(socket_cli.getOutputStream());
			out.writeBoolean(decision);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Err enviar boolean servidor");
			e.printStackTrace();
		}
		
	}
	public void enviarInt(int longitud) {
		try {
			DataOutputStream out = new DataOutputStream(socket_cli.getOutputStream());
			out.writeInt(longitud);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Err enviar longitud arr servidor");
			e.printStackTrace();
		}
		
	}
}
