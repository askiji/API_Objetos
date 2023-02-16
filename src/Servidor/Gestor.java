package Servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Gestor {

	private ConexionServidor conexion;
	public Gestor(ConexionServidor c) {
		this.conexion = c;
	}

	public void init(){
		String primeraDecision = conexion.inString();
//		System.out.println(primeraDecision);
		String segundaDecision = "";
		if(!primeraDecision.equals("3")) segundaDecision = conexion.inString();
//		System.out.println(segundaDecision);
		if(primeraDecision.equals("1")) {
			if (segundaDecision.equals("1")) {
				// enviar objeto cliente
				String aux = conexion.inString();
				System.out.println(aux);
				conexion.enviarObjeto(BBDD.buscar(1, aux));
			}
			else {
				conexion.enviarObjeto(BBDD.buscar(2, conexion.inString()));
			}
			
		}
		if(primeraDecision.equals("2")) {
			if (segundaDecision.equals("1")) {
				Cliente cliente = (Cliente) conexion.recivirObjeto();
				boolean  b = BBDD.clientes.contains(cliente);
				conexion.enviarBoolean(b);
				if(!b) {
					BBDD.clientes.add(cliente);
				}
			}
			if(segundaDecision.equals("2")) {
				//recivir y guardar vehiculo
				Vehiculo vehiculo = (Vehiculo) conexion.recivirObjeto();
				boolean v = BBDD.vehiculos.contains(vehiculo);
				conexion.enviarBoolean(v);
				if (!v) {
					BBDD.vehiculos.add(vehiculo);
				}
			}
		}
		if(primeraDecision.equals("3")) {
			// enviar los length
			conexion.enviarInt(BBDD.clientes.size());
			conexion.enviarInt(BBDD.vehiculos.size());
			BBDD.clientes.stream().forEach(e -> conexion.enviarObjeto(e));
			BBDD.vehiculos.stream().forEach(e -> conexion.enviarObjeto(e));
		}
		try {
			conexion.socket_cli.close();
			conexion.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Err cerando server");
			e.printStackTrace();
		}
	}


}
