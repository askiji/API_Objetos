package Servidor;

public class Cliente {
	private String dni;
	private String Nombre;
	private String apellido1;
	private String apellido2;
	
	
	
	public Cliente(String dni, String nombre, String apellido1, String apellido2) {
		super();
		this.dni = dni;
		Nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
}
