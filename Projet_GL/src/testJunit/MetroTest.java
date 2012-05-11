package testJunit;

import java.util.ArrayList;

import junit.framework.TestCase;

import modele.Chemin;
import modele.Metro;
import modele.Station;


public class MetroTest extends TestCase{

	private Metro m;
	
	public void setUp(){
		this.m = new Metro();
		
	}

	/**
	* Test de la methode rechercheProcheStation (depend de la structure du metro)
	*/
	public void testRechercheProcheStation(){
		System.out.println(m.getStations());
		assertEquals(m.getStations().get(0), m.rechercheProcheStation(48,53, 80));
		assertEquals(m.getStations().get(1), m.rechercheProcheStation(195, 96, 80));
	}
	
	/**
	 * Test de la methode getNumStation
	 */
	public void testGetNumStation() {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Station temp = m.getStations().get(1);
		assertEquals(new Integer(1),m.getNumStation(temp).get(0));

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
		assertEquals(2, chemin.getNbChangement());
		assertEquals(130, chemin.getDureeChemin());
		
		m.getStations().get(4).ouvrirStation();	// ouverture de la station E
		m.getStations().get(2).getVoie(m.getStations().get(3)).setEnCirculation(false); //Fermeture de la voie entre C et D
		
		chemin = m.getMoinsChangementChemin(m.getStations().get(0), m.getStations().get(5));
		assertEquals(2, chemin.getNbChangement());
		assertEquals(130, chemin.getDureeChemin());
		
	}

}
