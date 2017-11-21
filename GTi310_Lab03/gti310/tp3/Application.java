package gti310.tp3;

import java.io.IOException;
import java.util.ArrayList;

import gti310.tp3.parser.ConcreteParser;
import gti310.tp3.solver.Dijkstra;
import gti310.tp3.writer.ConcreteWriter;

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
		String input = args[0];
		String output = args[1];
		ConcreteWriter writer = new ConcreteWriter();
		ArrayList<String>[] test = new ArrayList[3];
		for(int i = 0 ; i < 3 ; i++) {
			test[i] = new ArrayList<>();
			test[i].add("1");
			test[i].add("2");
			test[i].add("3");
		}
		writer.write(output, test);
	}
}
