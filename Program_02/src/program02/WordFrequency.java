package program02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {

	static FileHandler fileHandler = new FileHandler();
	static HashMap<String, Integer> wordCount = new HashMap<>();
	private static boolean isLoaded = false;

	
	public static void loadHashMap() {
        String content = fileHandler.readFile("src/input.txt");
        String[] wordsFromFile = content.replaceAll("[.,!?]", "").split("\\s+");
    	for (String word : wordsFromFile) {
    		word = word.toLowerCase().trim();
    		wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    	}

	}
	public static void printWordFrequencyAlphabetically() {
		if(!isLoaded) {
			loadHashMap();
			isLoaded = true;
		}
		List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
		
		Collections.sort(sortedList, (a, b) -> a.getKey().compareTo(b.getKey()));
		
		for(Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
	}

	public static void printWordFrequencyGreatestToLeast() {
		if(!isLoaded) {
			loadHashMap();
			isLoaded = true;
		}
		HashMap<Integer, List<String>> frequencyMap = new HashMap<>();
		
		for(Map.Entry<String, Integer> entry : wordCount.entrySet()) {
			int count = entry.getValue();
			frequencyMap.putIfAbsent(count, new ArrayList<>());
			frequencyMap.get(count).add(entry.getKey());
		}
		
		List<Integer> sortedList = new ArrayList<>(frequencyMap.keySet());
		sortedList.sort(Collections.reverseOrder());
		
		for(int count : sortedList) {
			List<String> words = frequencyMap.get(count);
	        Collections.sort(words);

	        System.out.print(count + ": ");
	        System.out.println(String.join(", ", words));
	        }
	}

}
