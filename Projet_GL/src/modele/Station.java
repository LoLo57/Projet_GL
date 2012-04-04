package modele;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Symbolise une station de métro
 * Une station à une position, des voies qui la relies à d'autres stations et elle peut être ouverte ou fermée
 * @author vherrmann
 *
 */
public class Station {
	
	private String nom;
	private ArrayList<Integer> lignes;
	private int x;
	private int y;
	private int tempsArret;
	private ArrayList<Voie> voies;
	private boolean ouverte;
	
	/**
	 * Création d'une nouvelle station
	 * @param nom nom de la station
	 * @param x abscisse de la station
	 * @param y ordonnee de la station
	 * @param arret durée d'un arret dans cette station
	 * @param numLigne numéro de la ligne sur laquelle se trouve la station
	 */
	public Station(String nom, int x, int y, int arret, int numLigne){
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.voies = new ArrayList<Voie>();
		lignes = new ArrayList<Integer>();
		lignes.add(new Integer(numLigne));
		ouverte = true;
		setTempsArret(arret);
	}
	
	/**
	 * Création d'une nouvelle station
	 * @param nom nom de la station
	 * @param x abscisse de la station
	 * @param y ordonnee de la station
	 * @param arret durée d'un arret dans cette station
	 * @param numLignes liste des numéros de lignes sur lesquelles se trouve la station
	 */
	public Station(String nom, int x, int y, int arret, ArrayList<Integer> numLignes){
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.voies = new ArrayList<Voie>();
		if(numLignes == null) lignes = new ArrayList<Integer>();
		else lignes = numLignes;
		ouverte = true;
		setTempsArret(arret);
	}
	

	/**
	 * Permet de savoir si la voie donnée en paramètre existe dans la liste des voie de la station
	 * @param v la voie dont on teste l'existence
	 * @return true si la voie existe, false sinon
	 */
	public boolean existeVoie(Voie v){
		if(v == null) return false;
		boolean existe = false;
		Iterator<Voie> i = voies.iterator();
		Voie tmp = null;

		while(i.hasNext() && existe == false){
			tmp = (Voie)i.next();
			if(tmp.getNum() == v.getNum()){
				existe = true;
			}	
		}
		return existe;
	}
	
	/**
	 * Crée une nouvelle voie entre la station this et la station donnée en paramètre
	 * @param destination la sation vers laquelle la voie va aller
	 * @param num le numéro de la voie
	 * @param duree la durée du trajet sur cette voie
	 * @param ligne la ligne de la voie
	 */
	public void addVoie(Station destination, int num, int duree, int ligne) {
		if(destination == null) return;
		Voie v = new Voie(num, duree, ligne, this, destination);
		this.addVoie(v);
		Voie v2 = new Voie(-num, duree, ligne, destination, this);
		destination.addVoie(v2);
	}
	
	/**
	 * Crée une nouvelle voie entre la station this et la station donnée en paramètre
	 * @param destination la sation vers laquelle la voie va aller
	 * @param num le numéro de la voie
	 * @param duree la durée du trajet sur cette voie
	 * @param ligne liste des numéros de lignes passant par cette voie
	 */
	public void addVoie(Station destination, int num, int duree, ArrayList<Integer> lignes) {
		if(destination == null) return;
		Voie v = new Voie(num, duree, lignes, this, destination);
		this.addVoie(v);
		Voie v2 = new Voie(-num, duree, lignes, destination, this);
		destination.addVoie(v2);
	}
	
	/**
	 * Permet d'ajouter une voie à la liste des voies de la stations
	 * @param v la voie à ajouter
	 */
	private void addVoie(Voie v){
		if(existeVoie(v) == false && v != null){
			voies.add(v);
		}
	}
	
	/**
	 * Supprimer une voie de la liste des voies de la sation
	 * Attention ne supprime pas la voie parallèle en sens inverse
	 * @param v la voie à supprimer
	 */
	public void deleteVoie(Voie v){
		if(existeVoie(v) == true && v != null){
			voies.remove(v);
		}	
	}
	
	/**
	 * Supprimer une voie de la liste des voies de la sation
	 * Supprime également la voie en sens inverse
	 * Si il n'existe qu'une des deux fois celle existante est quand même supprimée
	 * @param numVoie le numéro de la voie à supprimer
	 */
	public void deleteVoie(int numVoie){
		Voie v = getVoie(numVoie);
		if(v == null) return;
		deleteVoie(v);
		Station destination = v.getDestination();
		if(destination == null) return;
		Voie v2 = destination.getVoie(-numVoie);
		if(v2 == null) return;
		destination.deleteVoie(v2);
	}
	
	/**
	 * Retourne le nombre de voies de la stations
	 * @return le nombre de voies
	 */
	public int getNbVoies(){
		return voies.size();
	}
	
	/**
	 * Permet de savoir si la station est ouverte
	 * @return true si elle est ouverte sinon false
	 */
	public boolean isOuvert(){
		return this.ouverte;
	}
	
	/**
	 * Permet de savoir si la station est reliée à celle données en paramètre
	 * @param s la station dont on veut savoir si elle est reliée
	 * @return true si la station est reliée sinon false
	 */
	public boolean isReliee(Station station) {
		for(Voie voie : voies) {
			if(voie.getDestination().equals(station)) return true;
		}
		return false;
	}
	
	/**
	 * Permet de fermer une station
	 */
	public void fermerStation(){
		this.ouverte = false;
	}
	
	/**
	 * Permet d'ouvrir une station
	 */
	public void ouvrirStation(){
		this.ouverte = true;
	}
	
	/**
	 * Nom de la station
	 * @return nom de la station
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Permet de modifier le nom de la station
	 * @param nom nouveau nom de la station
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Abscisse de la station
	 * @return abscisse
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Permet de modifier l'abscisse de la station
	 * @param x nouvel abscisse
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Ordonnée de la station
	 * @return ordonnée
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Permet de modifier l'ordonnée de la station
	 * @param y nouvel ordonnée
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Permet de retourner la liste des voies de la station
	 * @return liste des voies
	 */
	public ArrayList<Voie> getVoies() {
		return voies;
	}
	
	/**
	 * Retourne la voie dont le numéro est donnée en paramètre
	 * @param num le numero de la voie a retourner
	 * @return la voie correspondant au numéro ou null s'il n'y en a pas
	 */
	public Voie getVoie(int num) {
		for(Voie v : voies) if(v.getNum() == num) return v;
		return null;
	}
	
	/**
	 * Permet de remplacer la liste des voies de la station
	 * @param voies nouvelle liste des voies
	 */
	public void setVoies(ArrayList<Voie> voies) {
		this.voies = voies;
	}


	/**
	 * Temps d'arret sur la station
	 * @return the tempsArret
	 */
	public int getTempsArret() {
		return tempsArret;
	}


	/**
	 * Permet de modifier le temps d'arret sur la station
	 * @param tempsArret the tempsArret to set
	 */
	public void setTempsArret(int tempsArret) {
		this.tempsArret = tempsArret;
	}
	
	
}
