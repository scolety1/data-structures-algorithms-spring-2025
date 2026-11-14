package program01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AnimalTree {

	private Node root;
	Scanner scanner = new Scanner(System.in);

	
	public AnimalTree() {
		this.root = null;
	}
	
	public Node getRoot() {
		return this.root;
	}

	public void loadBST() {
		File file = new File("src/tree.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.isEmpty()) {
	                continue;
	            }
				String[] code = line.split(",", 2);
				int value = Integer.parseInt(code[0]);
				String string = code[1];
				insert(value, string);
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insert(int newValue, String newTitle) {
		if(root == null) {
			root = new Node(newValue, newTitle);
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
						currentNode.setLeft(new Node(newValue, newTitle));
						currentNode.getLeft().setParent(currentNode);
						placed = true;
					}
					else {
						currentNode = currentNode.getLeft();
					}
				}
				else {
					if(currentNode.getRight() == null) {
						currentNode.setRight(new Node(newValue, newTitle));
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
	
	public boolean isLeaf(Node currentNode) {
		if(currentNode.getLeft() == null && currentNode.getRight() == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void breadthFirst() {
		if(root == null) {
			System.out.println("The tree is empty");
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
			
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.println(node.getValue() + ". " + node.getTitle());			
			if(node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if(node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
	}
	public void printTree() {
		if(root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/tree.txt"))){
				
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				writer.write(node.getValue() + "," + node.getTitle());
				writer.newLine();
				if(node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if(node.getRight() != null) {
					queue.add(node.getRight());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void amend(Node current, String newAnimal, String newAttribute) {
		Node newInternalNode = new Node(current.getValue() + 1, newAttribute);
		Node newLeafNode = new Node(current.getValue(), newAnimal);
		
		newInternalNode.setLeft(newLeafNode);
		Node parent = current.getParent();
		if (parent.getRight() == current) {
			parent.setRight(newInternalNode);
		}
		else {
			parent.setLeft(newInternalNode);
		}
		newInternalNode.setRight(new Node(current.getValue() + 2, current.getTitle()));
	    relabelNodes(this.root, current.getValue(), newLeafNode, current, newInternalNode);
	}

	private void relabelNodes(Node node, int newValue, Node left, Node right, Node parent) {
		if (node == null) return;

	    relabelNodes(node.getLeft(), newValue, left, right, parent);
	    if(node.getTitle().equals(left.getTitle()) || node.getTitle().equals(right.getTitle()) || node.getTitle().equals(parent.getTitle())) {
	    	return;
	    }
	    if(newValue <= node.getValue() ) {
	        node.setValue(node.getValue() + 2); 
	    }
	    relabelNodes(node.getRight(), newValue, left, right, parent);		
	}

}
