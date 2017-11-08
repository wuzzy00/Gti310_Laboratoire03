package gti310.tp3.solver;

import gti310.tp3.parser.Arrete;
import gti310.tp3.parser.Maze;
import gti310.tp3.parser.Sommet;

import java.util.ArrayList;

public class FindAllPathAlgo {

	public ArrayList<Sommet> graphe = new ArrayList<Sommet>(); 
	public boolean initGraphe = true;

	/** Méthode qui sert à créer mon Graphe */
	public void setGraphe(Maze maze){

		Sommet tmpSommet = null;
		Arrete tmpArrete = null;
		String sommetDepart = null;
		String sommetArrive = null;
		float cout = 0 ;

		/* Parcourir le nombres de mazeLine que j'ai */
		for(int i =0; i<maze.getMazeLine().size(); i++){

			sommetDepart = maze.getMazeLine().get(i).getSource();
			sommetArrive = maze.getMazeLine().get(i).getDestination();
			cout = maze.getMazeLine().get(i).getweight();

			tmpSommet = new Sommet(sommetDepart);
			tmpArrete = new Arrete(cout, new Sommet(sommetArrive));
			tmpSommet.ajouterArrete(tmpArrete);

			//Ajouter le tout premier Sommet de mon graphe
			if(initGraphe){

				graphe.add(tmpSommet);
				initGraphe = false;
			}else{

				//Parcourir mon graphe une fois et vérifier que le Sommet n'existe pas
				boolean existeDansGraphe = false;
				int quelSommet = 0;
				for(int j = 0; j<graphe.size(); j++){
					if(graphe.get(j).getNom().trim().equalsIgnoreCase(sommetDepart.trim())){
						existeDansGraphe = true;
						quelSommet = j;
					}
				}

				//S'il existe, ajouter une arrete, sinon ajouter un nouveau sommet
				if(existeDansGraphe){//Ajouter une arrete dans "Sommet.Liste"
					graphe.get(quelSommet).ajouterArrete(tmpArrete);
				}else{//Ajouter un nouveau Sommet
					graphe.add(tmpSommet);
				}
			}
		}
	}

	/** Méthode Servant a afficher le graphe(visuel pour tester)*/
	public void showGraphe(){
		String chaine = "";

		for(int i =0; i<graphe.size(); i++){
			chaine += "Origine : " + graphe.get(i).getNom();
			for(int j = 0; j<graphe.get(i).getList().size(); j++){
				chaine += " Poids (" + graphe.get(i).getList().get(j).getCout() + ") Destination :" + graphe.get(i).getList().get(j).getSommetArrive().getNom() + "\n";
			}
		}

		System.out.println(chaine);
	}

	

}
