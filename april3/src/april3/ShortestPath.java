package april3;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class ShortestPath {

	private double[] distance;
	private Edge[] previous;
	
	
	
	public void computeShortestPath(WeightedDirectedGraph graph, int start) {
		
		distance = new double[graph.getNumVertices()];
		previous = new Edge[graph.getNumVertices()];
		
		
		for(int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
			distance[vertex] = Double.POSITIVE_INFINITY;
		}
		distance[start] = 0;
		
		
		//start Dijkistra's algorithm
		PriorityQueue<PriorityVertex> visitQueue = new PriorityQueue<>();
		visitQueue.add(new PriorityVertex(start, 0));
		
		
		while(!visitQueue.isEmpty()) {
			
			PriorityVertex currentVertex = visitQueue.poll();
			
			for(Edge edge: graph.getAdjacentEdges(currentVertex.getVertex())) {
				int neighborVertex = edge.getTo();
				
				//currentVertex = v
				//neighborVertex = v
				if(distance[currentVertex.getVertex()] + edge.getWeight() < distance[neighborVertex]) {
					//update our best estimate, remove any old instance from PQ, add new best estimates from stuff
					
					distance[neighborVertex] = distance[currentVertex.getVertex()] + edge.getWeight();
					previous[neighborVertex] = edge;
					
					visitQueue.remove(new PriorityVertex(neighborVertex, 0));
					visitQueue.add(new PriorityVertex(neighborVertex, distance[neighborVertex]));
				}
			}
				
		}
		
		
	}
	
	public double distanceTo(int vertex) {
		return distance[vertex];
	}

	public boolean hasPathTo(int vertex) {
		return distance[vertex] < Double.POSITIVE_INFINITY;
	}
	
	public LinkedList<Edge> getPathTo(int vertex) {
		if(!hasPathTo(vertex)) {
			return null;
		}
		else {
			LinkedList<Edge> path = new LinkedList<>();
			for(Edge edge = previous[vertex]; edge != null; edge = previous[edge.getFrom()]) {
				path.addFirst(edge);
			}
			return path;
		}
	}
}
