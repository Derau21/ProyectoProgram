package clases;

public class Usuario {
	
	private String nombre;
	private String usuario;
	private String contrase�a;
	private String edad;
	private String dni;
	
	public Usuario(String nombre, String usuario, String contrase�a, String edad, String dni) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
		return "Usuario [nombre=" + nombre + ", usuario=" + usuario + ", contrase�a=" + contrase�a + ", edad=" + edad
				+ ", dni=" + dni + "]";
	}
	
	
	
	
	
}
	
	