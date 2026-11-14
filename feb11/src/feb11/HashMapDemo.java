package feb11;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, String> map= new HashMap<String, String>();
		HashSet<String> set = new HashSet<String>();
		
		set.add("First");
		set.add("Third");
		set.add("Second");
		set.add("Fourth");
		System.out.println(set.contains("Third"));
		System.out.println(set);
		
		map.put("Dallas", "Cowboys");
		
		map.put("Philidelphia", "Eagles");
		
				
		System.out.println(map);
		
	}

}
