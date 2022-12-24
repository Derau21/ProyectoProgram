package main.clases;

public class Cliente extends Usuario{

	public Cliente(String nombre, int edad, String username, String contrasenya) {
		super(nombre, edad, username, contrasenya);
		
	}

	public Cliente(String username, String contrasenya) {
		super(username, contrasenya);
	}


}
