import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph {
	
	//used to represent graph
	private LinkedList<Integer>[] adjList;
	//used to finding paths in graph
	private int[] previousVertex;
	//used to keep track of which vertices have been visited
	private boolean[] visited;
	
	public UndirectedGraph(int vertices) {
		this.adjList = new LinkedList[vertices];
		this.visited = new boolean[vertices];
		this.previousVertex = new int[vertices];
		for(int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
	}
	
	
	public void addEdge(int vertex1, int vertex2) {
		
		adjList[vertex1].add(vertex2);
		adjList[vertex2].add(vertex1);
		
	}
	
	//prints  the adjacency list
	public void printGraph() {
		for(int i = 0; i < adjList.length; i++) {
			System.out.println(i + "-->" + adjList[i]);
		}
	}
	
	public void removeEdge(int vertex1, int vertex2) {
		
		//check if edge exists
		if(adjList[vertex1].contains(vertex2) && adjList[vertex2].contains(vertex1)) {
			adjList[vertex1].remove((Integer)vertex2);
			adjList[vertex2].remove((Integer)vertex1);
		}
		
		
	}
	
	public LinkedList<Integer> getNeighbors(int vertex){
		return adjList[vertex];
	}
	
	public int getDegree(int vertex) {
		return adjList[vertex].size();
	}
	
	//depth first traversal and print out each node
	public void depthFirst(int n) {
		System.out.println(n);
		visited[n] = true;
		for(int neighbor: getNeighbors(n)) {
			//only go to a node if we have not visited it!
			if(!visited[neighbor]) {
				previousVertex[neighbor] = n;
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
	
	//returns a path (not optimal) from startVertex to endVertex
	public LinkedList<Integer> getPath(int startVertex, int endVertex){
		
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
			//to do: should reset values of visited and previousVertex here
			return path;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
