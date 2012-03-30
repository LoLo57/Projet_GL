package modele;

public class Voie {
	/*
	 * Pour le numéro de voie voir pour faire un compteur static
	 * pour a chaque nouvelle instance on incremente de 1 ?
	 */
	private int num;
	private int duree; //duree en secondes
	private boolean enCirculation;
	private int numero_ligne;
	
	
	public Voie(int num, int duree, int ligne){
		this.num = num;
		this.duree =(int) Math.random()*300;
		this.enCirculation = true;
		this.numero_ligne = ligne;
	}
	
	public int getNumeroLigne(){
		return this.numero_ligne;
	}
	
	public int getNum() {
		return num;
	}
	
	
	public void setNum(int num) {
		this.num = num;
	}
	
	
	public int getDuree() {
		return duree;
	}
	
	
	public void setDuree(int duree) {
		this.duree = duree;
	}


	public boolean isEnCirculation() {
		return enCirculation;
	}


	public void setEnCirculation(boolean enCirculation) {
		this.enCirculation = enCirculation;
	}

}
