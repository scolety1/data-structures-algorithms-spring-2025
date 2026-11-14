package april3;

import java.util.HashSet;
import java.util.LinkedList;

public class WeightedDirectedGraph {

	private LinkedList<Edge>[] adjList;
	private HashSet<Edge> edges;
	
	public WeightedDirectedGraph(int numVertices) {
		adjList = new LinkedList[numVertices];
		
		for(int i = 0; i < adjList.length; i++) {
			this.adjList[i] = new LinkedList<> ();
		}
		
		edges = new HashSet<Edge>();
		
	}
	
	public int getNumVertices() {
		return this.adjList.length;
	}
	
	public int getNumEdges() {
		return this.edges.size();
	}
	
	public LinkedList<Edge> getAdjacentEdges(int vertex) {
		return adjList[vertex];
	}
	
	public void addEdge(int source, int dest, double weight) {
		Edge edge = new Edge(source, dest, weight);
		if(edges.add(edge)) {
			adjList[source].add(edge);
		}
	}
	
	public HashSet<Edge> getEdges(){
		return edges;
	}
	
}
