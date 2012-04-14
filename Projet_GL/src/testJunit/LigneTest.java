package testJunit;

import java.awt.Color;
import java.util.ArrayList;

import modele.Ligne;
import modele.Station;
import junit.framework.TestCase;

/**
 * Test des lignes
 * @author vherrmann
 *
 */
public class LigneTest extends TestCase{
	
	private Ligne instance_ligne;
	private Station instance_station1;
	private Station instance_station2;
	
	public void setUp(){
		ArrayList<Station> l_stat = new ArrayList<Station>();
		instance_station1 = new Station("Defense", 148, 23, 60);
		l_stat.add(instance_station1);
		instance_ligne = new Ligne(1, l_stat, Color.red);
		instance_station2 = new Station("Chatelet", 432, 156, 40);
	}
	
	public void testExiste(){
		assertEquals(true, instance_ligne.existeStation(instance_station1));
		assertEquals(false, instance_ligne.existeStation(instance_station2));
		instance_ligne.addStation(instance_station2);
		assertEquals(true, instance_ligne.existeStation(instance_station2));
		assertEquals(false, instance_ligne.existeStation(null));
	}
	
	public void testDeleteStation(){
		assertEquals(true, instance_ligne.existeStation(instance_station1));
		instance_ligne.deleteStation(instance_station1);
		assertEquals(false, instance_ligne.existeStation(instance_station1));
		instance_ligne.deleteStation(null);
	}
	
	public void testGetNbStation(){
		assertEquals(1, instance_ligne.getNbStations());
		
		instance_ligne.addStation(instance_station2);
		assertEquals(2, instance_ligne.getNbStations());
		
		instance_ligne.deleteStation(instance_station1);
		assertEquals(1, instance_ligne.getNbStations());
		
		instance_ligne.deleteStation(instance_station2);
		assertEquals(0, instance_ligne.getNbStations());
	}

}
