package gti310.tp3.parser;

public class Arrete {

	private float cout;
	private Sommet sommetArrive;
	//private int cmbVisite = 0; //Variable qui m'indique cmb de fois une arrete a été visité
	
	public Arrete(){}
	
	/** Initialiser une arrete, cout + destination*/
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

	/*public int getCmbVisite() {
		return cmbVisite;
	}
	public void setCmbVisite(int cmbVisite) {
		this.cmbVisite = cmbVisite;
	}*/
	
}
