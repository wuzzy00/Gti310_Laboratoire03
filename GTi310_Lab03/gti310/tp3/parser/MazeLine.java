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
	private int source;
	private int destination;
	private int weight;
	
	/** Méthode servant à initialiser un object MazeLine */
	MazeLine(String source, String destination, String weight){
		this.source = Integer.parseInt(source);
		this.destination = Integer.parseInt(destination);
		this.weight = Integer.parseInt(weight);
	}

	/** Mutateurs & accesseur */
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}

	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getweight() {
		return weight;
	}
	public void setweight(int weight) {
		this.weight = weight;
	}
}
