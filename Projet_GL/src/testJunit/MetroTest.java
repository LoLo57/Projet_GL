package testJunit;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import modele.Chemin;
import modele.Ligne;
import modele.Metro;
import modele.Station;


public class MetroTest extends TestCase{

	private Metro m;
	
	public void setUp(){
Station A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P;
		
		A = new Station("Monceau", 50, 90, 10);
		B = new Station("Champs de Mars", 200, 140, 10);
		C = new Station("Ecole Militaire", 300, 240, 10);
		D = new Station("Porte de Vincent", 400, 340, 10);
		E = new Station("Quatre-Septembre", 100, 240, 10);
		F = new Station("Richard-Lenoir", 100, 340, 10);
		G = new Station("Rue des Boulets", 400, 140, 10);
		H = new Station("Maison Blanche", 500, 240, 10);
		I = new Station("Rue de la Pompe", 300, 440, 10);
		J = new Station("Invalides", 500, 440, 10);
		K = new Station("Liberté", 650, 490, 10);
		L = new Station("Rome", 50, 440, 10);
		M = new Station("Duroc", 300, 340, 10);
		N = new Station("Alésia", 600, 90, 10);
		O = new Station("Alexandre Dumas", 650, 290, 10);
		P = new Station("Dupleix", 700, 190, 10);
		
		ArrayList<Station> stations = new ArrayList<Station>();
		
		stations.add(A);
		stations.add(B);
		stations.add(C);
		stations.add(D);
		stations.add(E);
		stations.add(F);
		stations.add(G);
		stations.add(H);
		stations.add(I);
		stations.add(J);
		stations.add(K);
		stations.add(L);
		stations.add(M);
		stations.add(N);
		stations.add(O);
		stations.add(P);
		
		
		//instanciation des voies (pour le moment chaque voie dure 20 min)
		A.addVoie(B, 1, 20);
		B.addVoie(C, 2, 20);
		C.addVoie(D, 3, 20);
		D.addVoie(J, 4, 20);
		E.addVoie(F, 5, 20);
		F.addVoie(I, 6, 20);
		I.addVoie(J, 7, 20);
		E.addVoie(B, 8, 20);
		B.addVoie(G, 9, 20);
		G.addVoie(H, 10, 20);
		H.addVoie(O, 11, 20);
		J.addVoie(K, 12, 20);
		J.addVoie(O, 13, 20);
		L.addVoie(F, 14, 20);
		F.addVoie(M, 15, 20);
		M.addVoie(D, 16, 20);
		D.addVoie(H, 17, 20);
		H.addVoie(N, 18, 20);
		M.addVoie(C, 19, 20);
		C.addVoie(G, 20, 20);
		G.addVoie(N, 21, 20);
		N.addVoie(P, 22, 20);
		P.addVoie(O, 23, 20);
		
		
		//instanciation des lignes
		Ligne un, deux, trois, quatre, cinq;
		un = new Ligne(1, null, Color.green);
		deux = new Ligne(2, null, Color.orange);
		trois = new Ligne(3, null, Color.blue);
		quatre = new Ligne(4, null, Color.MAGENTA);
		cinq = new Ligne(5, null, Color.black);
		
		un.addStation(A);
		un.addStation(B);
		un.addStation(C);
		un.addStation(D);
		un.addStation(J);
		un.addStation(O);
		deux.addStation(E);
		deux.addStation(F);
		deux.addStation(I);
		deux.addStation(J);
		deux.addStation(K);
		trois.addStation(E);
		trois.addStation(B);
		trois.addStation(G);
		trois.addStation(H);
		trois.addStation(O);
		quatre.addStation(L);
		quatre.addStation(F);
		quatre.addStation(M);
		quatre.addStation(D);
		quatre.addStation(H);
		quatre.addStation(N);
		cinq.addStation(M);
		cinq.addStation(C);
		cinq.addStation(G);
		cinq.addStation(N);
		cinq.addStation(P);
		cinq.addStation(O);
		
		ArrayList<Ligne> tmp = new ArrayList<Ligne>();
		tmp.add(un);
		tmp.add(deux);
		tmp.add(trois);
		tmp.add(quatre);
		tmp.add(cinq);
		
		this.m = new Metro(tmp, stations);
		
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
