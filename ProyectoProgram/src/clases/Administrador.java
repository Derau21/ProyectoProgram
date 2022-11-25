package clases;

public class Administrador extends Usuario{
	private int antiguedad;

	public Administrador(String nombre, int edad, String dNI, String username, String contrasenya, int antiguedad) {
		super(nombre, edad, dNI, username, contrasenya);
		this.antiguedad = antiguedad;
	}
	
	

	public Administrador(String username, String contrasenya, int antiguedad) {
		super(username, contrasenya);
		this.antiguedad = antiguedad;
	}



	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	

}
