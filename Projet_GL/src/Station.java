import java.util.ArrayList;


public class Station {

	private int x;
	private int y;
	private ArrayList<Voie> voies;
	
	
	
	public void supprimerVoie(Voie v){
		
	}
	
	
	public void addVoie(Voie v){
		voies.add(v);
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
