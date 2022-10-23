package clases;

public class Pelicula {
	
	private String titulo;
	private String descripcion;
	private String duracion;
	private String director;
	
	public Pelicula(String titulo, String descripcion, String duracion, String director) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.director = director;
	}
	
	

	public Pelicula(String titulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
	}



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return titulo;
	}
	
	
	
}	
	