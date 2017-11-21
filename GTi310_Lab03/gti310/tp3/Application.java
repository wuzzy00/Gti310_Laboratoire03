package gti310.tp3;

import java.io.IOException;
import java.util.ArrayList;

import gti310.tp3.parser.ConcreteParser;
import gti310.tp3.parser.Maze;
import gti310.tp3.parser.Sommet;
import gti310.tp3.solver.ConcreteSolver;

/**
 * The Application class defines a template method to call the elements to
 * solve the problem Unreal-Networks is façing.
 * 
 * @author François Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class Application {

	/**
	 * The Application's entry point.
	 * 
	 * The main method makes a series of calls to find a solution to the
	 * problem. The program awaits two arguments, the complete path to the
	 * input file, and the complete path to the output file.
	 * 
	 * @param args The array containing the arguments to the files.
	 */
	public static void main(String args[]) {
		String cFile = "C:\\Users\\innoc\\Documents\\School\\Technologie de linformation\\A2017\\GTI310\\Repo\\GTi310_Lab03\\test.txt" ;

		ConcreteParser cp = new ConcreteParser();
		ConcreteSolver<Maze,ArrayList<String>> cs; //T, E
		ArrayList<String> resultats;

		try {
			cp.parse(cFile);
			cs = new ConcreteSolver<Maze,ArrayList<String> >();
			resultats = cs.solve(cp.getMaze());
			
			//for(int i =0; i<resultats.size(); i++)
				//System.out.println(resultats.get(i));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
