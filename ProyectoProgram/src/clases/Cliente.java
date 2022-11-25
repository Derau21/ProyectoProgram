package clases;

public class Cliente extends Usuario{

	public Cliente(String nombre, int edad, String dNI, String username, String contrasenya) {
		super(nombre, edad, dNI, username, contrasenya);
		
	}

	public Cliente(String username, String contrasenya) {
		super(username, contrasenya);
	}


}
