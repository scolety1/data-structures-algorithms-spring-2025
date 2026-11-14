package lab02;
import java.util.LinkedList;
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
		if(directory == null || directory.equals(" ") || directory.equals("~")) {
			return false;
		}
		
		LinkedList<Node> children;
		String[] path = directory.split("/");
		Node temp = current;
		
		
		for(String director: path) {
			boolean found = false;
			children = temp.getChildren();
			for(Node child: children) {		
				if(child.getName().equals(director)) {
					//move down
					temp = child;
					found = true;
					break;
				}
			}
			if(!found) {
				return false;
			}
			
		}
		current = temp;
		return true;
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
		if(directory == null || directory.equals(" ") || directory.equals("~")) {
			return false;
		}
		LinkedList<Node> children = current.getChildren();
		
		for (Node child : children) {
			if (child.getName().equals(directory)) {
				children.remove(child);
				return true;
			}
		}
		return false;
	}
	
	public String getPath() {
		//TO DO: Lab 2
		String path = "~";
		Stack<String> stack = new Stack<>();
		Node temp = current;
		while(temp.getParent() != null) {
			stack.push(temp.getName());
			temp = temp.getParent();
		}
		while(!stack.isEmpty()) {
			path += "/" + stack.pop();
		}
		return path;
	}	
}