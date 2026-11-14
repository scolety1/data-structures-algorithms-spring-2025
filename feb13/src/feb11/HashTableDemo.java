package feb11;

public class HashTableDemo {

	public static void main(String[] args) {
		
		StudentHashTable database = new StudentHashTable(100);
		
		database.insert("Joe", "Computer Science", 245006);
		database.insert("Susan", "Math", 111111);
		database.insert("sdkjd", "Math", 222222);		
		database.insert("asdfdsas", "Computer Science", 333333);		
		database.insert("asfdsa", "Computer Science", 444444);
		database.insert("sdddkde", "History", 555555);		
		database.insert("csdasd", "Chemistry", 777777);		
		database.insert("Jack", "Biology", 123456);				
		database.insert("Mr. Collision", "Chaos", 111156);		
		Student findMe = database.lookup(245006);
		System.out.println();
		System.out.println(findMe.getInfo());
		
		database.print();
		System.out.println();
		database.remove(777777);
		database.print();
		System.out.println();
		
		database.countMajors();
	}
}
