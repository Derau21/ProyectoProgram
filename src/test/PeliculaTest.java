package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.clases.Pelicula;



public class PeliculaTest {

	
	private Pelicula pelicula1;
	private Pelicula pelicula2;
	private Pelicula pelicula3;
	
	@Before
	public void setUp() throws Exception{
	
		pelicula1= new Pelicula("Accion", "Piratas Del Caribe", 2, 1);		
		pelicula2= new Pelicula("Ficcion", "Stars Wars", 3, 2);		
		pelicula3= new Pelicula("Terror", "The Black Phone", 2, 3);		
	}
	
	@Test	
	public void getGenero() {
		assertEquals("Accion", pelicula1.getGenero());
	}

	@Test
	public void setGenero() {
		pelicula1.setGenero("Ficcion");
		
		assertEquals("Ficcion", pelicula1.getGenero());
	}
	@Test
	public void getNombre() {
		assertEquals("Stars Wars", pelicula2.getNombre());
		
	}
	@Test
	public void setNombre() {
		pelicula2.setNombre("Blancanieves");
		
		assertEquals("Blancanieves", pelicula2.getNombre());
	}
	
	@Test
	public void getDuracion() {
		assertEquals(2, pelicula3.getDuracion());
	}
	
	@Test
	public void setDuracion() {
		pelicula3.setDuracion(3);
		
		assertEquals(3, pelicula3.getDuracion());
	}	
}
