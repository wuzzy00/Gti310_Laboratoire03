package gti310.tp3.parser;

import java.util.ArrayList;

public class Sommet {

	private String nom; //pour le nom du sommet... Actuel
	private ArrayList<Arrete> list = new ArrayList<Arrete>(); //Liste des arrete partant de courant à x
	private boolean visite;//S'il a ete visite
	
	public Sommet(String nom){
		this.nom = nom;
		list.clear();//LA liste des arretes doit etre vide
		visite = false;
	}
	
	/** Methode qui sert à ajouter une arrete à un noeud */
	public void ajouterArrete(Arrete arrete){
		list.add(arrete);
	}

	/** Getters and setter*/
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isVisite() {
		return visite;
	}
	public void setVisite(boolean visite) {
		this.visite = visite;
	}

	public ArrayList<Arrete> getList() {
		return list;
	}
	public void setList(ArrayList<Arrete> list) {
		this.list = list;
	}
	
	
}
