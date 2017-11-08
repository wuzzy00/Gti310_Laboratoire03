package gti310.tp3.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * Class servant à récupérer un fichier text le transformer ligne par ligne
 * et retourner un object contenant le data récupérer.
 * 
 * @author Innocent Windsor Junior
 */

@SuppressWarnings("rawtypes")
public class ConcreteParser implements Parser{

	/** Variable de classes */
	private Maze maze = null;
	
	@SuppressWarnings("resource")
	public Object parse(String filename) throws IOException {
		FileReader fRead = new FileReader(filename);
		BufferedReader buffRead = new BufferedReader(fRead);
		ArrayList<String> cLines = new ArrayList<String>();
		String singleLine;
		boolean goodHeader = true;
		boolean goodLines = true;
		boolean goodEOF = true;

		/* Read the file and save for analysis */
		while ((singleLine = buffRead.readLine()) != null)
			cLines.add(singleLine);					
		
		/* analyse the file and return null if validation fails*/
		String nbSum=null;
		for(int j=0; j<cLines.size()-1; j++){
			String tmp = (String) cLines.toArray()[j];
			String[] tmpSplit = tmp.split("\\s+");

			//Vérifier le header
			if(j<2){
				if(tmpSplit.length > 2)
					goodHeader = false;

				if(j==0){
					nbSum = tmpSplit[0];
					
					try {
						Integer.parseInt(nbSum);
					} catch (NumberFormatException e) {
						goodHeader = false;
					}
				}else
					maze = new Maze(nbSum, tmpSplit[0]);
			}else{
				if(tmpSplit.length != 3)
					goodLines = false;
				maze.addMazeLine(tmpSplit[0], tmpSplit[1], tmpSplit[2]);
				
			}

			String cEOF = (String) cLines.toArray()[cLines.size()-1];

			if( cEOF.trim().length() > 1 )
				goodEOF = false;

			if(!goodHeader || !goodLines || !goodEOF){
				System.out.println("ConcreteParser.parse parts good;\nHeader : " + goodHeader + "\nLines: " + goodLines + "\nEOF: " + goodEOF);
				return null;
			}
		}

		buffRead.close();		

		/*for(int j=3; j<cLines.size()-1; j++){//for(int j=0; j<cLines.size(); j++){
			String tmp = (String) cLines.toArray()[j];
			String[] tmpSplit = tmp.split("\\s+");
			System.out.println(tmp + " : : " + tmpSplit[2]);  
		}*/

		return maze;//cLines.toArray(new String[cLines.size()]);
	}

	/** Mutateurs et accesseurs */
	public Maze getMaze() {
		return maze;
	}
	public void setMaze(Maze maze) {
		this.maze = maze;
	}
}
