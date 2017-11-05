package gti310.tp3.parser;

import java.util.ArrayList;

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
	
	/** Création d'un object Maze*/
	Maze(String nbSommet, String somDepart){
		mazeHeader = new MazeHeader(nbSommet, somDepart);
		mazeLine = new ArrayList<MazeLine>();
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
	
}
