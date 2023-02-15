package Servidor;

import java.util.ArrayList;

public class ServidorMain {
	public static void main(String[] args) {
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		
		clientes.add(new Cliente("01a", "Juan", "Ajuan", "A2Juan"));
		clientes.add(new Cliente("02b", "pepe", "apepe", "a2pepe"));
		clientes.add(new Cliente("03c","Laura","aLaura","a2Laura"));
		
		vehiculos.add(new Vehiculo("M1", "seat", "panda", "50cv"));
		vehiculos.add(new Vehiculo("M2", "seat", "arosa", "50cv"));
		vehiculos.add(new Vehiculo("M3", "seat", "ibiza", "150cv"));
		ConexionServidor c = new ConexionServidor();

	}
}
