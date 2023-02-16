package Servidor;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuServidor extends Thread{

	
	@Override
	public void run() {
		super.run();
		
		do {
			mostrar();
		} while (true);
	}

	private void mostrar() {

		System.out.println("1.- Lista de clientes");
		System.out.println("2.- Lista de vehiculos");
		Scanner sc = new Scanner(System.in);
		String opcion = sc.next();
		if (opcion.equals("1")) {
			BBDD.clientes.stream().forEach(e -> System.out.println(e));
		}
		if (opcion.equals("2")) {
			BBDD.vehiculos.stream().forEach(e -> System.out.println(e));
		}

		
	}



}
