package gti310.tp3.parser;

public class Arrete {

	private float cout;
	private Sommet sommetArrive;
	
	public Arrete(){}
	
	public Arrete(float cout, Sommet sommetArrive){
		this.cout = cout;
		this.sommetArrive = sommetArrive;
	}

	/** Getters And Setter */
	public float getCout() {
		return cout;
	}
	public void setCout(float cout) {
		this.cout = cout;
	}

	public Sommet getSommetArrive() {
		return sommetArrive;
	}
	public void setSommetArrive(Sommet sommetArrive) {
		this.sommetArrive = sommetArrive;
	}
	
	
}
