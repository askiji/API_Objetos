package Cliente;

import java.util.Scanner;

public class Menu {

	
	public void menu() {
		System.out.println("1.- Recivir");
		System.out.println("2.- Enviar");
		System.out.println("3.- Cantidad de datos?");
		Scanner sc = new Scanner(System.in);
		String primerMenu = sc.nextLine();
		System.out.println("1.- Cliente");
		System.out.println("2.- Vehiculo");
		String segundoMenu = sc.nextLine();
		String decision ="";
		if(primerMenu.equals("1")) {
			if(segundoMenu.equals("1")) {
				System.out.println("Cual es el DNI?");
			}
			else {
				System.out.println("Cual es la matricula");
			}
			decision= sc.nextLine();
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
			}
		}
		else {
			//TODO lista de clietnes y datos
		}
	}
}
