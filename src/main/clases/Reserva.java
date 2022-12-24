package main.clases;

public class Reserva {
	private int numeroEntradas;
	private String hora;
	private Pelicula peli;

	public Reserva(int numeroEntradas) {
		super();
		this.numeroEntradas = numeroEntradas;
	}

	public Reserva(int numeroEntradas, String hora, Pelicula peli) {
		super();
		this.numeroEntradas = numeroEntradas;
		this.hora = hora;
		this.peli = peli;
	}

	public int getNumeroEntradas() {
		return numeroEntradas;
	}

	public void setNumeroEntradas(int numeroEntradas) {
		this.numeroEntradas = numeroEntradas;
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

	int precio = 10;

	public int calcularCosteTotal() { 
		int coste = 0;
		coste = getNumeroEntradas() * precio;

		return coste;

	}

}
