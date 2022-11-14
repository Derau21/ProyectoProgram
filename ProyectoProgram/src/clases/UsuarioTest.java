package clases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	
	@Before
	
	public void setUp() throws Exception{
	
		usuario1= new Usuario ("Pablo",19, "74561435L", "Derau", "Hola2");		
		usuario2= new Usuario ("Alex",20, "78679109P", "Calde", "Bocata3");	
		usuario2= new Usuario ("Bastiaan",20, "76541090M", "Basti", "Deusto1");
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
}
