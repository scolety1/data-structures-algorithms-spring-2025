package program02;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Document Spell Check Program");
		System.out.println("----------------------------");
		while (true) {
			System.out.println("1: Spell Check your document (input.txt)");
			System.out.println("2: Print word frequency alphabetically");
			System.out.println("3: Print word frequency from greatest to least");
			System.out.println("4: Exit program");
			System.out.println("Your choice?");
			if(scanner.hasNextInt()) {
				int input = scanner.nextInt();
				switch (input) {
					case 1:
						System.out.println("Checking document...");
						SpellChecker.checkDocument("src/input.txt");
						System.out.println("");
						break;
					case 2:
						System.out.println("Printing word frequency alphabetically...");
						WordFrequency.printWordFrequencyAlphabetically();
						System.out.println("");
						break;
					case 3:
						System.out.println("Print word frequency from greatest to least...");
						WordFrequency.printWordFrequencyGreatestToLeast();
						System.out.println("");
						break;
					case 4:
						System.out.println("Exiting Program.");
						scanner.close();
						return;
					default:
                        System.out.println("Invalid choice. Enter a number 1-4.");
				}
			}
			else {                
				System.out.println("Invalid input. Enter a number 1-4.");
	            scanner.next();
			}
		}
		
		
	}
}
