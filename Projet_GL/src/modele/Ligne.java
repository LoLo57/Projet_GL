package modele;

import java.util.ArrayList;

public class Ligne {

	private int id_ligne;
	private ArrayList<Station> stations;
	
	public Ligne(int id){
		this.id_ligne = id;
		this.stations = new ArrayList<Station>();
	}
	
	public boolean existeStation(Station s){
		for(Station st : stations){
			if(st.getNom().equals(s.getNom())){
				return true;
			}
		}
		return false;
	}
	
	public void addStation(Station s){
		if(!existeStation(s) && s!=null){
			this.stations.add(s);
		}
	}
	
	public void deleteStation(Station s){
		if(existeStation(s) && s!=null){
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
