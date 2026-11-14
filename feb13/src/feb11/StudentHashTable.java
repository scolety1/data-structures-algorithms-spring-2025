package feb11;

import java.util.HashMap;
import java.util.HashSet;

public class StudentHashTable {

	private HashMap<Integer, Student> database;
	private HashSet<Integer> keySpace;
	
	
	public StudentHashTable(int size) {
		this.database = new HashMap<Integer, Student>();
		this.keySpace = new HashSet<>();
	}
	
	public void insert(String newName, String newMajor, int newID) {
		Student newStudent = new Student(newName, newMajor, newID);
		// int arrayIndex = hash(newID);
		if(database.get(newID) == null) {
			database.put(newID, newStudent);
			keySpace.add(newID);
		}
		else {
			System.out.println("Collision detected");
		}
	}
	
	public Student lookup(int id) {
		return database.get(id);
	}
	
	public void print() {
		
		//slightly better O(k) = # of keys
		for(int id: keySpace) {
			System.out.println(database.get(id).getInfo());
			
		}
		
		//O(n) n = # of array spots
	//	for(int i = 0; i < database.length; i++) {
	//		if(database[i] != null) {
	//			System.out.println(database[i].getInfo());
	//		}
	//	}
	}

	public void remove(int id) {

		database.remove((Integer)id);
		keySpace.remove((Integer)id);
		
	}

	public void countMajors() {

		HashMap<String, Integer> freq = new HashMap<String, Integer>();

		for(int id: keySpace) {
			
			if(!freq.containsKey(database.get(id).getMajor())) {
				freq.put(database.get(id).getMajor(), 1);
			}
			else {
				freq.put(database.get(id).getMajor(), freq.get(database.get(id).getMajor()) + 1);
			
			}
		}
		for(String s: freq.keySet()) {
			System.out.println(s + ": " + freq.get(s));
		}
	}
	
}
