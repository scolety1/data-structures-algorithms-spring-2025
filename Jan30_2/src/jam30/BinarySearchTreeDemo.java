package jam30;

public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(44);
		tree.insert(17);
		tree.insert(88);
		tree.insert(8);
		tree.insert(32);
		tree.insert(65);
		tree.insert(97);
		tree.insert(27);
		tree.insert(54);
		tree.insert(82);
		tree.insert(93);
		tree.insert(21);
		tree.insert(29);
		tree.insert(76);
		tree.insert(96);
		tree.insert(68);
		tree.insert(80);
		tree.insert(95);
		
		//tree.preOrder(tree.getRoot());
		//System.out.println();
	
		tree.inOrder(tree.getRoot());

		int height = tree.findHeight(tree.getRoot());
		System.out.println(height);
		
		System.out.println(tree.isCousins(tree.getRoot(), 54, 96));
		
		
		//tree.deleteNode(tree.getRoot(), 80);
		//System.out.println();

		//tree.inOrder(tree.getRoot());
	}
}
