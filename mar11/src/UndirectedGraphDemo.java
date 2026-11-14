
public class UndirectedGraphDemo {

	public static void main(String[] args) {
	
		
		UndirectedGraph graph = new UndirectedGraph(8);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(2, 4);
		graph.addEdge(1	, 5);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);

		//graph.printGraph();
		//graph.depthFirst(0);
		System.out.println(graph.getPath(0, 7));
		
		/*
		UndirectedGraphHashMap graph = new UndirectedGraphHashMap();
		graph.addVertex("Montana");
		graph.addVertex("Idaho");
		graph.addVertex("South Dakota");
		graph.addVertex("Wyoming");
		
		graph.addEdge("Montana", "Wyoming");
		graph.addEdge("Montana", "Idaho");
		graph.addEdge("Montana", "South Dakota");
		graph.addEdge("Wyoming", "Idaho");
		graph.addEdge("Wyoming", "South Dakota");
		
		graph.printGraph();
		*/
	}

}
