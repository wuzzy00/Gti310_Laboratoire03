package gti310.tp3.parser;

import java.util.LinkedList;

public class Graph {
	private int nbSommet;
	
	private static LinkedList<String> adjacent[];
	
	
	public Graph(int nbSommet) {
		this.nbSommet = nbSommet;
		this.adjacent = new LinkedList[nbSommet];
		for (int i = 0; i < nbSommet; i++) 
			adjacent[i] = new LinkedList();
		
	}
	public void AjouterArrete(String Sommet1 ,String Sommet2) {
		adjacent[Integer.parseInt(Sommet1) - 1].add(Sommet2);
	}
	
	public int getNbSommet() {
		return nbSommet;
	}
	public void setNbSommet(int nbSommet) {
		this.nbSommet = nbSommet;
	}
	public static LinkedList<String>[] getAdjacent() {
		return adjacent;
	}
	public static void setAdjacent(LinkedList<String>[] adjacent) {
		Graph.adjacent = adjacent;
	}
	private int getSommetIndex(String sommet) {
		
		for(int i = 0; i<adjacent.length ;i++ ) {
			if(adjacent[i].contains(sommet)) {
				return i;
			}
		}
		return -1;
	}
	
}
