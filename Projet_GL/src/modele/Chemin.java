package modele;

import java.util.ArrayList;

/**
 * Le classe représente un chemin entre 2 stations
 * Elle liste l'ensemble des stations du chemin
 * la durée du trajet ainsi que le nombre de changement
 *
 */
public class Chemin {
	
	private ArrayList<Station> chemin;
	private int dureeChemin, nbChangement;
	private Metro metro;
	
	/**
	 * La duree et le nombre de changement valent 0 a la creation
	 */
	public Chemin(Metro m) {
		if(m != null) metro = m;
		chemin = new ArrayList<Station>();
		dureeChemin = 0;
		nbChangement = 0;
	}
	
	/**
	 * Ajoute une station au chemin
	 * Met a jour la duree du chemin et le nombre de changements
	 * @param s la station a ajouter
	 */
	public void ajouterStation(Station s) {
		if(s == null) return;
		chemin.add(s);
		dureeChemin += s.getTempsArret(); // Le temps d'arret a la station compte dans la duree du chemin
		
		// Recherche d'un eventuel changement
		if(chemin.size() <= 1) return;
		
		dureeChemin += chemin.get(chemin.size()-2).getVoie(s).getDuree();
		ArrayList<Ligne> lignesS = metro.getLignesStation(s);
		ArrayList<Ligne> lignesS1, lignesS2;
		boolean changement = true;
		if(chemin.size() == 2) {
			lignesS1 = metro.getLignesStation(chemin.get(chemin.size() - 2));
			for(Ligne ligne : lignesS) {
				if(lignesS1.contains(ligne)) {
					changement = false;
					break;
				}
			}
		} else {
			lignesS1 = metro.getLignesStation(chemin.get(chemin.size() - 2));
			lignesS2 = metro.getLignesStation(chemin.get(chemin.size() - 3));
			for(Ligne ligne : lignesS) {
				if(lignesS1.contains(ligne) && lignesS2.contains(ligne)) {
					changement = false;
					break;
				}
			}
		}
		if(changement) nbChangement ++;
		
	}
	
	public Chemin clone() {
		Chemin c = new Chemin(metro);
		c.chemin = new ArrayList<Station>(chemin);
		c.dureeChemin = dureeChemin;
		c.nbChangement = nbChangement;
		return c;
		
	}

	/**
	 * @return the chemin
	 */
	public ArrayList<Station> getChemin() {
		return chemin;
	}

	/**
	 * @return the dureeChemin
	 */
	public int getDureeChemin() {
		return dureeChemin;
	}

	/**
	 * @return the nbChangement
	 */
	public int getNbChangement() {
		return nbChangement;
	}

}
