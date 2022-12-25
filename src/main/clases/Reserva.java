package main.clases;

import java.util.List;

public class Reserva {
	
	private List<String> asientos;
	private String hora;
	private Pelicula peli;
	private Cliente cliente;

	
	public Reserva(List<String> asientos, String hora, Pelicula peli, Cliente cliente) {
		super();
		this.asientos = asientos;
		this.hora = hora;
		this.peli = peli;
		this.cliente = cliente;
	}
	

	public Reserva(Pelicula pelicula, String hora, Cliente cliente) {
		this.peli = pelicula;
		this.hora = hora;
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<String> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<String> asientos) {
		this.asientos = asientos;
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
	

	public int calcularCosteTotal(int precio) { 
		
		return precio * asientos.size();
	}

}
