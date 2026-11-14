package program01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		
		AnimalTree tree = new AnimalTree();
		Scanner scanner = new Scanner(System.in);
		boolean isOver = false;
		
		tree.loadBST();
		while(isOver != true) {
			System.out.print("Do you have another animal to identify? (Y/N) > ");
			String input = scanner.next();
			scanner.nextLine();
			if(input.equalsIgnoreCase("N")){
				isOver = true;
				break;
			}
			Node current = tree.getRoot();
			List<String> pathList = new ArrayList<>();
			while(tree.isLeaf(current) == false) {
				System.out.println("Is this animal " + current.getTitle() + "?");
				String secondInput = scanner.next();
				scanner.nextLine();
				pathList.add("not " + current.getTitle());
				if(secondInput.equalsIgnoreCase("Y")) {
					current = current.getLeft();
				}
				else if(secondInput.equalsIgnoreCase("N")){
					current = current.getRight();
				}
				else {
					System.out.println("I messed up");
				}
			}
			System.out.println("Hmmm... I think I know.");		
			System.out.println("Is it a " + current.getTitle() +"?");
			String thirdInput = scanner.next();
			scanner.nextLine();

			if(thirdInput.equalsIgnoreCase("Y")) {
				System.out.println("Good! All done.");
			}
			else if(thirdInput.equalsIgnoreCase("N")){
				String path = String.join(", ", pathList);  // Join with commas
                if (pathList.size() > 1) {
                    int lastCommaIndex = path.lastIndexOf(", ");
                    path = path.substring(0, lastCommaIndex) + " and" + path.substring(lastCommaIndex + 1);
                }
                path += ".";
                System.out.println("I was wrong...");
				System.out.println("I don't know any other animals that are " + path);
				System.out.println("What is the new animal? > ");
                String newAnimal = scanner.nextLine();
                System.out.println("What characteristic does " + newAnimal + " have that " + current.getTitle() + " does not? > ");
                String newAttribute = scanner.nextLine();
				tree.amend(current, newAnimal, newAttribute);
			}
		}
		tree.printTree();
		scanner.close();
		System.out.println("Have a great day!");
	}
	
}
