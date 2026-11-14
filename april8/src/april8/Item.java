package april8;

public class Item implements Comparable<Item> {

	private String name;
	private double value;
	private double weight;
	private double ratio;
	
	public Item(String n, double v, double w) {
		this.name = n;
		this.value = v;
		this.weight = w;
		this.ratio = value / weight;
	}
	
	public double getRatio() {
		return this.ratio;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public int compareTo(Item other) {
		if(this.ratio > other.ratio) {
			return 1;
		}
		else if(this.ratio< other.ratio){
			return -1;
		}
		else {
			return 0;
		}
		
	}
	
	
}
