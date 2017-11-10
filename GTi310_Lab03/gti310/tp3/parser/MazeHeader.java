package gti310.tp3.parser;

/**
 * 
 * Class contenant l'information (header) du fichier 
 * 
 * @author Innocent Windsor Junior
 */
public class MazeHeader {
	
	/** Variables de class */
	private int nbSommet;
	private String sommetDeD�part;
	
	/** M�thode servant � initialiser un object MazeHeader */
	public MazeHeader(String nbSommet, String sommetDeD�part) {
		this.nbSommet = Integer.parseInt(nbSommet);
		this.sommetDeD�part = sommetDeD�part;
	}

	/** Mutateurs & accesseur */
	public int getNbSommet() {
		return nbSommet;
	}
	public void setNbSommet(int nbSommet) {
		this.nbSommet = nbSommet;
	}

	public String getSommetDeD�part() {
		return sommetDeD�part;
	}
	public void setSommetDeD�part(String sommetDeD�part) {
		this.sommetDeD�part = sommetDeD�part;
	}	
}
