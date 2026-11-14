package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;


public class Lab7Demo {

	public static void main(String[] args) {
		Random random = new Random();
		final int num = 100000;

		List<Integer> arrayList = new ArrayList<>();
		long start_time = System.nanoTime();
		for(int i = 0; i < num; i++) {
			arrayList.add(random.nextInt());
		}
		long end_time = System.nanoTime();
		long elapsed_time = (end_time - start_time);
		double time = elapsed_time / 1000000.0;
		System.out.println("ArrayList time: " + time + "ms.");

		
		
		List<Integer> linkedList = new LinkedList<>();
		start_time = System.nanoTime();
		for(int i = 0; i < num; i++) {
			linkedList.add(random.nextInt());
		}
		end_time = System.nanoTime();
		elapsed_time = (end_time - start_time);
		time = elapsed_time / 1000000.0;
		System.out.println("LinkedList time: " + time + "ms.");
		
		
		Set<Integer> treeSet = new TreeSet<>();
		start_time = System.nanoTime();
		for(int i = 0; i < num; i++) {
			treeSet.add(random.nextInt());
		}
		end_time = System.nanoTime();
		elapsed_time = (end_time - start_time);
		time = elapsed_time / 1000000.0;
		System.out.println("TreeSet time: " + time + "ms.");
		
		
		Set<Integer> hashSet = new HashSet<>(150000);
		start_time = System.nanoTime();
		for(int i = 0; i < num; i++) {
			hashSet.add(random.nextInt());
		}
		end_time = System.nanoTime();
		elapsed_time = (end_time - start_time);
		time = elapsed_time / 1000000.0;
		System.out.println("HashSet time: " + time + " ms.");
		
		
	}
}
