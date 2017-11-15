package gti310.tp3.parser;

import java.util.ArrayList;

public class Sommet {

	private String nom; //pour le nom du sommet... Actuel
	private ArrayList<Arrete> listArrete = new ArrayList<Arrete>(); //Liste des arrete partant de courant � x
	private boolean visite;//S'il a ete visite
	//private int arretesDoiventEtreVisite = 0;//Variable qui m'indique cmb de fois un sommet a �t� visit�

	public Sommet(String nom){
		this.nom = nom;
		listArrete.clear();//LA liste des arretes doit etre vide
		visite = false;
	}

	/** Methode qui sert � ajouter une arrete � un Sommet */
	public void ajouterArrete(Arrete arrete){
		listArrete.add(arrete);
	}
	
	/** M�thode qui indique le prochain arrete a visiter */
	/*public int getNextArrete(){
		int n = getListArrete().size();
		int c = 0;
		
		for(int i =0; i<getListArrete().size(); i++){
			if(getListArrete().get(i).getCmbVisite() == 0){//Prendre le premier arrete 
				return i;
			}else if(){
				
			}
		}
	}*/

	/** M�thode qui m'indique si le noeud passer en parametre est le parent */
	/*public boolean isParent(Sommet som){
		if(som.getNom().equalsIgnoreCase(this.getNom()))
			return true;
		else
			return false;
	}*/

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

	public ArrayList<Arrete> getListArrete() {
		return listArrete;
	}
	public void setListArrete(ArrayList<Arrete> listArrete) {
		this.listArrete = listArrete;
	}

	/*public int getArretesDoiventEtreVisite() {
		return arretesDoiventEtreVisite;
	}
	public void setArretesDoiventEtreVisite(int arretesDoiventEtreVisite) {
		this.arretesDoiventEtreVisite = arretesDoiventEtreVisite;
	}*/

	
	
	


}
