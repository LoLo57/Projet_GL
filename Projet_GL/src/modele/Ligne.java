package modele;

import java.util.ArrayList;

/**
 * Une ligne est un ensemble de station reliées entre elles
 * @author vherrmann
 * 
 */
public class Ligne {

	private int id_ligne;
	private ArrayList<Station> stations;
	
	/**
	 * Permet de créer une nouvelle ligne avec son numéro et sa liste de station
	 * Si la liste de station est null elle sera initialisée vide
	 * @param id le numéro de la ligne
	 * @param stat la liste des stations de la ligne
	 */
	public Ligne(int id, ArrayList<Station> stat){
		this.id_ligne = id;
		if(stat == null) stations = new ArrayList<Station>();
		else this.stations = stat;
	}
	
	/**
	 * Permet de savoir si la sation donnée en paramètre existe sur la ligne
	 * @param s la station à tester
	 * @return true si la station existe sinon false
	 */
	public boolean existeStation(Station s){
		if(s == null) return false;
		for(Station st : stations){
			if(st != null) {
				if(st.getNom().equals(s.getNom())){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Ajoute une station sur la ligne
	 * @param s la station à ajouter
	 */
	public void addStation(Station s){
		if(s == null) return;
		if(!existeStation(s)){
			this.stations.add(s);
		}
	}
	
	/**
	 * Reture une station de la ligne
	 * @param s la station à retirer
	 */
	public void deleteStation(Station s){
		if(s == null);
		if(existeStation(s)){
			this.stations.remove(s);
		}
	}
	
	public int getNbStations(){
		return this.stations.size();
	}
	
	public int getIdLigne(){
		return this.id_ligne;
	}
	
	public ArrayList<Station> getStations(){
		return this.stations;
	}
}
