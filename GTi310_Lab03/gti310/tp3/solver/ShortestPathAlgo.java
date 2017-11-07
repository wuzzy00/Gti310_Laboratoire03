package gti310.tp3.solver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

import gti310.tp3.parser.Maze;
import gti310.tp3.parser.MazeLine;

public class ShortestPathAlgo implements Solver{

	@Override
	public Object solve(Object input) {
		
		
		return null;
	}
	public static void initializeSource(Maze maze, MazeLine mazeLine) {
		mazeLine.setweight(0);
		
		Set<MazeLine> unsettleMazeline = new HashSet<>();
		Set<MazeLine> settleMazeline = new HashSet<>();
		
		unsettleMazeline.add(mazeLine);
		
		while(unsettleMazeline.size() != 0) {
			MazeLine tmp = getLowestDistance(unsettleMazeline);
			unsettleMazeline.remove(tmp);
			for(Entry < MazeLine, Integer> adjacencyPair :
				tmp.getDestination()){
				MazeLine adjLine = adjacencyPair.getKey();
				int weight = adjacencyPair.getvalue();
				if (!settleMazeline.contains(adjLine)) {
					CalculateMinimumDistance(adjLine, weight, tmp);
					unsettleMazeline.add(adjLine);
				}
				
			}
			settleMazeline.add(tmp);
	}
			
		
	}
	private static MazeLine getLowestDistance(Set < MazeLine > unsettledMazeline){
		MazeLine lowest = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (MazeLine mazeLine: unsettledMazeline) {
			int distance = mazeLine.getweight();
			if (distance < lowestDistance) {
				lowestDistance = distance;
				lowest = mazeLine;
			}
		}
		return lowest;
	}
	private void relax() {
		
	}
	private static void CalculateMinimumDistance(MazeLine evaluationMaze,
			  Integer edgeWeigh, MazeLine sourceMaze) {
			    Integer sourceDistance = sourceMaze.getweight();
			    if (sourceDistance + edgeWeigh < evaluationMaze.getweight()) {
			        evaluationMaze.setweight(sourceDistance + edgeWeigh);
			        LinkedList<MazeLine> shortestPath = new LinkedList<>();
			        shortestPath.add(sourceMaze);
			        evaluationMaze.setShortestPath(shortestPath);
			    }
			}
	

}
