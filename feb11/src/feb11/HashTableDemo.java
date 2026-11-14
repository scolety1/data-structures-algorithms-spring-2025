package feb11;

public class HashTableDemo {

	public static void main(String[] args) {
		
		StudentHashTable database = new StudentHashTable(100);
		
		database.insert("Joe", "Computer Science", 245006);
		database.insert("Susan", "Math", 777777);
		database.insert("Jac", "Biology", 123456);		
		database.insert("Mr. Collision", "Chaod", 111156);		
		Student findMe = database.lookup(245006);
		System.out.println();
		//System.out.println(findMe.getInfo());
		
		database.print();
		System.out.println();
		database.remove(777777);
		database.print();
	}

}
