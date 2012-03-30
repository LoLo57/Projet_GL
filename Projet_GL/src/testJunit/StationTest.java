package testJunit;

import junit.framework.TestCase;
import modele.Station;
import modele.Voie;

import org.junit.Test;

public class StationTest extends TestCase{
	private Station instance_station;
	private Voie instance_voie1;
	private Voie instance_voie2;
	
	public void setUp(){
		instance_station = new Station("test", 1, 1);
		instance_voie1 = new Voie(1, 120, 1);
		instance_voie2 = new Voie(2, 120, 2);
	}

	
	/*
	 * Test de la methode existeVoie()
	 */
	@Test
	public void testExiste() {
		instance_station.addVoie(instance_voie1);
		assertEquals(true, instance_station.existeVoie(instance_voie1));
		assertEquals(false, instance_station.existeVoie(instance_voie2));
	}
	

	
	/*
	 * Test de la methode getNbVoies
	 */
	@Test
	public void testGetNbVoies() {		
		assertEquals(0, instance_station.getNbVoies());
		
		instance_station.addVoie(instance_voie1);
		assertEquals(1, instance_station.getNbVoies());
		
		instance_station.addVoie(instance_voie2);
		assertEquals(2, instance_station.getNbVoies());
		
		instance_station.deleteVoie(instance_voie1);
		assertEquals(1, instance_station.getNbVoies());

	}

}
