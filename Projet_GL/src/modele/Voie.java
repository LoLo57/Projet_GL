package modele;

public class Voie {
	/*
	 * Pour le num�ro de voie voir pour faire un compteur static
	 * pour a chaque nouvelle instance on incremente de 1 ?
	 */
	private int num;
	private int duree; //duree en secondes
	private boolean enCirculation;
	
	
	public Voie(int num, int duree){
		this.num = num;
		this.duree =(int) Math.random()*300;
		this.enCirculation = true;
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
