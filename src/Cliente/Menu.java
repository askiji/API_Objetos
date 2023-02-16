package Cliente;

import java.util.Iterator;
import java.util.Scanner;

import Servidor.Cliente;
import Servidor.Vehiculo;

public class Menu {
	private Conexion conexion; 
	
	
	public Menu(Conexion conexion) {
		super();
		this.conexion = conexion;
	}


	public void menu() {
		System.out.println("1.- Recivir");
		System.out.println("2.- Enviar");
		System.out.println("3.- Cantidad de datos?");
		Scanner sc = new Scanner(System.in);
		String primerMenu = sc.nextLine();
		String segundoMenu = "";
		conexion.enviarDecision(primerMenu);
		if(!primerMenu.equals("3")) {
			System.out.println("1.- Cliente");
			System.out.println("2.- Vehiculo");
			segundoMenu = sc.nextLine();
			conexion.enviarDecision(segundoMenu);
		}
		
		if(primerMenu.equals("1")) {
			if(segundoMenu.equals("1")) {
				System.out.println("Cual es el DNI?");
				String dni = sc.nextLine();
				conexion.enviarDecision(dni);
				Cliente c = (Cliente) conexion.recivirObjeto();
				System.out.println(c);
			}
			else {
				System.out.println("Cual es la matricula");
				String matricula = sc.nextLine();
				conexion.enviarDecision(matricula);
				Vehiculo v = (Vehiculo) conexion.recivirObjeto();
				System.out.println(v);
			}
			
		}	
		if(primerMenu.equals("2")) {
			if(segundoMenu.equals("1")) {
				String dni;
				String nombre;
				String apellido1;
				String apellido2;
				System.out.println("Datos del cliente");
				System.out.println("Introduzca Dni");
				dni = sc.nextLine();
				System.out.println("Introduzca Nombre");
				nombre = sc.nextLine();
				System.out.println("Introduzca Apellido1");
				apellido1 = sc.nextLine();
				System.out.println("Introduzca Apellido2");
				apellido2 = sc.nextLine();
				conexion.enviarObjeto(new Cliente(dni, nombre, apellido1, apellido2));
				
			}
			else {
				String matricula;
				String marca;
				String modelo;
				String potencia;
				System.out.println("Datos del coche");
				System.out.println("Introduzca matricula");
				matricula = sc.nextLine();
				System.out.println("Introduzca marca");
				marca = sc.nextLine();
				System.out.println("Introduzca modelo");
				modelo = sc.nextLine();
				System.out.println("Introduzca potencia");
				potencia = sc.nextLine();
				conexion.enviarObjeto(new Vehiculo(matricula, marca, modelo, potencia));
				
			}
			boolean aux = conexion.recivirBoolean();
			if(aux) {
				System.out.println("Ya estaba en la base de datos");
			}
			if(!aux) {
				System.out.println("Se ha añadido a la abse de datos");
			}
			
		}
		if(primerMenu.equals("3")) {
			int numClientes = conexion.recivirInt();
			int numVehiculos = conexion.recivirInt();
			for (int i = 0; i < numClientes; i++) {
				System.out.println(conexion.recivirObjeto());
			}
			for (int i = 0; i < numVehiculos; i++) {
				System.out.println(conexion.recivirObjeto());
			}
		}
		conexion.close();
	}
}
