package lab03;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

	private Node root;
	private int i = 1;
	
	public BST() {
		this.root = null;
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
					placed = true;
					System.out.println("No duplicate values allowed");
				}
				else if(newValue < currentNode.getValue()) {
					//move left
					if(currentNode.getLeft() == null) {
						// cant move left, so we found insertion spot
						//insert Node
						currentNode.setLeft(new Node(newValue));
						currentNode.getLeft().setParent(currentNode);
						placed = true;
					}
					else {
						// otherwise move left
						currentNode = currentNode.getLeft();
					}
				}
				else {
					//move right
					if(currentNode.getRight() == null) {
						//cant move right, insert new node
						currentNode.setRight(new Node(newValue));
						currentNode.getRight().setParent(currentNode);
						placed = true;
					}
					else {
						//move right
						currentNode = currentNode.getRight();
					}
				}	
			}		
		}	
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	
	//These are the four methods you need to write for lab 4. You are welcome to make additional changes to the BST class.
	
	public void inOrder(Node n) {
		//TO DO: Lab 3
		if(root == null) {
			System.out.println("The tree is empty");
			return;
		}
		if(n != null) {
			
			inOrder(n.getLeft());
			System.out.println(i + ". " + n.getValue());
			i++;
			inOrder(n.getRight());
		}
	}

	public void breadthFirst() {
		if(root == null) {
			System.out.println("The tree is empty");
			return;
		}
		i = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
			
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			i++;
			System.out.println(i + ". " + node.getValue());			
			if(node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if(node.getRight() != null) {
				queue.add(node.getRight());
			}
			
		}
	}

	
	public int getMax() {
		//TO DO: Lab 3
		if(root == null) {
			System.out.println("The tree is empty");
		}
		Node current = root.getRight();
		if(current.getRight() == null) {
			return current.getValue();
		}
		while(current.getRight() != null) {
			current = current.getRight();
		}
		
		return current.getValue();
	}
	
	public int getMin() {
		Node current = root.getLeft();
		if(root == null) {
			System.out.println("The tree is empty");
		}
		if(current.getLeft() == null) {
			return current.getValue();
		}
		while(current.getLeft() != null) {
			current = current.getLeft();
		}
		
		return current.getValue();
	}
	
	public Node find(int value) {
		//TO DO: Lab 3
		if(root == null) {
			System.out.println("The tree is empty");
		}
		else {
			boolean found = false;
			Node current = root;
			while(found != true) {
				if(current.getValue() == value) {
					found = true;
					System.out.println("Found!");
					return current;
				}
				else if(current.getValue() < value){
					//Go right
					if(current.getRight() == null) {
						System.out.println("Not found");
						return null;
					}
					else {
						current = current.getRight();
					}
				}
				else if(current.getValue() > value) {
					//Go left
					if(current.getLeft() == null) {
						System.out.println("Not found");
						return null;
					}
					else {
						current = current.getLeft();
					}
				}
				else{
					System.out.println("print ion know");
				}
			}
		}
		return null;
	}	
}