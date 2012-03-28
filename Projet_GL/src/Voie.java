
public class Voie {
	private int num;
	private int duree;
	private Station station1;
	private Station station2;
	
	
	public Voie(int num, int duree, Station station1, Station station2){
		this.num = num;
		this.duree = duree;
		this.station1 = station1;
		this.station2 = station2;
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
	
	
	public Station getStation1() {
		return station1;
	}
	
	
	public void setStation1(Station station1) {
		this.station1 = station1;
	}
	
	
	public Station getStation2() {
		return station2;
	}
	
	
	public void setStation2(Station station2) {
		this.station2 = station2;
	}
	

}
