package testJunit;

import static org.junit.Assert.*;


import org.junit.Test;

import modele.*;

public class StationTest {

	
	/*
	 * Test de la methode existeVoie()
	 */
	@Test
	public void testExiste() {
		Voie v1 = new Voie(1, 120);
		Voie v2 = new Voie(2, 120);
		Station s = new Station("test", 1, 1);
		s.addVoie(v1);
		assertEquals(true, s.existeVoie(v1));
		assertEquals(false, s.existeVoie(v2));
	}
	

	
	/*
	 * Test de la methode getNbVoies
	 */
	@Test
	public void testGetNbVoies() {
		Voie v1 = new Voie(1, 120);
		Voie v2 = new Voie(2, 120);
		Station s = new Station("test", 1, 1);
		assertEquals(0, s.getNbVoies());
		
		s.addVoie(v1);
		assertEquals(1, s.getNbVoies());
		
		s.addVoie(v2);
		assertEquals(2, s.getNbVoies());
		
		s.deleteVoie(v1);
		assertEquals(1, s.getNbVoies());

	}

}
