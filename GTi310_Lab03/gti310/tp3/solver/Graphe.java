package gti310.tp3.solver;

import gti310.tp3.parser.Arrete;
import gti310.tp3.parser.Maze;
import gti310.tp3.parser.Sommet;

import java.util.ArrayList;

public class Graphe {

	private ArrayList<Sommet> graphe = new ArrayList<Sommet>();//ArrayListe contenant le grape
	private boolean initGraphe = true;//Boolean Indiquant la premiere fois qu'on entre dans le graphe.

	private ArrayList<String> resultats = new ArrayList<String>();//ArrayList contenant les chaines de resultats
	private boolean initResultats = true;
	
	private ArrayList<String> cChemin = new ArrayList<String>();
	//private StringBuilder cChemin = new StringBuilder();
	//private String cChemin = "";
	private int nbSommetParcouru = 0;//Variables qui m'indique cmb de sommet j'ai parcouru dans mon graphe

	private ArrayList<Sommet>  sommetVisite       = new ArrayList<Sommet>(); //Array contenant le Chemin Emprunter
	//private ArrayList<Boolean> completementVisite = new ArrayList<Boolean>();//Array mindiquant quand un sommet est completement visite

	/** Méthode qui sert à créer mon Graphe Avec l'objet Maze */
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

			//Garder tout les couts à 0 pour permettre de visiter tout les noeuds
			//cout = maze.getMazeLine().get(i).getweight();

			tmpSommet = new Sommet(sommetDepart);
			tmpArrete = new Arrete(cout, new Sommet(sommetArrive));

			//Ajouter le tout premier Sommet de mon graphe
			if(initGraphe){
				tmpSommet.ajouterArrete(tmpArrete);
				graphe.add(tmpSommet);
				initGraphe = false;
			}else{

				//Parcourir mon graphe une fois et vérifier que le Sommet n'existe pas
				boolean existeDansGraphe = false;
				int quelSommet = -1;
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
					tmpSommet.ajouterArrete(tmpArrete);
					graphe.add(tmpSommet);
				}
			}
		}

		//Set combiens de fois un sommet doit avoir été visité
		/*for(int i = 0; i<graphe.size(); i++){
			int n = graphe.get(i).getListArrete().size();
			int fact = Factorial.factorial(n);
			graphe.get(i).setArretesDoiventEtreVisite(fact);

			System.out.println(graphe.get(i).getNom() + " : " + n+" arretes, donc " +n+ "! = "  + graphe.get(i).getArretesDoiventEtreVisite() + " visites à chaque fois");
		}*/

		//showGraphe();
		ResoudreGraphe();
	}

	/** Méthode qui parcour le nombre de sommet du graphe*/
	public void ResoudreGraphe(){
		String cheminAAjouter;

		//for(int index =0; index<graphe.size(); index++){//Appeller la fonction à partir de tout les Sommet de la file
		Sommet depart = graphe.get(0);//Set Sommet De depart
		//cheminAAjouter = voirAdj(depart);//Recevoir le chemin à ajouter
		//cheminAAjouter = explorer(depart);
		//if(!cheminAAjouter.trim().isEmpty())//Ajouter un nouveau chemin a ma liste si celui si n'est pas vide
		//addDataInResultArray(cheminAAjouter);
		//}
		explorer(depart);
		//Afficher tout les chemins que j'ai
		//showResultats();
		
		//for(int i =0; i<sommetVisite.size(); i++){
			//System.out.print(sommetVisite.get(i).getNom() + "->");
		//}
		
		for(int i =0; i<cChemin.size(); i++)
			System.out.println(cChemin.get(i));
		//System.out.println( " " + graphe.size() + " : " + nbSommetParcouru );

		//Win TODO DELETE
		//for(int i = 0; i<graphe.size(); i++)
		//System.out.println(graphe.get(i).getNom() + " :: " + graphe.get(i).getListArrete().size());
	}

	//sommetVisite  completementVisite
	public void explorer(Sommet s){
		int k;//index du graphe qui contient le sommet d'une arrete

		if(initResultats){
			initResultats = false;
			sommetVisite.add(s);
			nbSommetParcouru++;
		}

		//Explorer tout les arrete à partir d'une noeuds
		for(int i = 0; i<s.getListArrete().size(); i++){

			//Verifier que cette arrete à déja été visiter
			boolean ArreteVisite = s.getListArrete().get(i).getSommetArrive().isVisite();
			//Verifier que le nom de l'arrete != le nom du sommet
			String nomDarrete = s.getListArrete().get(i).getSommetArrive().getNom();
			//Aller Prendre l'index du sommet dans mon graphe && Set s avec ce sommet
			k = getSommetFromArrete(s);
			s = graphe.get(k);

			//Variable qui contient l'arrete suivant, en forme de sommet
			Sommet sommetSuivant = s.getListArrete().get(i).getSommetArrive();

			//Variable qui m'indique si mon array De Sommet contient le chemin que je m'aprete a voir
			boolean contientS = possede(sommetVisite,sommetSuivant);

			//Variable qui m'indique si je suis a un Sommet sans arrete, ps : un sommet sans arrete n'est pas un sommet
			boolean culDeSac = getSommetFromArrete(sommetSuivant) == -1 ? true : false;

			//Variable qui m'indique si toute les arrête d'un sommet son visité
			//boolean toutVisite = ToutLesArreteDunSommetSontVisiter(s); //Pas utiliser for now

			if(s.getNom().equalsIgnoreCase("11"))
			System.out.println();
			if(culDeSac){//Cul de sac sans possibilité de recul(flèche double sens)
				System.out.println("Cul de sac, nom géré" + s.getNom());
			}else if(nbSommetParcouru == graphe.size()){
				String tmp = "";
				for(int j=0; j<sommetVisite.size(); j++){//Construire la String à ajouter dans ma liste de retours
					tmp += j== (sommetVisite.size()-1) ? sommetVisite.get(j).getNom() : (sommetVisite.get(j).getNom() + "->");
				}
				
				//Reset les valeurs
				nbSommetParcouru = 0;
				initResultats = true;
				
				cChemin.add(tmp);
				//System.out.println("DONE");
			}else if(nbSommetParcouru <= graphe.size()-1 && contientS==true && s.getListArrete().size() == 1){//Arrete pas visiter, mais on BacPédale Retourne sur le dernier sommet
				graphe.get(k).setVisite(true);
				graphe.get(k).getListArrete().get(i).getSommetArrive().setVisite(true);

				s = graphe.get(k).getListArrete().get(i).getSommetArrive();

				sommetVisite.add(s);

				boolean aEteIncrementer = IncrementerSommetParcouru(s);
				//System.out.println("First : " + nbSommetParcouru + s.getNom());
				explorer(s);
			}else if(ArreteVisite == false && !nomDarrete.equalsIgnoreCase(s.getNom()) && contientS==false ){
				graphe.get(k).setVisite(true);
				graphe.get(k).getListArrete().get(i).getSommetArrive().setVisite(true);

				s = graphe.get(k).getListArrete().get(i).getSommetArrive();
				sommetVisite.add(s);

				k = getSommetFromArrete(s);
				s = graphe.get(k);

				boolean aEteIncrementer = IncrementerSommetParcouru(s);
				//System.out.println("Second : " + nbSommetParcouru + s.getNom());
				explorer(s);
			}else if(nbSommetParcouru < graphe.size()-1 && i == s.getListArrete().size()-1 && ArreteVisite == false && contientS==true ){
				graphe.get(k).setVisite(true);
				System.out.println(s.getNom() + " , " + graphe.get(k).getListArrete().get(i).getSommetArrive().getNom());
			}

		}

		//System.out.println("Résultats temporaire : ");

		//return null;
	}



	/** Incrementer le nombre de sommets seulement s'i le sommet n'est pas déja dans le Array */
	public boolean IncrementerSommetParcouru(Sommet s){
		if(!sommetVisite.contains(s)){
			nbSommetParcouru++;
			return true;
		}else
			return false;
	}

	/**Méthode qui m'indique si tout les sommets de mon graphe on été Explorer*/
	public boolean ToutLesSommetsSonPartiellementExplorer(){
		if(nbSommetParcouru == graphe.size())
			return true;
		else
			return false;
	}

	/** Vérifié si tout les arrêtes d'un sommet son emprunter*/
	/*public boolean ToutLesArreteDunSommetSontVisiter(Sommet s){
		for(int i = 0; i< s.getListArrete().size(); i++){
			if(!s.getListArrete().get(i).getSommetArrive().isVisite())
				return false;
		}
		return true;
	}*/

	/** Méthode qui m'indique quel Sommet dans mon graphe contient
	 * le même nom qu'une arrete
	 */
	public int getSommetFromArrete(Sommet s){
		for(int j =0; j<graphe.size(); j++){
			if(graphe.get(j).getNom().equalsIgnoreCase(s.getNom()))
				return j;
		}
		return -1;
	}

	/** Méthode qui m'indique si un array possède un Sommet x */
	public boolean possede(ArrayList<Sommet> tmpGraphe, Sommet x){
		for(int i =0; i<tmpGraphe.size(); i++){
			if(tmpGraphe.get(i).getNom().trim().equalsIgnoreCase(x.getNom().trim()))
				return true;
		}

		return false;
	}

	/** Méthode qui affiche le data de mo naray de resultats*/
	/** Méthode qui ajouter une chaine au résultats de arrays */

	/** Méthode qui sert à ajouter un ligne dans mon Array de resultats */
	public void addDataInResultArray(String chaine){

		resultats.add(chaine);
	}
	/** Méthode qui affiche le array de chemin trouvé */

	/** Méthode qui me permet d'afficher mon array de resultats */

	/** Méthode qui affiche mon array de résultats de chemin parcourue*/
	public void showResultats(){
		for(int i =0; i<resultats.size(); i++){
			System.out.println(resultats.get(i) + "\n");
		}
	}

	/** Méthode Servant a afficher le graphe(visuel pour tester) */
	public void showGraphe(){
		String chaine = graphe.size() + " Sommets\n\n";

		for(int i =0; i<graphe.size(); i++){
			chaine += "Origine : " + graphe.get(i).getNom() + "\n";
			for(int j = 0; j<graphe.get(i).getListArrete().size(); j++){
				chaine += " Poids (" + graphe.get(i).getListArrete().get(j).getCout() + ") Destination :" + graphe.get(i).getListArrete().get(j).getSommetArrive().getNom() + "\n";
			}
		}

		System.out.println(chaine);
	}
	/** Getters and setters */
	public ArrayList<Sommet> getGraphe() {
		return graphe;
	}

	/** Getters & Setters */
	public void setGraphe(ArrayList<Sommet> graphe) {
		this.graphe = graphe;
	}

}
