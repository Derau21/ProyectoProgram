package clases;

import java.util.Iterator;

public class Usuario {

	public String nombre;
	public int edad;
	public String DNI;
	public String username;
	public String contrasenya;
	
	public Usuario(String nombre, int edad, String dNI, String username, String contrasenya) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = dNI;
		this.username = username;
		this.contrasenya = contrasenya;
	}

	public Usuario(String username, String contrasenya) {
		this.username = username;
		this.contrasenya= contrasenya;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + ", username=" + username
				+ ", contrasenya=" + contrasenya + "]";
	}
	
	

	
	
}
