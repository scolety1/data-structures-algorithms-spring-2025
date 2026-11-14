
public class Item {

	private String name;
	private double price;
	private int quantity;
	
	public Item(String inName, double inPrice, int inQuan) {
		this.name = inName;
		this.price = inPrice;
		this.quantity = inQuan;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
}
