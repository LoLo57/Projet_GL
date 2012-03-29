package modele;

public class Voie {
	private int num;
	private int duree;
	private boolean enCirculation;
	
	
	public Voie(int num, int duree){
		this.num = num;
		this.duree = duree;
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
