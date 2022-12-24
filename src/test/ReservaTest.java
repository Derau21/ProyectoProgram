package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import main.clases.Pelicula;
import main.clases.Reserva;

public class ReservaTest {
	
	private Reserva reserva1;
	private Pelicula pelicula1;
	
	@Before
	
	public void setUp() throws Exception{
		
		pelicula1= new Pelicula ("accion", "Piratas del Caribe", 2,1);
		reserva1 = new Reserva (3, "16:30", pelicula1);
		
	}
	
	@Test
	
	public void CalcularCosteTotal() {
		int coste = reserva1.calcularCosteTotal();
		
		assertEquals(30,coste);
		
	}
	
	@Test
	
	public void getNumeroEntradas() {
		int entradas= reserva1.getNumeroEntradas();
		if (entradas!= 3) {
			fail();
		}
	}
	
	@Test
	
	public void setNumeroEntradas() {
		reserva1.setNumeroEntradas(8);
		int entradas = reserva1.getNumeroEntradas();
		boolean comprobacion = false;
		
		if (entradas == 8) {
			comprobacion =true;
			
		}
		assertTrue(comprobacion);
	}
	
	
	

	
	
}
