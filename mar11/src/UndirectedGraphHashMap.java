import java.util.HashMap;
import java.util.LinkedList;

public class UndirectedGraphHashMap {

	private HashMap<String, LinkedList<String>> adjList;
	
	public UndirectedGraphHashMap() {
		adjList = new HashMap<String, LinkedList<String>>();
	}
	
	public void addVertex(String newVertex) {
		adjList.put(newVertex, new LinkedList<String>());
	}
	
	public void addEdge(String vertex1, String vertex2) {
		
		LinkedList<String> newList = adjList.get(vertex1);
		newList.add(vertex2);
		adjList.put(vertex1, newList);
		
		newList = adjList.get(vertex2);
		newList.add(vertex1);
		adjList.put(vertex2, newList);
		
	}
	
	public void printGraph() {
		
		for(String state: adjList.keySet()) {
			System.out.println(state + " --> " + adjList.get(state));
		}
		
		
	}
	
	
}
