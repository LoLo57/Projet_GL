package testJunit;

import modele.Ligne;
import modele.Station;
import junit.framework.TestCase;

public class LigneTest extends TestCase{
	
	private Ligne instance_ligne;
	private Station instance_station1;
	private Station instance_station2;
	
	public void setUp(){
		instance_ligne = new Ligne(1);
		instance_station1 = new Station("Defense", 148, 23);
		instance_station2 = new Station("Chatelet", 432, 156);
	}
	
	public void testExiste(){
		instance_ligne.addStation(instance_station1);
		assertEquals(true, instance_ligne.existeStation(instance_station1));
		assertEquals(false, instance_ligne.existeStation(instance_station2));
	}
	
	public void testGetNbStation(){
		assertEquals(0, instance_ligne.getNbStations());
		
		instance_ligne.addStation(instance_station1);
		assertEquals(1, instance_ligne.getNbStations());
		
		instance_ligne.addStation(instance_station2);
		assertEquals(2, instance_ligne.getNbStations());
		
		instance_ligne.deleteStation(instance_station1);
		assertEquals(1, instance_ligne.getNbStations());
	}

}
