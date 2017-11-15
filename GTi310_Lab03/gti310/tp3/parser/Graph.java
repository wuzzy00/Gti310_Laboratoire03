package gti310.tp3.parser;

import java.util.LinkedList;

public class Graph {
	private int nbSommet;
	
	private static LinkedList<Integer> adjacent[];
	
	
	public Graph(int nbSommet) {
		this.nbSommet = nbSommet;
		this.adjacent = new LinkedList[nbSommet];
		for (int i = 0; i < nbSommet; i++) 
			adjacent[i] = new LinkedList();
		
	}
	public void AjouterArrete(int Sommet1 ,int Sommet2) {
		adjacent[Sommet1 - 1].add(Sommet2 - 1);
	}
	
	public int getNbSommet() {
		return nbSommet;
	}
	public void setNbSommet(int nbSommet) {
		this.nbSommet = nbSommet;
	}
	public static LinkedList<Integer>[] getAdjacent() {
		return adjacent;
	}
	public static void setAdjacent(LinkedList<Integer>[] adjacent) {
		Graph.adjacent = adjacent;
	}
	private int getSommetIndex(int sommet) {
		
		for(int i = 0; i<adjacent.length ;i++ ) {
			if(adjacent[i].contains(sommet)) {
				return i;
			}
		}
		return -1;
	}
	
}
