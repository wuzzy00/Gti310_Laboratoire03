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
		ArrayList<Noeud> noeuds = creerListNoeud(mazeLines);
		for (Noeud noeud : noeuds) {
			System.out.println("noeuds : " + noeud.getNom());
		}
		ArrayList<String> solved = solveList(noeuds, new Noeud(input.getSomDepart()));
		for (String noeud : solved) {
			System.out.print(" " + noeud);
		}
		return null;
	}
	
	
	
	private static ArrayList<Noeud> creerListNoeud(ArrayList<MazeLine> mazeLine) {
		ArrayList<Noeud> listnoeud = new ArrayList<>();
		Noeud noeudSource = null;
		Noeud noeudDestination = null;
		boolean noeudSourceExist;
		boolean noeudDestinationExist;
		for(int i = 0 ; i < mazeLine.size() ; i++) {
			MazeLine line = mazeLine.get(i);
			if (listnoeud.isEmpty()) {
				listnoeud.add(new Noeud(line.getSource()));
				listnoeud.add(new Noeud(line.getDestination()));
				listnoeud.get(i).ajouternoeudadj(listnoeud.get(i+1), line.getweight());
			}else{
				noeudSourceExist = false;
				noeudDestinationExist = false;
				for (Noeud _nom: listnoeud ) {
					if (_nom.getNom().equals(line.getSource())) {
						noeudSource = _nom;
						noeudSourceExist = true;
					}
					if (_nom.getNom().equals(line.getDestination())) {
						noeudDestination = _nom;
						noeudDestinationExist = true;
					}
				}
				if (!noeudDestinationExist) {
					noeudDestination = new Noeud(line.getDestination());
					listnoeud.add(noeudDestination);
				}
				if (!noeudSourceExist) {
					noeudSource = new Noeud(line.getSource());
					listnoeud.add(noeudSource);
				}
				
				
				if(noeudSource != null && noeudDestination != null) {
					noeudSource.ajouternoeudadj(noeudDestination, line.getweight());
				}else {
				System.err.println("noeud non existant");
				}
			}
		}
		return listnoeud;
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
