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
	private int weight;
	
	/** Méthode servant à initialiser un object MazeLine */
	MazeLine(String source, String destination, String weight){
		this.source = source;
		this.destination = destination;
		this.weight = Integer.parseInt(weight);
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

	public int getweight() {
		return weight;
	}
	public void setweight(int weight) {
		this.weight = weight;
	}
}
