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
	private int sommetDeDépart;
	
	/** Méthode servant à initialiser un object MazeHeader */
	public MazeHeader(String nbSommet, String sommetDeDépart) {
		this.nbSommet = Integer.parseInt(nbSommet);
		this.sommetDeDépart = Integer.parseInt(sommetDeDépart);
	}

	/** Mutateurs & accesseur */
	public int getNbSommet() {
		return nbSommet;
	}
	public void setNbSommet(int nbSommet) {
		this.nbSommet = nbSommet;
	}

	public int getSommetDeDépart() {
		return sommetDeDépart;
	}
	public void setSommetDeDépart(int sommetDeDépart) {
		this.sommetDeDépart = sommetDeDépart;
	}	
}
