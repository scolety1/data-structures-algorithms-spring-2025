
public class GroceryStoreDemo {

	public static void main(String[] args) {
		
		
		//ShoppingCartArray cart = new ShoppingCartArray();
		ShoppingCartLinkedList cart = new ShoppingCartLinkedList();
		
		
		cart.addItem("Milk", 3.99, 3);
		cart.addItem("Eggs", 2.99, 1);
		cart.addItem("Flour", 6.99, 1);
		
		cart.printCart();
		
		System.out.println(cart.totalCart());

	}

}
