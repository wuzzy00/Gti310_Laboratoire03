package gti310.tp3.parser;

import gti310.tp3.solver.Graphe;

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

	/** Retourne la plus courte arrete d'un sommet*/
	public int plusPetitPoids(boolean goBack){
		int index = -1;
		float coutMinimum = (float)Double.POSITIVE_INFINITY;

		if(goBack){//Si on veut retourner au point de depart
			for(int i = 0; i < listArrete.size(); i++){

				if(listArrete.get(i).getSommetArrive().equalsIgnoreCase(Graphe.sommetDeDepart)){//Si on trouve le semmet de depart on direct
					index = i;
					i = listArrete.size() + 1;//Sort 
				}else if(listArrete.get(i).getCout() < coutMinimum){
					coutMinimum = listArrete.get(i).getCout();
					index = i;
				}
			}
		}else{
			for(int i = 0; i < listArrete.size(); i++){

				if(listArrete.get(i).getCout() < coutMinimum && !listArrete.get(i).getSommetArrive().equalsIgnoreCase(Graphe.sommetDeDepart)){
					coutMinimum = listArrete.get(i).getCout();
					index = i;
				}
			}
		}

		return index;
	}

	/** Update un arrete dans les 2 sens(si applicable)*/
	public void setCoutUnirectionnel(Arrete destination){
		//Update la direction courante
		for(int i = 0; i < listArrete.size(); i++){
			if(listArrete.get(i).getSommetArrive().equalsIgnoreCase(destination.getSommetArrive())){
				float cout = (listArrete.get(i).getCout()+listArrete.get(i).getCout())*1;
				listArrete.get(i).setCout(cout);
			}
		}
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