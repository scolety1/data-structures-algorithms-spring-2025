package march11;

import java.util.HashMap;
import java.util.LinkedList;

public class UndirectedGraphHashMap {

	private HashMap<String, LinkedList<String>> adjList;
	private int num_of_edges;
	
	public UndirectedGraphHashMap() {
		adjList = new HashMap<String, LinkedList<String>>();
		num_of_edges = 0;
	}
	
	public void addVertex(String newVertex) {
		// creates a new entry in our hashmap
		adjList.put(newVertex, new LinkedList<String>());
	}
	
	
	// updates the hash map with a new edge between v1 and v2
	public void addEdge(String vertex1, String vertex2) {
		LinkedList<String> newLinkedList = adjList.get(vertex1);
		newLinkedList.add(vertex2);
		adjList.put(vertex1, newLinkedList);
		
		newLinkedList = adjList.get(vertex2);
		newLinkedList.add(vertex1);
		adjList.put(vertex2, newLinkedList);
	}
	
	public void printGraph() {
		for(String s: adjList.keySet()) {
			System.out.println(s + "--> " + adjList.get(s));
		}
	}
	
	public void removeEdge(String vertex1, String vertex2) {
		LinkedList<String> newLinkedList = adjList.get(vertex1);
		newLinkedList.remove(vertex2);
		adjList.put(vertex1, newLinkedList);
		
		newLinkedList = adjList.get(vertex2);
		newLinkedList.remove(vertex1);
		adjList.put(vertex2, newLinkedList);
	}
	
	public void removeVertex(String vertex) {
		adjList.remove(vertex);
		//then do a for loop through adjList and remove all occurrences of "vertex" in the LinkedList
	}
	
	
}
