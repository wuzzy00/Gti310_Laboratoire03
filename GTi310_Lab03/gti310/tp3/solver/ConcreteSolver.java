package gti310.tp3.solver;

import gti310.tp3.parser.Arrete;
import gti310.tp3.parser.Maze;
import gti310.tp3.parser.Sommet;
import java.util.ArrayList;


public class ConcreteSolver<E, T> implements Solver<E, T>{
	
	private static ArrayList<Sommet> graphe = new ArrayList<Sommet>();//ArrayListe contenant le grape
	private boolean initGraphe = true;//Boolean Indiquant la premiere fois qu'on entre dans le graphe.

	private ArrayList<String> resultats = new ArrayList<String>();//ArrayList contenant les chaines de resultats
	private int nbSommetParcouru = 0;//Variables qui m'indique cmb de sommet j'ai parcouru dans mon graphe

	private ArrayList<Sommet>  sommetVisite = new ArrayList<Sommet>(); //Array contenant le Chemin Emprunter
	private static Sommet sommetDeDepart;//Sauvegarder le sommet de départ
	private boolean retournerAuDepart = false; //Retourner au sommet de depart apres avoir visité tout les noeuds
	private int indexFinDeVisite = -1;//Variable qui m'indique à partir de quand je commence à retourner au départ.
	private boolean sommetCompletementExplorer = false;
	

	/** Méthode qui sert à créer mon Graphe Avec l'objet Maze 
	 * @param object Maze contenant les lignes du graphe
	 * Complexite O(6N^2)
	 * */
	@SuppressWarnings("unchecked")
	public T solve(E input) {
		Maze maze = (Maze)input;
		Sommet tmpSommet = null;
		Arrete tmpArrete = null;
		String sommetDepart = null;
		String sommetArrive = null;
		float cout = 0.0f;
		float coutDefaut = 0.0f;

		/* Parcourir le nombres de mazeLine que j'ai */
		for(int i =0; i<maze.getMazeLine().size(); i++){

			sommetDepart = maze.getMazeLine().get(i).getSource();
			sommetArrive = maze.getMazeLine().get(i).getDestination();

			//Garder tout les couts à 0 pour permettre de visiter tout les noeuds
			coutDefaut=cout = maze.getMazeLine().get(i).getweight();

			tmpSommet = new Sommet(sommetDepart);
			tmpArrete = new Arrete(cout, sommetArrive/*new Sommet(sommetArrive)*/);
			tmpArrete.setCoutDefaut(coutDefaut);

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
		ResoudreGraphe();
		resultats = getOnlyOrigin(resultats, sommetDepart);
		return (T) resultats;
	}
	
	/** Méthode qui parcour le nombre de sommet du graphe
	 * Complexiter O(N)
	 */
	public void ResoudreGraphe(){

		for(int i =0; i<graphe.size(); i++){//Appeller la fonction à partir de tout les Sommet de la file
			Sommet depart = graphe.get(i);//Set Sommet De depart
			sommetDeDepart = depart;
			sommetCompletementExplorer = false;
			
			explorer(depart);
			ResetGrapheWeight();
		}

	}

	/** Méthode principale, explorer le graphe de maniere récursive 
	 * @param sommet à partir duquel ont commence l'exploration
	 * Complexite: O(N^2)
	 */
	public void explorer(Sommet s){
		Arrete aDestination;
		int index,idxSource;
		Sommet tmpSommet;

		
		try{
			if(!possede(sommetVisite, s)){//Augmenter le nbSommetPArcouru seulement si on ne parcour pas le mëme sommet 2 fois
				nbSommetParcouru++;
			}
		}catch(StackOverflowError e){
			ResetInitVars();
			ResetGrapheVisite();
			sommetCompletementExplorer = true;
			return ;	
		}
		
		sommetVisite.add(s);//Ajouter le sommet a ma liste

		for(int i =0; i< sommetVisite.size(); i++)

			//Fixer la chaine à partir de la prochaine rentrer
			if(nbSommetParcouru == graphe.size() && retournerAuDepart){
				fixExplorer(s.getNom(),indexFinDeVisite);
			}else{//Fixer la chaine à partir du début
				
				try{
					fixExplorer(s.getNom(),1);
				}catch(StackOverflowError e){
					ResetInitVars();
					ResetGrapheVisite();
					sommetCompletementExplorer = true;
					return ;	
				}
								
			}
		//Cherche le noeud de depart
		if(nbSommetParcouru == graphe.size() && retournerAuDepart==false){
			indexFinDeVisite = sommetVisite.size();
			retournerAuDepart = true;

		}

		//Condition d'arrêt
		if(nbSommetParcouru == graphe.size() && nbSommetParcouru>1 && s.getNom().equalsIgnoreCase(sommetDeDepart.getNom())){
			String tmp = "";

			for(int i =0; i<sommetVisite.size(); i++){
				tmp += sommetVisite.get(i).getNom() + " "; 
			}
			//Sortir de la récurSive
			if(resultats.contains(tmp)){
				ResetInitVars();
				sommetCompletementExplorer = true;
				return ;
			}else
				resultats.add(tmp);

			//Clear et recommencer
			s = sommetDeDepart;

			ResetInitVars();
			explorer(s);
		}

		if(!sommetCompletementExplorer){
			index = s.plusPetitPoids(retournerAuDepart);// l'index d'arrete à prendre
			String NomSomm = s.getListArrete().get(index).getSommetArrive();//Nom du sommet d'arriver à prendre

			idxSource = getIndexGrapheSommetFromName(s.getNom());

			//Ajuster le sens courant
			aDestination = graphe.get(idxSource).getListArrete().get(index);
			graphe.get(idxSource).setCoutUnirectionnel(aDestination);

			//Ajuster le sens inverse
			idxSource = getIndexGrapheSommetFromName(NomSomm);

			tmpSommet = graphe.get(idxSource);
			s = tmpSommet;
			graphe.get(idxSource).setVisite(true);//
			explorer(s);
		}

	}

	/** Arranger la String de data quand on veut retourner au point de depart 
	 * @param nom de sommet rechercher
	 * @param index à partir duquel on cherche dans le tableau
	 * Complexite : O(N^2)
	 */
	public void fixExplorer(String nom, int indexDeVerification){

		boolean premierIndex = true;
		int index = -1;
		int cycleDeSortie = 0;
		for(int i = indexDeVerification; i<sommetVisite.size(); i++){
			if(sommetVisite.get(i).getNom().equalsIgnoreCase(nom)){

				if(premierIndex){
					index = i;
					premierIndex = false;
				}

				cycleDeSortie++;
			}
		}

		if(cycleDeSortie>=2){

			for(int i =sommetVisite.size()-1; i>index; i--){
				Sommet tmp = new Sommet(sommetVisite.get(i).getNom());
				sommetVisite.remove(i);

				boolean contient = possede(sommetVisite, tmp);
				if(!contient){
					nbSommetParcouru--;
				}

			}
		}
	}

	/** Réinitialiser le poids des arrêtes 
	 * Complexite O(N^2)
	 */
	public void ResetGrapheWeight(){
		for(int i =0; i<graphe.size(); i++){

			for(int j = 0; j<graphe.get(i).getListArrete().size(); j++){
				graphe.get(i).getListArrete().get(j).setCout(graphe.get(i).getListArrete().get(j).getCoutDefaut());
			}
		}
	}

	/** Réinitialiser les sommets visité 
	 * Complexite O(N)
	 */
	public void ResetGrapheVisite(){
		for(int i =0; i<graphe.size(); i++){
				graphe.get(i).setVisite(false);
		}
	}

	/** Méthode qui réinitialise les valeurs de départ 
	 * Complexite O(1)
	 */
	public void ResetInitVars(){
		sommetVisite.clear();
		retournerAuDepart = false;
		indexFinDeVisite = -1;
		nbSommetParcouru = 0;
	}

	/** Incrementer le nombre de sommets seulement s'i le sommet n'est pas déja dans le Array 
	 * Complexite O(1)
	 */
	public boolean IncrementerSommetParcouru(Sommet s){
		if(!sommetVisite.contains(s)){
			nbSommetParcouru++;
			return true;
		}else
			return false;
	}

	/**Méthode qui m'indique si tout les sommets de mon graphe on été Explorer
	* Complexite O(1)
	 * */
	public boolean ToutLesSommetsSonPartiellementExplorer(){
		if(nbSommetParcouru == graphe.size())
			return true;
		else
			return false;
	}

	/** Méthode qui m'indique quel Sommet dans mon graphe contient
	 * le même nom qu'une arrete
	 */
	public static int getIndexGrapheSommetFromName(String s){
		for(int j =0; j<graphe.size(); j++){
			if(graphe.get(j).getNom().equalsIgnoreCase(s))
				return j;
		}
		return -1;
	}

	/** Méthode qui m'indique quel Sommet dans mon graphe contient
	 * le même nom qu'une arrete
	 * @param Sommet à partir duquel on veut l'index
	 *  Complexite O(N)
	 */
	public int getSommetFromArrete(Sommet s){
		for(int j =0; j<graphe.size(); j++){
			if(graphe.get(j).getNom().equalsIgnoreCase(s.getNom()))
				return j;
		}
		return -1;
	}

	/** Méthode qui m'indique si un array possède un Sommet x 
	 * @param ArrayList avec lequel on effectue la recherche 
	 * @param sommet rechercher
	 *  Complexite O(N)
	 * */
	public boolean possede(ArrayList<Sommet> tmpGraphe, Sommet x){
		for(int i =0; i<tmpGraphe.size(); i++){
			boolean memeNom = tmpGraphe.get(i).getNom().trim().equalsIgnoreCase(x.getNom().trim());
			if(memeNom)
				return true;
		}

		return false;
	}


	/** Méthode qui affiche mon array de résultats de chemin parcourue
	 *  Complexite O(N) 
	 */
	public void showResultats(){
		for(int i =0; i<resultats.size(); i++){
			System.out.println(resultats.get(i));
		}
	}
	

	/** Méthode Servant a afficher le graphe(visuel pour tester) 
	 * *  Complexite O(N^2)
	*/
	public void showGraphe(){
		String chaine = graphe.size() + " Sommets\n\n";

		for(int i =0; i<graphe.size(); i++){
			chaine += "Origine : " + graphe.get(i).getNom() + "\n";
			for(int j = 0; j<graphe.get(i).getListArrete().size(); j++){
				chaine += " Poids (" + graphe.get(i).getListArrete().get(j).getCout() + ") Destination :" + graphe.get(i).getListArrete().get(j).getSommetArrive() + "\n";
			}
		}
		System.out.println(chaine);
	}
	/**
	 * Methode qui permet de reourner seuleument les chemins partant de l'origine
	 * @param notfilter
	 * @param sommetDepart
	 * @return ArrayList
	 * Complexite O(N)
	 */
	private ArrayList<String> getOnlyOrigin(ArrayList<String> notfilter , String sommetDepart) {
		ArrayList<String> filter = new ArrayList<>();
		for(int i = 0 ; i < notfilter.size() ; i++) {
			if(notfilter.get(i).startsWith(sommetDepart)){
				filter.add(notfilter.get(i));
			}
		}
		return filter;
	}
	/** Getters and setters */
	public static ArrayList<Sommet> getGraphe() {
		return graphe;
	}
	
	public void setGraphe(ArrayList<Sommet> graphe) {
		this.graphe = graphe;
	}

	public static Sommet getSommetDeDepart() {
		return sommetDeDepart;
	}
	public void setSommetDeDepart(Sommet sommetDeDepart) {
		this.sommetDeDepart = sommetDeDepart;
	}
	
	

}
