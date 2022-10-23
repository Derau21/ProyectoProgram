package clases;

public class Usuario {
	
	private String nombre;
	private String usuario;
	private String contraseña;
	private String edad;
	private String dni;
	
	public Usuario(String nombre, String usuario, String contraseña, String edad, String dni) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.edad = edad;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", usuario=" + usuario + ", contraseña=" + contraseña + ", edad=" + edad
				+ ", dni=" + dni + "]";
	}
	
	
	
	
	
}
	
	