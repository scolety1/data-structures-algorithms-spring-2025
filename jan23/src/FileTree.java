import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FileTree {

	private Node root;
	private Node current;
	
	public FileTree() {
		this.root = new Node("~");
		this.current = root;	
	}
	
	public boolean insert(String directory) {
		
		if(directory == null || directory.equals(" ") || directory.equals("~")) {
			return false;
		}
		else {
			Node newNode = new Node(directory);
			newNode.setParent(current);
			current.addChild(newNode);
			return true;
		}
	}
	
	public boolean moveDown(String directory) {
		//TO DO: Allow for a directory path for an argument
		// cd School/CSCI232/Programs
		LinkedList<Node> children = current.getChildren();
		for(Node child: children) {
			
			if(child.getName().equals(directory)) {
				//move down
				current = child;
				return true;
			}
			
		}
		return false;
		
		
	}
	
	public void moveUp() {
		if (current != root) {
			current = current.getParent();
		}
	}
	
	public void goHome() {
		current = root;
	}
	
	public String getCurrentLocation() {
		return current.getName();
	}
	
	public String getChildren() {
		String files = "";
		LinkedList<Node> children = current.getChildren();
		for(Node c: children) {
			files += c.getName() + " ";
		}
		return files;
	}
	
	public boolean remove(String directory) {
		//TO DO: Lab 2
		
		return false;
	}
	
	
	public String getPath() {
		//TO DO: Lab 2
		
		return null;
	}
	
	public void breadthFirst() {
		
		Queue<Node> queue = new LinkedList<>();
			
		if(root != null) {
			queue.add(root);
			
			while(!queue.isEmpty()) {
				
				Node node = queue.remove();
				
				System.out.println(node.getName());
				
				for(Node child: node.getChildren()) {
					queue.add(child);
				}
			}
		}
	}
	
	public void depthFirst() {
	
		Stack<Node> stack = new Stack<>();
		if(root != null) {
			
			stack.push(root);
			while(!stack.isEmpty()) {
				
				Node node = stack.pop();
				System.out.println(node.getName());
				
				for(Node child: node.getChildren()) {
					stack.push(child);
				}
				
			}
		}
	}
}