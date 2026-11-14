package march11_2;

import java.util.LinkedList;

public class UndirectedGraph {

	private LinkedList<Integer>[] adjacencyList;
	private int num_of_edges;
	
	public UndirectedGraph(int vertices) {
		this.adjacencyList = new LinkedList[vertices];
		for(int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
		this.num_of_edges = 0;
	}
	// create an edge between v1 and v2
	public void addEdge(int vertex1, int vertex2) {
		adjacencyList[vertex1].add(vertex2);
		adjacencyList[vertex2].add(vertex1);
		num_of_edges++;
	}
	
	// print out my adjacency list
	public void printGraph() {
		for(int i = 0; i < adjacencyList.length; i++) {
			System.out.println(i + "--> " + adjacencyList[i]);
			
			
		}
	}
	
	public void removeEdge(int vertex1, int vertex2) {
		
		// check to see if edge actually exists
		if(adjacencyList[vertex2].contains(vertex1) && adjacencyList[vertex1].contains(vertex2)) {
			
			// Integer = make sure we are calling the correct remove method
			adjacencyList[vertex1].remove((Integer)vertex2);
			adjacencyList[vertex2].remove((Integer)vertex1);
			num_of_edges--;
		}
	}
	
	public int getDegree(int vertex) {
		
		return adjacencyList[vertex].size();
	}
	
	
}
