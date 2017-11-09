package gti310.tp3.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



/**
 * 
 * Class servant à récupérer un fichier text le transformer ligne par ligne
 * et retourner un array de lignes de string.
 * 
 * @author Innocent Windsor Junior
 */
public class Maze {
	
	/** Variable de class */
	private MazeHeader mazeHeader;
	private ArrayList<MazeLine> mazeLine;
	private String somDepart;
	private Set<Noeud> noeuds;
	
	

	/** Création d'un object Maze*/
	Maze(String nbSommet, String somDepart){
		this.somDepart = somDepart;
		mazeHeader = new MazeHeader(nbSommet, somDepart);
		mazeLine = new ArrayList<MazeLine>();
		noeuds = new HashSet<>();
	}
	
	/** Méthode servant à ajouter des lignes de mazeLine*/
	public void addMazeLine(String source, String destination, String weight){
		mazeLine.add(new MazeLine(source, destination, weight));
	}

	/** Mutateurs & Accesseurs */
	public MazeHeader getMazeHeader() {
		return mazeHeader;
	}
	public void setMazeHeader(MazeHeader mazeHeader) {
		this.mazeHeader = mazeHeader;
	}

	public ArrayList<MazeLine> getMazeLine() {
		return mazeLine;
	}
	public void setMazeLine(ArrayList<MazeLine> mazeLine) {
		this.mazeLine = mazeLine;
	}

	public String getSomDepart() {
		return somDepart;
	}

	public void setSomDepart(String somDepart) {
		this.somDepart = somDepart;
	}
	public void ajouternoeud(Noeud noeud) {
		this.noeuds.add(noeud);
	}
	
	public Set<Noeud> getNoeuds() {
		return noeuds;
	}

	public void setNoeuds(Set<Noeud> noeuds) {
		this.noeuds = noeuds;
	}
}
