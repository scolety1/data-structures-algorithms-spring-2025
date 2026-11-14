package feb27;

public class RedBlackTreeVerifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RedBlackBST rbt = new RedBlackBST();
		
		rbt.insert(10, "Black");
		rbt.insert(2, "Black");
		rbt.insert(18, "Red");
		rbt.insert(12, "Black");
		rbt.insert(50, "Black");
		rbt.insert(17, "Red");
		
		rbt.verifyRedBlackTree();
		
	}

}
