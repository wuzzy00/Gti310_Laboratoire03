package gti310.tp3.parser;

/**
 * 
 * Class contenant l'information (header) du fichier 
 * 
 * @author Innocent Windsor Junior
 */
public class MazeHeader {
	
	/** Variables de class */
	private String nbSommet;
	private String sommetDeD�part;
	
	/** M�thode servant � initialiser un object MazeHeader */
	public MazeHeader(String nbSommet, String sommetDeD�part) {
		this.nbSommet = nbSommet;
		this.sommetDeD�part = sommetDeD�part;
	}

	/** Mutateurs & accesseur */
	public String getNbSommet() {
		return nbSommet;
	}
	public void setNbSommet(String nbSommet) {
		this.nbSommet = nbSommet;
	}

	public String getSommetDeD�part() {
		return sommetDeD�part;
	}
	public void setSommetDeD�part(String sommetDeD�part) {
		this.sommetDeD�part = sommetDeD�part;
	}	
}
