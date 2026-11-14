package april3;

public class PriorityVertex implements Comparable<PriorityVertex>{
	private int vertex;
	private double distanceFromSource;
	
	public PriorityVertex(int v, double d) {
		this.vertex = v;
		this.distanceFromSource = d;
	}

	public int getVertex() {
		return this.vertex;
	}
	
	@Override
	public int compareTo(PriorityVertex other) {
		return Double.valueOf(this.distanceFromSource).compareTo(other.distanceFromSource);
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof PriorityVertex)) {
			return false;
		}
		PriorityVertex pv = (PriorityVertex) other;
		if(this.vertex == pv.vertex) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
