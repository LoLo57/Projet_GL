package testJunit;

import java.util.ArrayList;

import junit.framework.TestCase;
import modele.Ligne;
import modele.Station;
import modele.Voie;

import org.junit.Test;

/**
 * Test des stations
 * @author vherrmann
 *
 */
public class StationTest extends TestCase{
	private Station instance_station1;
	private Station instance_station2;
	private Station instance_station3;
	private Ligne ligne;
	
	public void setUp(){
		ligne = new Ligne(1, null, null);
		instance_station1 = new Station("test", 1, 1, 30);
		instance_station2 = new Station("test2", 3, 2, 60);
		instance_station3 = new Station("test3", 3, 2, 60);
		instance_station1.addVoie(instance_station2, 10, 40);
		ligne.addStation(instance_station1);
		ligne.addStation(instance_station2);
	}

	
	/*
	 * Test de la methode existeVoie()
	 */
	@Test
	public void testExiste() {
		//instance_station.addVoie(instance_voie1);
		ArrayList<Voie> voies =instance_station1.getVoies();
		for(Voie v : voies) {
			assertEquals(true, instance_station1.existeVoie(v));
		}
		assertEquals(false, instance_station1.existeVoie(null));
		voies =instance_station2.getVoies();
		for(Voie v : voies) {
			assertEquals(true, instance_station2.existeVoie(v));
		}
		assertEquals(1, instance_station1.getNbVoies());
		assertEquals(1, instance_station2.getNbVoies());
	}
	
	public void testAddVoie(){
		assertEquals(true, instance_station1.getVoies().get(0).getNum() == 10);
	}
	
	public void testDeleteVoie(){
		instance_station1.deleteVoie(10);
		assertEquals(true, instance_station1.getNbVoies() == 0);
		assertEquals(true, instance_station2.getNbVoies() == 0);
	}
	
	public void testIsReliee() {
		assertEquals(true, instance_station1.isReliee(instance_station2));
		assertEquals(false, instance_station1.isReliee(null));
		assertEquals(false, instance_station1.isReliee(instance_station3));
	}
	
	/*
	 * Test de la methode getNbVoies
	 */
	@Test
	public void testGetNbVoies() {		
		assertEquals(1, instance_station1.getNbVoies());
		instance_station1.addVoie(new Station("t", 0, 0, 0), 0, 0);
		assertEquals(2, instance_station1.getNbVoies());

	}

}
