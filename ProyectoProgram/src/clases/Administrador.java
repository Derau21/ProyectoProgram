package clases;

public class Administrador extends Usuario{
	private String dNI;

	public Administrador(String nombre, int edad, String username, String contrasenya, String antiguedad) {
		super(nombre, edad, username, contrasenya);
		this.dNI = antiguedad;
	}
	
	

	public Administrador(String username, String contrasenya, String antiguedad) {
		super(username, contrasenya);
		this.dNI = dNI;
	}



	public String getdNI() {
		return dNI;
	}



	public void setdNI(String dNI) {
		this.dNI = dNI;
	}



	


	

	

}
