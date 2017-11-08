package gti310.tp3.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

import javax.sound.midi.Soundbank;

import gti310.tp3.parser.Maze;
import gti310.tp3.parser.MazeLine;
import gti310.tp3.parser.Noeud;

public class Dijkstra implements Solver{

	@Override
	public Object solve(Maze input) {
		ArrayList<MazeLine> mazeLines = input.getMazeLine();
		String depart = input.getSomDepart();
		ArrayList<Noeud> noeuds = creerListNoeud(mazeLines);
		for (Noeud noeud : noeuds) {
			System.out.println("noeuds : " + noeud);
		}
		return null;
	}
	
	
	public static void initializeSource(Maze maze) {
		
	}
	
	
	
	private static ArrayList<Noeud> creerListNoeud(ArrayList<MazeLine> mazeLine) {
		ArrayList<Noeud> listnoeud = new ArrayList<>();
		for(int i = 0 ; i < mazeLine.size() ; i++) {
			MazeLine line = mazeLine.get(i);
			if(!listnoeud.contains(line.getSource())) {
				listnoeud.add(new Noeud(line.getSource()));
			}else if(!listnoeud.contains(line.getDestination())){
				listnoeud.add(new Noeud(line.getDestination()));
			}
			Noeud tmp1 = listnoeud.get(Integer.parseInt(line.getSource()) - 1);
			Noeud tmp2 = listnoeud.get(Integer.parseInt(line.getDestination()) - 1);
			tmp1.ajouternoeud(tmp2, line.getweight());
		}
		return null;
	}
	
	private ArrayList<String> solveList(ArrayList<Noeud> noeuds , Noeud debut ){
		debut.setDistance(0);
		
		Set<Noeud> noeudEvaluer = new HashSet<>();
		Set<Noeud> noeudNonEvaluer = new HashSet<>();
		
		noeudNonEvaluer.add(debut);
		
		while (noeudNonEvaluer.size() != 0) {
			Noeud noeud = obtenirpluspetitedistance(noeudNonEvaluer);
			noeudNonEvaluer.remove(noeud);
			for(Entry<Noeud, Integer> adjacent:
				noeud.getNoeudadjs().entrySet()) {
				Noeud noeudAdj = adjacent.getKey();
				int cout = adjacent.getValue();
				if(!noeudEvaluer.contains(noeudAdj)) {
					calculerDistanceMinimum(noeudAdj, cout, noeud);
					noeudNonEvaluer.add(noeudAdj);
				}
			}
			noeudEvaluer.add(noeud);
			
		}
		return ordonerdonner(noeudEvaluer);
	}
//getlowestdistance
	private static Noeud obtenirpluspetitedistance(Set < Noeud > noeudNonEvaluer){
		Noeud pluspetit = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (Noeud noeud: noeudNonEvaluer) {
			int distance = noeud.getDistance();
			if (distance < lowestDistance) {
				lowestDistance = distance;
				pluspetit = noeud;
			}
		}
		return pluspetit;
	}

	
	private static void calculerDistanceMinimum(Noeud noeud1,
			  Integer coutadj, Noeud noeud2) {
			    Integer distanceSource = noeud2.getDistance();
			    if (distanceSource + coutadj < noeud1.getDistance()) {
			        noeud1.setDistance(distanceSource + coutadj);
			        LinkedList<Noeud> pluspletitedistance = new LinkedList<>();
			        pluspletitedistance.add(noeud2);
			        noeud1.setPluspetitchemin(pluspletitedistance);
			    }
			}
	private ArrayList<String> ordonerdonner(Set<Noeud> noeuds){
		ArrayList<String> cheminOrdoner = new ArrayList<>();
		for(Noeud noeud:noeuds) {
			cheminOrdoner.add(noeud.getNom());
		}
		return null;
		
	}
}
