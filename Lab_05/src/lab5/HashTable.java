package lab5;
import java.util.Random;

public class HashTable {

	// You are welcome to make changes to this class, but you should not remove any of the existing code.

	private Integer[] data;
	private String[] collisions;
	
	public HashTable(int size) {
		this.data = new Integer[size];
		this.collisions = new String[size];
		for(int i = 0; i < collisions.length; i++) {
			collisions[i] = "";
		}
	}
	
	public int hash(int i) {
		return i % data.length;
	}
	
	public void insert(int newEntry) {
		int index = hash(newEntry);
		int probeCount = 0;
		
		while (data[index] != null) {
			index = (index + 1) % data.length;		
			probeCount++;
		}
		
		data[index] = newEntry;
		collisions[index] = "*";
	}


    public void printHashTable() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.println(i + ": " + data[i]);
            } else {
                System.out.println(i + ": ");
            }
        }
    }

    public void insertRandomValues(int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int randomValue = rand.nextInt(1001);
            insert(randomValue);
        }
    }

    public void printCollisionTable() {
        for (int i = 0; i < collisions.length; i++) {
            System.out.println(i + ": " + collisions[i]);
        }
    }

    public int get(int search) {
        int index = hash(search);

        while (data[index] != null) {
            if (data[index] == search) {
                return index;
            }
            index = (index + 1) % data.length;
        }

        return -1;
    }
}