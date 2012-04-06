package modele;

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
	private Station origine, destination;
	
	/**
	 * Creation d'une nouvelle voie
	 * @param num numero de la voie
	 * @param duree duree du trajet
	 * @param orig station de depart
	 * @param dest station d'arrivee
	 */
	public Voie(int num, int duree, Station orig, Station dest){
		this.num = num;
		this.duree = duree;
		this.enCirculation = true;
		origine = orig;
		destination = dest;
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
