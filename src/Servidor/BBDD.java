package Servidor;

import java.io.Serializable;
import java.util.ArrayList;

public class BBDD implements Serializable{
	public static ArrayList<Cliente> clientes = new ArrayList<>();
	public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
	
	
	public void addDatos() {
		clientes.add(new Cliente("01a", "Juan", "Ajuan", "A2Juan"));
		clientes.add(new Cliente("02b", "pepe", "apepe", "a2pepe"));
		clientes.add(new Cliente("03c","Laura","aLaura","a2Laura"));
		
		vehiculos.add(new Vehiculo("M1", "seat", "panda", "50cv"));
		vehiculos.add(new Vehiculo("M2", "seat", "arosa", "50cv"));
		vehiculos.add(new Vehiculo("M3", "seat", "ibiza", "150cv"));
	}
	public static Object buscar(int array , String primaryKey) {
		if(array ==1) {
			return clientes.stream().filter(e -> e.getDni().equals(primaryKey)).findFirst().get();
		}
		else {
			return vehiculos.stream().filter(e-> e.getMatricula().equals(primaryKey)).findFirst().get();
		}
	}
	
}
