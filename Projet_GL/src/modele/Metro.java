package modele;

import java.util.ArrayList;

/*
 * Un metro est un ensemble de Ligne
 */
public class Metro {
	
	public ArrayList<Ligne> metro;
	
	public Metro(){
		
		this.metro = initialize();	
	}
	
	/*
	 * methode qui va cree le squelette du reseau
	 */
	public ArrayList<Ligne> initialize(){
		
		//instanciation des stations (pour le moment chaque arret dure 10 min)
		Station A, B, C, D, E, F, G, H, I, J;
		ArrayList<Integer> ListB = new ArrayList<Integer>();
		ArrayList<Integer> ListE = new ArrayList<Integer>();
		ArrayList<Integer> ListJ = new ArrayList<Integer>();
		
		A = new Station("A", 50, 50, 10, 1);
		ListB.add(1);
		ListB.add(3);
		B = new Station("B", 200, 100, 10, ListB);
		C = new Station("C", 300, 200, 10, 1);
		D = new Station("D", 400, 300, 10, 1);
		ListE.add(2);
		ListE.add(3);
		E = new Station("E", 100, 200, 10, ListE);
		F = new Station("F", 100, 300, 10, 2);
		G = new Station("G", 400, 100, 10, 3);
		H = new Station("H", 500, 200, 10, 3);
		I = new Station("I", 300, 400, 10, 2);
		ListJ.add(1);
		ListJ.add(2);
		J = new Station("J", 500, 400, 10, 1);
		
		
		//instanciation des voies (pour le moment chaque voie dure 20 min)
		A.addVoie(B, 1, 20, 1);
		B.addVoie(C, 2, 20, 1);
		C.addVoie(D, 3, 20, 1);
		D.addVoie(J, 4, 20, 1);
		E.addVoie(F, 5, 20, 2);
		F.addVoie(I, 6, 20, 2);
		I.addVoie(J, 7, 20, 2);
		E.addVoie(B, 8, 20, 3);
		B.addVoie(G, 9, 20, 3);
		G.addVoie(H, 10, 20, 3);
		
		
		//instanciation des lignes
		Ligne un, deux, trois;
		un = new Ligne(1, null);
		deux = new Ligne(2, null);
		trois = new Ligne(3, null);
		
		un.addStation(A);
		un.addStation(B);
		un.addStation(C);
		un.addStation(D);
		un.addStation(J);
		deux.addStation(E);
		deux.addStation(F);
		deux.addStation(I);
		deux.addStation(J);
		trois.addStation(E);
		trois.addStation(B);
		trois.addStation(G);
		trois.addStation(H);
		
		ArrayList<Ligne> tmp = new ArrayList<Ligne>();
		tmp.add(un);
		tmp.add(deux);
		tmp.add(trois);
		
		return tmp;
	}
	
	
	/**
	* Fonction de recherche de la station la plus proche de l'utilisateur (avec geolocalisation préalable)
	* @param x
	* @param y
	* @return Station la plus proche
	*/
	public String rechercheProcheStation(int x, int y){
		//Plus grande distance possible dans le metro
		double distance=500;
		Station stationProche = null;
			for (Ligne line : metro){
				for(Station st : line.getStations()){
				if(distance > Math.sqrt(Math.pow(x - st.getX(), 2.0) + Math.pow(y - st.getY(), 2.0))){
					distance = Math.sqrt(Math.pow(x - st.getX(), 2.0) + Math.pow(y - st.getY(), 2.0));
					stationProche = st;
				}
			}
		}
		return stationProche.getNom();
	}
	
	
	public String toString(){
		return "Métro : " + metro ;
	}
	
	
	public static void main(String[]args){
		Metro m = new Metro();
		System.out.println(m);
		int x = 410;
		int y = 120;
		System.out.println("Station la plus proche de (" + x +", " + y + ") : " + m.rechercheProcheStation(x, y));
	}
	

	
	
	//Code de Loic je garde au cas ou
//	private Ligne ligne_1;
//	private String[] nom_station_ligne_1 = {"defense grande arche","esplanade de la defense","pont de neuilly","les sablons jardin d'aclimatation","porte maillot palais des congres","argentine","charles de gaulle etoile","george V","franklin d. roosevelt","champs elysees clemenceau grand palais","concorde","tuilerie","palais royal musee du louvre","louvre rivoli","chatelet","hotel de ville","saint paul le marais","bastille","gare de lyon","reuilly diderot","nation","porte de vincennes","saint mande","berault","chateau de vincennes"};
//	private ArrayList<Station> liste_station_ligne_1;
//	private int[] abscisse_stations_ligne_1 = {50,150,170,200,220,300,400,470,500,550,600,600,650,690,710,730,780,800,830,900,950,1000,1050,1100,1200};
//	private int[] ordonnee_stations_ligne_1 = {50,100,150,200,250,320,440,470,510,540,580,620,650,680,730,750,780,810,860,920,970,1000,1090,1150,1200};
//	
//	public Metro(){
//		liste_station_ligne_1 = new ArrayList<Station>();
//		String sta;
//		for(int i=0 ; i<nom_station_ligne_1.length ; i++){
//			sta = nom_station_ligne_1[i];
//			liste_station_ligne_1.add(new Station(sta, abscisse_stations_ligne_1[i], ordonnee_stations_ligne_1[i]));
//		}
//		ligne_1 = new Ligne(1, liste_station_ligne_1);
//	}
}
