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
	private int sommetDeD�part;
	
	/** M�thode servant � initialiser un object MazeHeader */
	public MazeHeader(String nbSommet, String sommetDeD�part) {
		this.nbSommet = Integer.parseInt(nbSommet);
		this.sommetDeD�part = Integer.parseInt(sommetDeD�part);
	}

	/** Mutateurs & accesseur */
	public int getNbSommet() {
		return nbSommet;
	}
	public void setNbSommet(int nbSommet) {
		this.nbSommet = nbSommet;
	}

	public int getSommetDeD�part() {
		return sommetDeD�part;
	}
	public void setSommetDeD�part(int sommetDeD�part) {
		this.sommetDeD�part = sommetDeD�part;
	}	
}
