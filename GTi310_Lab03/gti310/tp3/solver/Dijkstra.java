package gti310.tp3.solver;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import gti310.tp3.parser.Maze;
import gti310.tp3.parser.MazeLine;
import sun.net.www.content.audio.basic;
import gti310.tp3.parser.Graph;

public class Dijkstra implements Solver{

	@Override
	public Object solve(Maze input) {
		ArrayList<MazeLine> mazeLines = input.getMazeLine();
		Graph graph = creerGraph(mazeLines);
		remplirGraph(graph , mazeLines);
		System.out.println(input.getSomDepart());
		rechercheEnProfondeur(input.getSomDepart(), graph);
		afficherTousLesNoueudAdj(graph);
		return null;
		
	}

	private void afficherTousLesNoueudAdj(Graph graph) {
		LinkedList<String>[] list = graph.getAdjacent();
		for(int i = 0; i<list.length ;i++ ) {
			System.out.println("\n Sommet : " + (1+i)  );
			for (String list1 :  list[i]) {
				System.out.print( "-->" + list1);
			}
		}
	}

	private void remplirGraph(Graph graph, ArrayList<MazeLine> mazeLines) {
		for (MazeLine mazeLine : mazeLines) {
			graph.AjouterArrete(mazeLine.getSource(),
					mazeLine.getDestination());
			
		}
	}

	private static Graph creerGraph(ArrayList<MazeLine> mazeLines) {
		int nbSommet = obtenirNombreSommet(mazeLines);
		System.out.println(nbSommet);
		return new Graph(nbSommet);
	}

	private static int obtenirNombreSommet(ArrayList<MazeLine> mazeLines) {
		int nbSommet = 0;
		ArrayList<Integer> sommet = new ArrayList<>();
		for (MazeLine mazeLine : mazeLines) {
			if(!sommet.contains(Integer.parseInt(mazeLine.getSource()))) {
				sommet.add(Integer.parseInt(mazeLine.getSource()));
				nbSommet++;
			}
		}
		return nbSommet;
	}
	private void rechercheEnProfondeur(String sommetDepart , Graph graph) {
		boolean visiter[] = new boolean[graph.getNbSommet()+1];
		DFSUtil(sommetDepart ,visiter , graph );
		
		
	}
	private void DFSUtil(String v,boolean visiter[], Graph graph){
	        // Mark the current node as visited and print it
			
	        visiter[Integer.parseInt(v)] = true;
	        System.out.print((Integer.parseInt(v)+1)+" ");
	        LinkedList<String>[] adjacent = graph.getAdjacent();
	        // Recur for all the vertices adjacent to this vertex
	        Iterator<String> i = adjacent[Integer.parseInt(v) -1].listIterator();
	        while (i.hasNext())
	        {
	            String n = i.next();
	            if (!visiter[Integer.parseInt(n)])
	                DFSUtil(n, visiter,graph);
	        }
	    }

}
