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
	private String sommetDeDépart;
	
	/** Méthode servant à initialiser un object MazeHeader */
	public MazeHeader(String nbSommet, String sommetDeDépart) {
		this.nbSommet = Integer.parseInt(nbSommet);
		this.sommetDeDépart = sommetDeDépart;
	}

	/** Mutateurs & accesseur */
	public int getNbSommet() {
		return nbSommet;
	}
	public void setNbSommet(int nbSommet) {
		this.nbSommet = nbSommet;
	}

	public String getSommetDeDépart() {
		return sommetDeDépart;
	}
	public void setSommetDeDépart(String sommetDeDépart) {
		this.sommetDeDépart = sommetDeDépart;
	}	
}
