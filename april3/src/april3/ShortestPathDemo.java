package april3;

import java.util.LinkedList;

public class ShortestPathDemo {

	public static void main(String[] args) {
		WeightedDirectedGraph graph = new WeightedDirectedGraph(8);            

		graph.addEdge(0, 4, 0.38);
		graph.addEdge(0, 2, .26);
		graph.addEdge(4, 5, 0.35);
		graph.addEdge(4, 7, 0.37);
		graph.addEdge(5, 4, 0.35);
		graph.addEdge(5, 7, 0.28);
		graph.addEdge(7, 5, 0.1);
		graph.addEdge(2, 7, 0.34);
		graph.addEdge(7, 3, 0.39);
		graph.addEdge(5, 1, 0.22);
		graph.addEdge(1, 3, 0.29);
		graph.addEdge(3, 6, 0.52);
		graph.addEdge(6, 2, 0.4);
		graph.addEdge(6, 0, 0.58);
		graph.addEdge(6, 4, 0.93);
		
		ShortestPath sp = new ShortestPath();
		
		sp.computeShortestPath(graph, 0);
		
		LinkedList<Edge> solution = sp.getPathTo(6);
		
		for(Edge e: solution) {
			System.out.println(e);
		}
		
	}

}
