package april3;

public class Edge {

	private int sourceVertex;
	private int destVertex;
	private double weight;
	
	public Edge(int s, int d, double w) {
		this.sourceVertex = s;
		this.destVertex = d;
		this.weight = w;
	}
	
	public int getFrom() {
		return this.sourceVertex;
	}
	
	public int getTo() {
		return this.destVertex;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public String toString() {
		return "(" + sourceVertex + "-->" + destVertex + ")";
	}
	
	
}
