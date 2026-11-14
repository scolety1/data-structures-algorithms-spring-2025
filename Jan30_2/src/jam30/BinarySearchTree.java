package jam30;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	private Node root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	
	public void insert(int newValue) {
		if(root == null) {
			root = new Node(newValue);
		}
		else {
			
			Node currentNode = root;
			boolean placed = false;
			while(!placed) {
				if(currentNode.getValue() == newValue) {
					//Duplicate
					System.out.println("No duplicate values allowed");
					placed = true;
				}
				else if(newValue < currentNode.getValue()){
					//Go Left
					if(currentNode.getLeft() == null) {
						currentNode.setLeft(new Node(newValue));
						currentNode.getLeft().setParent(currentNode);
						placed = true;
					}
					else {
						currentNode = currentNode.getLeft();
					}
				}
				else {
					if(currentNode.getRight() == null) {
						currentNode.setRight(new Node(newValue));
						currentNode.getRight().setParent(currentNode);
						placed = true;
					}
					else {
						currentNode = currentNode.getRight();
					}
				}
			}
			
		}
		
	}

	public void preOrder(Node n) {
		
		if(n != null) {
			
			System.out.println(n.getValue());
			preOrder(n.getLeft());
			preOrder(n.getRight());
			
		}
	}

	public void inOrder(Node n) {
		
		if(n != null) {
			
			inOrder(n.getLeft());			
			System.out.println(n.getValue());
			inOrder(n.getRight());
			
		}
	}

	public void postOrder(Node n) {
		
		if(n != null) {
			
			postOrder(n.getLeft());			
			postOrder(n.getRight());
			System.out.println(n.getValue());
			
		}
	}
	
	public Node deleteNode(Node current, int searchValue) {
		
		if(current == null) {
			return current;
		}
	
	
		if(current.getValue() > searchValue) {
			current.setLeft(deleteNode(current.getLeft(), searchValue));
		}
		else if(current.getValue() < searchValue) {
			current.setRight(deleteNode(current.getRight(), searchValue));
		}
		else {
			//found the element I'm trying to remove
			
			//If removed node only has right child
			if(current.getLeft() == null) {
				return current.getRight();
			}
			if(current.getRight() == null) {
				return current.getLeft();
			}
			
			//when both children are present
			Node successor = findSuccessor(current);
			current.setValue(successor.getValue());
			
			//remove duplicate
			current.setRight(deleteNode(current.getRight(), successor.getValue()));;
		}
		return current;
	}
	
	public Node findSuccessor(Node current) {
		current = current.getRight();
		while(current != null && current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	public int findHeight(Node current) {

		if(current == null) {
			return -1;
		}
		else {
			int rightHeight = findHeight(current.getRight());
			int leftHeight = findHeight(current.getLeft());
		
			return 1 + Math.max(rightHeight, leftHeight);
		}
		
		
		
	}

	public boolean isCousins(Node root, int a, int b) {
		// TODO Auto-generated method stub
		if(root == null) {
			return false;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			boolean foundA = false;
			boolean foundB = false;
			
			for(int i = 0; i < queue.size(); i++) {
				Node current = queue.poll();
				
				if(current.getValue() == a) {
					foundA = true;
				}
				if(current.getValue() == b) {
					foundB = true;
				}
				
				if(current.getLeft() != null&& current.getRight() != null) {
					//if they share the same parents they cannot be cousins
					if(current.getLeft().getValue() == a && current.getRight().getValue() == b) {
						return false;
					}
					if(current.getLeft().getValue() == b && current.getRight().getValue() == a) {
						return false;
					}
					
				}
				
				if(current.getLeft() != null) {
					queue.add(current.getLeft());
				}
				if(current.getRight() != null) {
					queue.add(current.getRight());
				}
				
			}
			if(foundA && foundB) {
				return true;
			}
		}
		return false;
	}
}
