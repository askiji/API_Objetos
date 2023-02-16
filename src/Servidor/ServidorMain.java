package Servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ServidorMain {

	public static void main(String[] args) {
		new BBDD().addDatos();
		new MenuServidor().start();
		do {
			ConexionServidor c = new ConexionServidor();
			c.init();
			Gestor g = new Gestor(c);
			g.init();
		} while (true);
	}

}
