package clases;

public class Sala {
	
	private int numeroSala;
	private int capacidad;
	
	public Sala(int numeroSala, int capacidad) {
		super();
		this.numeroSala = numeroSala;
		this.capacidad = capacidad;
	}

	public int getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Sala [numeroSala=" + numeroSala + ", capacidad=" + capacidad + "]";
	}
	
	

}
