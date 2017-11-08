package gti310.tp3.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Noeud {
	private LinkedList<Noeud> pluspetitchemin;
	private String nom;
	private Map<Noeud,Integer> noeudadjs = new HashMap<>();
	private int distance = Integer.MAX_VALUE;
	
	public Noeud(String nom) {
		this.nom = nom;
	}

	public void ajouternoeud(Noeud noeud , int distance) {
		noeudadjs.put(noeud, distance);
	}


	public LinkedList<Noeud> getPluspetitchemin() {
		return pluspetitchemin;
	}



	public void setPluspetitchemin(LinkedList<Noeud> pluspetitchemin) {
		this.pluspetitchemin = pluspetitchemin;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Map<Noeud, Integer> getNoeudadjs() {
		return noeudadjs;
	}



	public void setNoeudadjs(Map<Noeud, Integer> noeudadjs) {
		this.noeudadjs = noeudadjs;
	}



	public int getDistance() {
		return distance;
	}



	public void setDistance(int distance) {
		this.distance = distance;
	}

}
