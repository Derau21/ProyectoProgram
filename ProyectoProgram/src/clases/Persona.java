package clases;

import java.util.Iterator;

public class Persona {

	public String nombre;
	public int edad;
	public String DNI;
	
	public Persona(String nombre, int edad, String dNI) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		DNI = dNI;
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

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + "]";
	}
	
	
	
}