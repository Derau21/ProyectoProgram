package clases;

public class Reserva {
	
	private Pelicula peli;
	private String hora;
	private int numeroDeEntradas;
	private String usuario;
	
	public Reserva(Pelicula peli, String hora, int numeroDeEntradas, String usuario) {
		super();
		this.peli = peli;
		this.hora = hora;
		this.numeroDeEntradas = numeroDeEntradas;
		this.usuario = usuario;
	}

	

	public Pelicula getPeli() {
		return peli;
	}



	public void setPeli(Pelicula peli) {
		this.peli = peli;
	}



	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getNumeroDeEntradas() {
		return numeroDeEntradas;
	}

	public void setNumeroDeEntradas(int numeroDeEntradas) {
		this.numeroDeEntradas = numeroDeEntradas;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return peli.getTitulo();
	}
	
}