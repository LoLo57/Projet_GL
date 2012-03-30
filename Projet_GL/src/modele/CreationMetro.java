package modele;

import java.util.ArrayList;

public class CreationMetro {
	
	private Ligne ligne_1;
	private String[] nom_station_ligne_1 = {"defense grande arche","esplanade de la defense","pont de neuilly","les sablons jardin d'aclimatation","porte maillot palais des congres","argentine","charles de gaulle etoile","george V","franklin d. roosevelt","champs elysees clemenceau grand palais","concorde","tuilerie","palais royal musee du louvre","louvre rivoli","chatelet","hotel de ville","saint paul le marais","bastille","gare de lyon","reuilly diderot","nation","porte de vincennes","saint mande","berault","chateau de vincennes"};
	private ArrayList<Station> liste_station_ligne_1;
	private int[] abscisse_stations_ligne_1 = {50,150,170,200,220,300,400,470,500,550,600,600,650,690,710,730,780,800,830,900,950,1000,1050,1100,1200};
	private int[] ordonnee_stations_ligne_1 = {50,100,150,200,250,320,440,470,510,540,580,620,650,680,730,750,780,810,860,920,970,1000,1090,1150,1200};
	
	public CreationMetro(){
		liste_station_ligne_1 = new ArrayList<Station>();
		String sta;
		for(int i=0 ; i<nom_station_ligne_1.length ; i++){
			sta = nom_station_ligne_1[i];
			liste_station_ligne_1.add(new Station(sta, abscisse_stations_ligne_1[i], ordonnee_stations_ligne_1[i]));
		}
		ligne_1 = new Ligne(1, liste_station_ligne_1);
	}
}
