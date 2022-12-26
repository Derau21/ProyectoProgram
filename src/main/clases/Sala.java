package main.clases;

public class Sala {

	private int numeroSala;
	private int numeroAsientos;
	
	

	public Sala(int numeroSala, int numeroAsientos) {
		super();
		this.numeroSala = numeroSala;
		this.numeroAsientos = numeroAsientos;
	}

	public int getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}

	public int getNumeroAsientos() {
		return numeroAsientos;
	}

	public void setNumeroAsientos(int numeroAsientos) {
		this.numeroAsientos = numeroAsientos;
	}

	public void reservarAsiento(int asientosAReservar) {

		int asientosDisponibles = getNumeroAsientos();

		if (asientosAReservar < asientosDisponibles) {
			System.out.println("Perfecto,tiene asientos disponibles");
			asientosDisponibles = asientosDisponibles - asientosAReservar;
		} else if (asientosAReservar > asientosDisponibles) {
			System.out.println("Lo siento, no puede reservar tantos asientos");

		}

	}
}
