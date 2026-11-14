package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class EmojiTranslator {

	HashMap<String, String> translator = new HashMap<String, String>();
	
	public EmojiTranslator() {
		translator = loadHashTable();
	}
	
	public HashMap<String, String> loadHashTable() {
		HashMap<String, String> emojiMap = new HashMap<>();
		
		File file = new File("src/emojis.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.isEmpty()) {
	                continue;
	            }
				String[] code = line.split(",", 2);
				emojiMap.put(code[1], code[0]);
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emojiMap;
		
	}
	
	
	public String convert(String sentence) {
		String[] splitted = sentence.split(" ");
		String NewSentence = "";
		for(String word : splitted) {	
			if(translator.containsKey(word)){
				NewSentence += translator.get(word) + " ";
			}
			else {
				NewSentence += word + " ";
			}
		}
		return NewSentence;
	}

	public String getEmoji(String code) {
		String NewCode = ":" + code + ":";

		if(translator.containsKey(NewCode)) {
			return translator.get(NewCode);
		}
		else {
			return "Emoji not found: " + code;
		}
	}

}
