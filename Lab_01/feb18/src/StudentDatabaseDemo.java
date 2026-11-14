
public class StudentDatabaseDemo {

	public static void main(String[] args) {
		
		StudentDatabase database = new StudentDatabase(97);
		
		database.insert("Joe","Computer Science",245097, 3.0);
		database.insert("Sally","Math",123456, 4.0);
		database.insert("Sam","Politcal Science",121212, 2.5);
		
		database.insert("Collision","Politcal Science",245000, 2.5);
		database.insert("Hi","Politcal Science",245194, 2.5);
	
		database.print();
		
		//Student s = database.get(245097);
		//s.printInfo();
		
		System.out.println();
		
		database.remove(245000);
		database.print();
		
	}

}
