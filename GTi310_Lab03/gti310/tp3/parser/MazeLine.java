package gti310.tp3.parser;

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
	private String weight;
	
	/** Méthode servant à initialiser un object MazeLine */
	MazeLine(String source, String destination, String weight){
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

	public String getweight() {
		return weight;
	}
	public void setweight(String weight) {
		this.weight = weight;
	}
}
