package clases;

public class Pelicula {

	private String genero;
	private String nombre;
	private int duracion;
	private int id;

	public Pelicula() {
		super();
	}

	public Pelicula(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Pelicula(String genero, String nombre, int duracion, int id) {
		super();
		this.genero = genero;
		this.nombre = nombre;
		this.duracion = duracion;
		this.id=id;

	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return genero + ";" + nombre + ";" + duracion;
	}
}
