package modele;

import java.util.ArrayList;

/**
 * Symbolise le trajet entre deux stations 
 *
 */
public class Voie {
	/*
	 * Pour le numero de voie voir pour faire un compteur static
	 * pour a chaque nouvelle instance on incremente de 1 ?
	 */
	private int num;
	private int duree; //duree en minute
	private boolean enCirculation;
	private ArrayList<Integer> numero_lignes;
	private Station origine, destination;
	
	/**
	 * Creation d'une nouvelle voie
	 * @param num numero de la voie
	 * @param duree duree du trajet
	 * @param ligne ligne de la voie
	 * @param orig station de depart
	 * @param dest station d'arrivee
	 */
	public Voie(int num, int duree, int ligne, Station orig, Station dest){
		this.num = num;
		this.duree = duree;
		numero_lignes = new ArrayList<Integer>();
		numero_lignes.add(new Integer(ligne));
		this.enCirculation = true;
		origine = orig;
		destination = dest;
	}
	
	/**
	 * Creation d'une nouvelle voie
	 * @param num numero de la voie
	 * @param duree duree du trajet
	 * @param lignes liste des numeros de ligne passant par cette voie
	 * @param orig station de depart
	 * @param dest station d'arrivee
	 */
	public Voie(int num, int duree, ArrayList<Integer> lignes, Station orig, Station dest){
		this.num = num;
		this.duree = duree;
		if(lignes == null) numero_lignes = new ArrayList<Integer>();
		else numero_lignes = lignes;
		this.enCirculation = true;
		origine = orig;
		destination = dest;
	}
	
	/**
	 * Retourne la liste des numeros de lignes passant sur cette voie
	 * @return liste contenant les numeros de ligne
	 */
	public ArrayList<Integer> getNumeroLigne(){
		return this.numero_lignes;
	}
	
	public int getNum() {
		return num;
	}
	
	
	public void setNum(int num) {
		this.num = num;
	}
	
	/**
	 * Retourne la duree du trajet sur set voie
	 * @return la duree du trajet
	 */
	public int getDuree() {
		return duree;
	}
	
	/**
	 * Permet de modifier la duree du trajet
	 * @param duree la nouvelle duree
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	/**
	 * @return Station de destination de la voie
	 */
	public Station getDestination(){
		return destination;
	}
	
	/**
	 * @return Station d'origine de la voie
	 */
	public Station getOrigine(){
		return origine;
	}

	/**
	 * Permet de savoir s'il est possible de circuler sur cette voie
	 * @return true si il est possible de circuler false sinon
	 */
	public boolean isEnCirculation() {
		return enCirculation;
	}

	/**
	 * Permet de modifier la possibilite de circuler sur la voie
	 * @param enCirculation true si il est possible de circuler sinon false
	 */
	public void setEnCirculation(boolean enCirculation) {
		this.enCirculation = enCirculation;
	}

}
