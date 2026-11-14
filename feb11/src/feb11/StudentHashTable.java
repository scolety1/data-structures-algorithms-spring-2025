package feb11;

import java.util.LinkedList;

public class StudentHashTable {

	private Student[] database;
	private LinkedList<Integer> keySpace;
	
	
	public StudentHashTable(int size) {
		this.database = new Student[size];
		this.keySpace = new LinkedList<>();
	}
	
	public void insert(String newName, String newMajor, int newID) {
		Student newStudent = new Student(newName, newMajor, newID);
		int arrayIndex = hash(newID);
		if(database[arrayIndex] == null) {
			database[arrayIndex] = newStudent;
			keySpace.add(newID);
		}
		else {
			System.out.println("Collision detected");
		}
	}
	
	public int hash(int id) {
		return id % database.length;
	}
	
	public Student lookup(int id) {
		int index = hash(id);
		return database[index];
	}
	
	public void print() {
		
		//slightly better O(k) = # of keys
		for(int id: keySpace) {
			int index = hash(id);
			System.out.println(index + ": " + database[index].getInfo());
			
		}
		
		//O(n) n = # of array spots
	//	for(int i = 0; i < database.length; i++) {
	//		if(database[i] != null) {
	//			System.out.println(database[i].getInfo());
	//		}
	//	}
	}

	public void remove(int id) {

		int index = hash(id);
		database[index] = null;
		keySpace.remove((Integer)id);
		
	}
	
	
	
}
