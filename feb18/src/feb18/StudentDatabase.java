package feb18;
import java.util.LinkedList;

public class StudentDatabase {
	
	private LinkedList<Student>[] data;
	
	public StudentDatabase(int size) {
		this.data = new LinkedList[size];
	}
	
	public void insert(String name, String major, int id, double gpa) {
		Student newStudent = new Student(name, id, major, gpa);
		
		int insertIndex = hash(id);
		if(data[insertIndex] == null) {
			data[insertIndex] = new LinkedList<Student>();
		}
	
		data[insertIndex].add(newStudent);
		//keySpace.add(id);
		
	}
	
	public int hash(int id) {
		// id % 100
		return id % this.data.length;
	}
	
	public void print() {
		
		for(int i = 0; i < data.length; i++) {
			
			if(data[i] != null) {
				
				String info = "";
				for(Student s: data[i]) {
					
					info += s.getName() + " ";
					
				}
				System.out.println(i + ": " + info);
				
				
			}
			
			
			
		}
		
	
	}
	
	public Student get(int id) {
		
		int arrayIndex = hash(id);
		
		LinkedList<Student> list = data[arrayIndex];
		
		if(list.size() == 0) {
			return null;
		}
		if(list.size() == 1) {
			return list.get(0);
		}
		else {
			for(Student s: list) {
				if(s.getID() == id) {
					return s;
				}
			}
			return null;
		}
		
	}

	public void remove(int id) {
		
		int arrayIndex = hash(id);
		LinkedList<Student> list = data[arrayIndex];
		
		for(Student s: list) {
			if(s.getID() == id) {
				list.remove(s);
			}
		}
		
	}
	
}
