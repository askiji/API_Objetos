package Cliente;

import java.io.DataOutputStream;
import java.io.IOException;

public class ClienteMain {

	public static void main(String[] args) {
		do {
			Conexion c = new Conexion();
			c.init();
			Menu m = new Menu(c);
			m.menu();
		} while (true);
	}

}
