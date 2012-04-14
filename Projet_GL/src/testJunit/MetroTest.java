package testJunit;

import java.util.ArrayList;

import junit.framework.TestCase;

import modele.Chemin;
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
	
	public void testGetChemin() {
		Chemin chemin = m.getPlusCourtChemin(m.getStations().get(0), m.getStations().get(1));
		
		assertEquals(0, chemin.getNbChangement());
		assertEquals(40, chemin.getDureeChemin());
		
		chemin = m.getPlusCourtChemin(m.getStations().get(0), m.getStations().get(2));
		assertEquals(0, chemin.getNbChangement());
		assertEquals(70, chemin.getDureeChemin());
		
		chemin = m.getPlusCourtChemin(m.getStations().get(0), m.getStations().get(4));
		assertEquals(1, chemin.getNbChangement());
		assertEquals(70, chemin.getDureeChemin());
		
		chemin = m.getMoinsChangementChemin(m.getStations().get(0), m.getStations().get(4));
		assertEquals(1, chemin.getNbChangement());
		assertEquals(220, chemin.getDureeChemin());
		
		chemin = m.getMoinsChangementChemin(m.getStations().get(0), m.getStations().get(5));
		assertEquals(1, chemin.getNbChangement());
		assertEquals(190, chemin.getDureeChemin());
		
		chemin = m.getPlusCourtChemin(m.getStations().get(0), m.getStations().get(5));
		assertEquals(2, chemin.getNbChangement());
		assertEquals(100, chemin.getDureeChemin());
		
		m.getStations().get(4).fermerStation();	// Fermeture de la station E
		chemin = m.getPlusCourtChemin(m.getStations().get(0), m.getStations().get(5));
		assertEquals(1, chemin.getNbChangement());
		assertEquals(190, chemin.getDureeChemin());
		
		m.getStations().get(4).ouvrirStation();	// ouverture de la station E
		m.getStations().get(2).getVoie(m.getStations().get(3)).setEnCirculation(false); //Fermeture de la voie entre C et D
		
		chemin = m.getMoinsChangementChemin(m.getStations().get(0), m.getStations().get(5));
		assertEquals(2, chemin.getNbChangement());
		assertEquals(100, chemin.getDureeChemin());
		
	}

}