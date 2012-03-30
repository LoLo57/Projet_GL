package testJunit;

import java.util.ArrayList;

import modele.Ligne;
import modele.Station;
import junit.framework.TestCase;

public class LigneTest extends TestCase{
	
	private Ligne instance_ligne;
	private Station instance_station1;
	private Station instance_station2;
	
	public void setUp(){
		ArrayList<Station> l_stat = new ArrayList<Station>();
		l_stat.add(instance_station1);
		l_stat.add(instance_station2);
		instance_ligne = new Ligne(1, l_stat);
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
