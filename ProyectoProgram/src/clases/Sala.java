package clases;

public class Sala {

	private String nombreSala;
	private int numeroAsientos;

	public Sala() {
		super();
	}

	public Sala(String nombreSala, int numeroAsientos) {
		super();
		this.nombreSala = nombreSala;
		this.numeroAsientos = numeroAsientos;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
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
