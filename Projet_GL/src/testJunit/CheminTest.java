package testJunit;

import modele.Chemin;
import modele.Ligne;
import modele.Metro;
import modele.Station;
import junit.framework.TestCase;

public class CheminTest extends TestCase {

	private Chemin chemin;
	private Metro metro;
	private Ligne ligne1, ligne2;
	
	public void setUp(){
		metro = new Metro();
		chemin = new Chemin(metro);
		ligne1 = new Ligne(1, null);
		ligne2 = new Ligne(2, null);
		metro.ajouterLigne(ligne1);
		metro.ajouterLigne(ligne2);
	}
	
	public void testAjouterStation() {
		
		assertEquals(0, chemin.getDureeChemin());
		assertEquals(0, chemin.getNbChangement());
		Station s = new Station("1", 0, 0, 40);
		ligne1.addStation(s);
		chemin.ajouterStation(s);
		chemin.ajouterStation(null);
		assertEquals(40, chemin.getDureeChemin());
		assertEquals(0, chemin.getNbChangement());
		
		Station s2 = new Station("2", 0, 0, 30);
		ligne1.addStation(s2);
		s.addVoie(s2, 0, 60);
		chemin.ajouterStation(s2);
		assertEquals(130, chemin.getDureeChemin());
		
		Station s3 = new Station("3", 0, 0, 10);
		ligne2.addStation(s3);
		s2.addVoie(s3, 10, 30);
		chemin.ajouterStation(s3);
		assertEquals(170, chemin.getDureeChemin());
		assertEquals(1, chemin.getNbChangement());
		
	}
}
