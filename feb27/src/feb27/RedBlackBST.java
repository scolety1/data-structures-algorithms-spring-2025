package feb27;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RedBlackBST {

	private Node root;
	
	public RedBlackBST() {
		this.root = null;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	//not full functionality of a red black tree
	// no rotations
	public void insert(int newValue, String newColor) {
		//if tree is empty
		if(root == null) {
			root = new Node(newValue, newColor);
		}
		else {
			Node currentNode = root;
			boolean placed = false;
			while(!placed) {
				
				if(currentNode.getValue() == newValue) {
					System.out.println("No duplicate values allowed");
					placed = true;
				}
				else if(newValue < currentNode.getValue()) {
					//Go left
					if(currentNode.getLeft() == null) {
						currentNode.setLeft(new Node(newValue, newColor));
						currentNode.getLeft().setParent(currentNode);
						placed = true;
					}
					else {
						currentNode = currentNode.getLeft();
					}
				}
				else {
					//Go Right
					if(currentNode.getRight() == null) {
						currentNode.setRight(new Node(newValue, newColor));
						currentNode.getRight().setParent(currentNode);
						placed = true;
					}
					else {
						currentNode = currentNode.getRight();
					}
				}
				
			}
		}
	} //end of insert
	
	public void verifyRedBlackTree() {
		
		if(rule1()) {
			System.out.println("Rule 1: Every node is either red or black ✔️");
		}
		
		if(rule2()) {
			System.out.println("Rule 2: The null children are colored black ✔️");
		}
		
		if(rule3()) {
			System.out.println("Rule 3: the root node is colored black ✔️");
		}
		
		if(rule4()) {
			System.out.println("Rule 4: If a node is red, both children must be colored black ✔️");
		}
		
		if(rule5()) {
			System.out.println("Rule 5: Paths must contain the same number of black nodes ✔️");
		}
		
	}
	


	public boolean rule1() {
		//every node is either red or black
		Queue<Node> queue = new LinkedList<>();
		if(root != null) {
			queue.add(root);
			
			while(!queue.isEmpty()) {
				
				Node node = queue.remove();
				
				//do something
				if(node.getColor().equals("Black") || node.getColor().equals("Red")) {
					//do nothing
				}
				else {
					return false;
				}
				
				if(node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if(node.getRight() != null) {
					queue.add(node.getRight());
				}
				
			}
			return true;
			
		}
		return true;
	}
	
	
	public boolean rule2() {
		//null children must be colored black (assumed)
		return true;
	}
	
	public boolean rule3() {
		//root must be colored black
		if(root.getColor().equals("Black")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean rule4() {
		//if a node is red, both children must be colored black
		Queue<Node> queue = new LinkedList<>();
		if(root != null) {
			queue.add(root);
			
			while(!queue.isEmpty()) {
				
				Node node = queue.remove();
				
				//do something
				if(node.getColor().equals("Red")) {
					
					HashSet<Node> children = new HashSet<>();
					children.add(node.getLeft());
					children.add(node.getRight());
					
					for(Node n: children) {
						if(n != null) {
							if(!n.getColor().equals("Black")) {
								return false;
							}
						}
					}
					
				}
				
				if(node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if(node.getRight() != null) {
					queue.add(node.getRight());
				}
				
			}
			return true;
			
		}
		return true;
	}
	
	public boolean rule5() {
		//paths to descendants must contain the same number of black nodes
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> leaves = new HashSet<>();
		if(root != null) {
			queue.add(root);
			
			while(!queue.isEmpty()) {
				
				Node node = queue.remove();
				
				//add only the leaf nodes
				if(node.getLeft() == null && node.getRight() == null) {
					leaves.add(node);
				}

				
				if(node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if(node.getRight() != null) {
					queue.add(node.getRight());
				}
				
			}
		
			
		} //end of breadth-first
		//System.out.println(leaves);
		HashMap<Integer, Integer> paths = new HashMap<>();
		for(Node n: leaves) {
			
			Node current = n;
			int blackNodesVisited = 1;
			while(current != null) {
				
				if(current.getColor().equals("Black")) {
					blackNodesVisited++;
				}
				
				current = current.getParent();
			}
			paths.put(n.getValue(), blackNodesVisited);
		}//now hashmap path is filled
		//System.out.println(paths);
		List<Integer> values = new LinkedList(paths.values());
		Set<Integer> noDuplicates = new HashSet(values);
		
		if(noDuplicates.size() == 1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
