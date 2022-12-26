package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import clases.Usuario;

public class UsuarioTest {

	
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	
	@Before
	
	public void setUp() throws Exception{
	
		usuario1= new Usuario ("Pablo",19, "Derau", "Hola2");		
		usuario2= new Usuario ("Alex",20, "Calde", "Bocata3");	
		usuario2= new Usuario ("Bastiaan",20, "Basti", "Deusto1");
	}
	
	@Test
	
	public void getNombre() {
		assertEquals("Pablo", usuario1.getNombre());
	}
	
	@Test
	
	public void setNombre() {
		
		usuario1.setNombre("Juan");
				
		assertEquals("Juan", usuario1.getNombre());
	}
	
	@Test
	
	public void getEdad() {
		int edad = usuario2.getEdad();
		if (edad==20) {
			
		}else {
			fail();
		}
	}
	@Test
	
	public void SetEdad() {
		boolean comprobacion = false;
		usuario1.setEdad(4);
		int edad = usuario1.getEdad();
		
		if (edad==4) {
			comprobacion=true;
		}
		
		assertTrue(comprobacion);
	}
}
