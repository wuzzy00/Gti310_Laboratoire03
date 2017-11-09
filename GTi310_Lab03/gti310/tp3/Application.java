package gti310.tp3;

import java.io.IOException;

import gti310.tp3.parser.ConcreteParser;
import gti310.tp3.solver.Graphe;

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
		String cc = "C:\\Users\\innoc\\Documents\\School\\Technologie de linformation\\A2017\\GTI310\\Repo\\GTi310_Lab03\\Musee.txt" ;
		
		ConcreteParser cp = new ConcreteParser();
		Graphe fapa = new Graphe();
		try {
			cp.parse(cc);
			fapa.setGraphe(cp.getMaze());
			fapa.showGraphe();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
