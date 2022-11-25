package clases;

public class Administrador extends Usuario{
	private String antiguedad;

	public Administrador(String nombre, int edad, String dNI, String username, String contrasenya, String antiguedad) {
		super(nombre, edad, dNI, username, contrasenya);
		this.antiguedad = antiguedad;
	}
	
	

	public Administrador(String username, String contrasenya, String antiguedad) {
		super(username, contrasenya);
		this.antiguedad = antiguedad;
	}



	public String getAntiguedad() {
		return antiguedad;
	}



	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}



	

	

}
