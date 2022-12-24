package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.clases.Sala;
import main.clases.Usuario;

public class SalaTest {
	private Sala sala1;
	
@Before
	
	public void setUp() throws Exception{
		sala1 = new Sala (1, 250);	
	}
@Test
public void getNumeroSala() {
	assertEquals(1, sala1.getNumeroSala());
}

@Test
public void setNumeroSala() {
	sala1.setNumeroSala(2);
	assertEquals(sala1.getNumeroSala(), 2);
	
}
@Test
public void getNumeroAsientos() {
	assertEquals(250, sala1.getNumeroAsientos());
	
}
@Test
public void setNumeroAsientos() {
	sala1.setNumeroAsientos(350);
	assertEquals(sala1.getNumeroAsientos(), 350);

}}
