package main.clases;

public class Cliente extends Usuario {

	public Cliente() {
		super();
	}

	public Cliente(String nombre, int edad, String username, String contrasenya) {
		super(nombre, edad, username, contrasenya);

	}

	public Cliente(String username, String contrasenya) {
		super(username, contrasenya);
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", edad=" + edad + ", username=" + username + ", contrasenya="
				+ contrasenya + ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad() + ", getUsername()="
				+ getUsername() + ", getContrasenya()=" + getContrasenya() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
