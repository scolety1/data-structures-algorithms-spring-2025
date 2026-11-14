
public class BSTDemo {

	public static void main(String[] args) {
		
		BST tree = new BST();
		
		tree.insert(44);
		tree.insert(17);
		tree.insert(88);
		tree.insert(8);
		tree.insert(32);
		tree.insert(65);
		tree.insert(93);
		tree.insert(27);
		tree.insert(54);
		tree.insert(82);
		tree.insert(96);
		tree.insert(21);
		tree.insert(29);
		tree.insert(76);
		tree.insert(95);
		tree.insert(68);
		tree.insert(80);
		
		//tree.preOrder(tree.getRoot());
		//System.out.println();
		
		//tree.inOrder(tree.getRoot());

		int height = tree.findHeight(tree.getRoot());
		System.out.println(height);
		
		//82 and 96 are cousins
		System.out.println(tree.isCousins(tree.getRoot(), 82, 96 ));
		
		//82 and 96 are not cousins
		System.out.println(tree.isCousins(tree.getRoot(), 82, 95 ));
		
		//tree.deleteNode(tree.getRoot(), 44);
		//System.out.println();
		
		//tree.inOrder(tree.getRoot());
	}

}
