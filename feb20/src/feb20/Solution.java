package feb20;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Solution {

	public static void main(String[] args) {
		
		//String message = "aaabbbc";
		//String magazine = "aaaaaaaaaaaaaaaaaa";
		//System.out.println(canConstruct(message, magazine));
		
		
		String ans = intToRoman(1994);
		System.out.println(ans);

	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> freq = new HashMap<>();
		for(char c: magazine.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		
		for(char c: ransomNote.toCharArray()) {
			if(freq.containsKey(c) || freq.get(c) <= 0) {
				return false;
			}
			freq.put(c, freq.get(c)-1);
		}
		return true;		
    }
	
	
	
	
	
	
	
	
	public static String intToRoman(int n) {
		
		HashMap<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
		
        List<Integer> numberList = new LinkedList<>(romanMap.keySet());
        Collections.sort(numberList, Collections.reverseOrder());
		
        String answer = "";
        int i = 0;
        while(n > 0) {
        	
        	if(numberList.get(i) > n) {
        		i++;
        	}
        	
        	if(n - numberList.get(i) >= 0) {
        		String numeral = romanMap.get(numberList.get(i));
        		answer += numeral;
        		n -= numberList.get(i);
        	}	
        }
        return answer;
	}
	
	
	
	
	
	
	
	
	
	
	
}
