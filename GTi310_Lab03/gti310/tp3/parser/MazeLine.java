package gti310.tp3.parser;

import java.util.LinkedList;

/**
 * 
 * Class contenant les lignes(details) du fichier 
 * 
 * @author Innocent Windsor Junior
 */
public class MazeLine {

	/** Variables de class */
	private String source;
	private String destination;
	private float weight;

	/** Méthode servant à initialiser un object MazeLine 
	 * @param Source
	 * @param Destination
	 * @param poids
	 */
	MazeLine(String source, String destination, float weight){
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	/** Mutateurs & accesseur */
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public float getweight() {
		return weight;
	}
	public void setweight(float weight) {
		this.weight = weight;
	}
}
