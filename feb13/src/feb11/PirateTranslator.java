package feb11;

import java.util.HashMap;
import java.util.Scanner;

public class PirateTranslator {

	public static void main(String[] args) {
		
		HashMap<String, String> translator = new HashMap<String, String>();
		
		translator.put("hello", "ahoy");
		translator.put("friend", "matey");
		translator.put("yes", "aye");
		translator.put("stop", "heave");
		translator.put("CSCI232", "Davey Jone's Locker");
		
		//get a sentence (english) with scanner
		Scanner input = new Scanner(System.in);
		String sentence = input.nextLine().toLowerCase();
		String[] splitted = sentence.split(" ");
		
		//iterate through all words in the sentence
		String pirate_sentence = "";
		for(String word : splitted) {
			
			if(translator.containsKey(word)){
				pirate_sentence += translator.get(word) + " ";
			}
			else {
				pirate_sentence += word + " ";
			}
		}
		System.out.println(pirate_sentence);
		
		
	}

}
