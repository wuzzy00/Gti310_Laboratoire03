package gti310.tp3.parser;

/**
 * Class representant l'information d'une arr�te avec son co�t et sa destination
 * 
 * @author Innocent Windsor Junior
 */
public class Arrete {

	private float cout;//Cout d'une arr�te
	private float coutDefaut;//Cout par default d'une arrete, utiliser pour r�initialiser le cout
	private String sommetArrive;//Destination de l'arrete
	
	/** Contructeur par defaut*/
	public Arrete(){}
	
	/** Constructeur Initialiser une arrete, cout + destination
	 * @param cout de l'arrete
	 * @param Destination*/
	public Arrete(float cout, String sommetArrive){
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

	public String getSommetArrive() {
		return sommetArrive;
	}
	public void setSommetArrive(String sommetArrive) {
		this.sommetArrive = sommetArrive;
	}

	public float getCoutDefaut() {
		return coutDefaut;
	}
	public void setCoutDefaut(float coutDefaut) {
		this.coutDefaut = coutDefaut;
	}
	
}
