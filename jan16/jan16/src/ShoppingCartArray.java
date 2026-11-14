
public class ShoppingCartArray {

	private Item[] cart;
	private int num_of_items;
	
	public ShoppingCartArray() {
		this.cart = new Item[0];
		this.num_of_items = 0;
	}
	
	public void addItem(String itemName, double itemPrice, int num) {
		Item newItem = new Item(itemName, itemPrice, num);
		Item[] tempArray = new Item[cart.length + 1];
		for(int i = 0; i < cart.length; i++) {
			tempArray[i] = cart[i];
		}
		tempArray[cart.length] = newItem;
		cart  = tempArray;
		num_of_items++;
	}
	
	public void printCart() {
		
		for(int i = 0; i < num_of_items; i++) {
			System.out.println(cart[i].getQuantity() + " " + cart[i].getName() + " " + cart[i].getPrice());
		}
		
	}
	
	public double totalCart() {
		
		double answer = 0;
		
		for(Item i: cart) {
			answer += (i.getPrice() * i.getQuantity());
		}
		
		return answer;
		
	}
	
}
