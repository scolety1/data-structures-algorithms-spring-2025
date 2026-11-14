package march11;

import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph {

	private LinkedList<Integer>[] adjList;
	private int[] previousVertex;
	private boolean [] visited;
	
	public UndirectedGraph(int vertices) {
		this.adjList = new LinkedList[vertices];
		for(int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		this.num_of_edges = 0;
		visited = new boolean[vertices];
	}
	// create an edge between v1 and v2
	public void addEdge(int vertex1, int vertex2) {
		adjList[vertex1].add(vertex2);
		adjList[vertex2].add(vertex1);
		num_of_edges++;
	}
	
	// print out my adjacency list
	public void printGraph() {
		for(int i = 0; i < adjList.length; i++) {
			System.out.println(i + "--> " + adjList[i]);
			
			
		}
	}
	
	public void removeEdge(int vertex1, int vertex2) {
		
		// check to see if edge actually exists
		if(adjList[vertex2].contains(vertex1) && adjList[vertex1].contains(vertex2)) {
			
			// Integer = make sure we are calling the correct remove method
			adjList[vertex1].remove((Integer)vertex2);
			adjList[vertex2].remove((Integer)vertex1);
			num_of_edges--;
		}
	}
	
	public int getDegree(int vertex) {
		
		return adjList[vertex].size();
	}
	
	public LinkedList<Integer> getNeighbors(int n) {
		return adjList[n];
	}
	
	public void depthFirst(int n) {

		System.out.println(n);
		visited[n] = true;
		for (int neighbor: getNeighbors(n)) {
			if(!visited[neighbor]) {
				depthFirst(neighbor);
			}
		}
	}
	
	public void breadthFirst(int startVertex) {
		Queue<Integer> queue = new LinkedList<>();
		visited[startVertex] = true;
		queue.add(startVertex);
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.println(vertex);
			for(Integer neighbor: getNeighbors(vertex)) {
				if(!visited[neighbor]) {
					previousVertex[neighbor] = vertex;
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}
	
	public boolean isReachable(int startVertex, int endVertex) {
		//depthFirst(startVertex);
		breadthFirst(startVertex);
		return visited[endVertex];
	}
	
	public LinkedList<Integer> getPath(int startVertex, int endVertex) {

		if(!isReachable(startVertex, endVertex)) {
			return null;
		}
		else {
			LinkedList<Integer> path = new LinkedList<>();
			//backwards for loop to calculate the path
			for(int v = endVertex; v != startVertex; v = previousVertex[v]) {
				path.addFirst(v);
			}
			path.addFirst(startVertex);
			return path;
		}
	}	
}
