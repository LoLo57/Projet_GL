import java.util.ArrayList;
import java.util.Iterator;


public class Station {
	
	private String nom;
	private int x;
	private int y;
	private ArrayList<Voie> voies;	
	
	
	public Station(String nom, int x, int y){
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.voies = new ArrayList<Voie>();
	}
	
	
	public boolean existeVoie(Voie v){
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
	
	
	public void addVoie(Voie v){
		if(existeVoie(v) == true){
			voies.add(v);
		}
	}
	
	
	public void supprimerVoie(Voie v){
		if(existeVoie(v) == true){
			voies.remove(v);
		}	
	}
	
	
	public String getNom() {
		return nom;
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public int getX() {
		return x;
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	
	public int getY() {
		return y;
	}
	
	
	public void setY(int y) {
		this.y = y;
	}
	
	
	public ArrayList<Voie> getVoies() {
		return voies;
	}
	
	
	public void setVoies(ArrayList<Voie> voies) {
		this.voies = voies;
	}
	
}
