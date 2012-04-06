package testJunit;

import java.util.ArrayList;

import junit.framework.TestCase;

import modele.Metro;
import modele.Station;


public class MetroTest extends TestCase{

	private Metro m;
	private Station test;
	
	public void setUp(){
		this.m = new Metro();
		test = new Station("test", 1, 1, 1);
		m.getMetro().get(0).addStation(test);
	}

	/**
	* Test de la methode rechercheProcheStation (depend de la structure du metro)
	*/
	public void testRechercheProcheStation(){

		assertEquals("A", m.rechercheProcheStation(48,53));
		assertEquals("B", m.rechercheProcheStation(195, 96));
	}
	
	/**
	 * Test de la methode getNumStation
	 */
	public void testGetNumStation() {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Station temp = new Station("temp", 1, 1, 1);
		assertEquals(new Integer(1),m.getNumStation(test).get(0));
		assertEquals(res,m.getNumStation(temp));
		res.add(new Integer(1));
		res.add(new Integer(3));
		
		m.getMetro().get(2).addStation(test);
		assertEquals(res, m.getNumStation(test));
	}

}
