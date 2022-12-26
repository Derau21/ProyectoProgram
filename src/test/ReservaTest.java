package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.clases.Cliente;
import main.clases.Pelicula;
import main.clases.Reserva;

public class ReservaTest {
	
	private Reserva reserva1;
	private Pelicula pelicula1;
	
	@Before
	public void setUp() throws Exception{
		
		pelicula1= new Pelicula ("accion", "Piratas del Caribe", 2,1);
		List<String> asientos = Arrays.asList("1A", "1B");
		reserva1 = new Reserva(asientos, "16:30", pelicula1, new Cliente());
		
	}
	
	@Test
	public void calcularCosteTotal() {
		int coste = reserva1.calcularCosteTotal(10);
		
		assertEquals(20,coste);
		
	}
}
