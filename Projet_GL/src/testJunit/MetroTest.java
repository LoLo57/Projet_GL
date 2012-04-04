package testJunit;

import junit.framework.TestCase;

import modele.Metro;


public class MetroTest extends TestCase{

	private Metro m;
	
	public void setUp(){
		this.m = new Metro();
	}

	/**
	* Test de la methode rechercheProcheStation (depend de la structure du metro)
	*/
	public void testRechercheProcheStation(){

		assertEquals("A", m.rechercheProcheStation(48,53));
		assertEquals("B", m.rechercheProcheStation(195, 96));
	}

}
