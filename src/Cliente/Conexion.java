package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;



public class Conexion {
	public Socket socket;
	
	public void init() {
		try {
				socket = new Socket("127.0.0.1",7000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void enviarDecision(String decision) {
		try {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(decision);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Err enviar decision cliente");
			e.printStackTrace();
		}
	}
	
	public Object recivirObjeto() {
		ObjectInputStream in ;
		try {
			in = new ObjectInputStream( socket.getInputStream() );
			return in.readObject();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Err reciviendo objetos");
		}
		return null;
	}
	
	public void enviarObjeto(Object obj) {
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream( socket.getOutputStream() );
			out.writeObject(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Err recivir objeto en cliente");
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Excepcion cierre socket");
			e.printStackTrace();
		}
		
	}

	public boolean recivirBoolean() {
		boolean respuesta = false;
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			respuesta = in.readBoolean();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Err recepcion boolean cliente");
//			e.printStackTrace();
		}
		
		return respuesta;
	}
	public int recivirInt() {
		int respuesta =0 ;
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			respuesta = in.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Err recepcion int cliente");
			e.printStackTrace();
		}
		
		return respuesta;
	}
	
}
