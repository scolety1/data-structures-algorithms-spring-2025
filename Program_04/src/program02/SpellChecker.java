package program02;

import java.io.File;
import java.util.*;

public class SpellChecker {
    private static HashSet<String> dictionary = new HashSet<>();
    private static FileHandler fileHandler = new FileHandler();

    public static void loadDictionary() {
        try (Scanner scanner = new Scanner(new File("src/words.txt"))) {
            while (scanner.hasNext()) {
                dictionary.add(scanner.next().toLowerCase());
            }
        } catch (Exception e) {
            System.out.println("Dictionary file not found.");
        }
    }

    public static void processSentence(String sentence) {
        String[] words = sentence.split(" ");
        boolean allCorrect = true;

        for (String word : words) {
            String original = word;
            String cleaned = word.toLowerCase().replaceAll("[.,!?]", "");
            boolean hasPunct = !cleaned.equals(word.toLowerCase());
            char punct = hasPunct ? word.charAt(word.length() - 1) : '\0';

            if (dictionary.contains(cleaned)) {
                System.out.print(original + " ");
            } else {
                allCorrect = false;
                System.out.print("<" + cleaned + ">" + (punct != '\0' ? punct : "") + " ");
            }
        }

        System.out.println();

        if (allCorrect) {
            System.out.println("You spelled everything correctly-- good job!");
            return;
        }

        for (String word : words) {
            String cleaned = word.toLowerCase().replaceAll("[.,!?]", "");
            if (!dictionary.contains(cleaned)) {
                System.out.println();
                System.out.println(cleaned);
                suggestWords(cleaned);
            }
        }
    }

    public static void suggestWords(String badWord) {
        PriorityQueue<Word> queue = new PriorityQueue<>();
        for (String dictWord : dictionary) {
            int dist = EditDistance.compute(badWord, dictWord);
            queue.add(new Word(dictWord, dist));
        }

        int count = 0;
        while (!queue.isEmpty() && count < 5) {
            Word suggestion = queue.poll();
            System.out.println("-Did you mean " + suggestion.word + "(" + suggestion.distance + ")?");
            count++;
        }
    }
}
