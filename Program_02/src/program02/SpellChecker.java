package program02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class SpellChecker {
	
	private static HashSet<String> dictionary = new HashSet<>();
    private static FileHandler fileHandler = new FileHandler();
	
    public static void loadDictionary() {
        try (Scanner scanner = new Scanner(new File("src/words.txt"))) {
            while (scanner.hasNext()) {
                dictionary.add(scanner.next().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found!");
        }
    }



    
    public static void checkFile() {
        String content = fileHandler.readFile("src/input.txt");

        if (!content.isEmpty()) {
            System.out.println("File Content:\n" + content);
        } else {
            System.out.println("The file is empty or could not be read.");
        }
    }

    public static void checkDocument(String filename) {
    	loadDictionary();
        String content = fileHandler.readFile(filename);
        Scanner scanner = new Scanner(content);

        StringBuilder result = new StringBuilder();
        while (scanner.hasNextLine()) {
        	String line = scanner.nextLine();
        	String[] words = line.split(" ");
        	
            for (String word : words) {
            	if (word.isEmpty()) {
                    result.append(" ");
                    continue;
                }
                char lastChar = word.charAt(word.length() - 1);
                boolean hasPunctuation = (lastChar == '.' || lastChar == ',' || lastChar == '?' || lastChar == '!');

                String cleanWord = hasPunctuation ? word.substring(0, word.length() - 1) : word;
                if (dictionary.contains(cleanWord.toLowerCase())) {
                    result.append(word).append(" ");
                } else {
                    if (hasPunctuation) {
                        result.append("<").append(cleanWord).append(">").append(lastChar).append(" ");
                    } else {
                        result.append("<").append(word).append("> ");
                    }
                }
            }
            result.append("\n");
        }
        scanner.close();
        System.out.println(result.toString().trim());
    }
}
