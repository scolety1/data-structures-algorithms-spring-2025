package april8;

import java.util.Collections;
import java.util.LinkedList;

public class KnapsackDemo {
public static void main(String[] args) {
        
        LinkedList<Item> items = new LinkedList<Item>();
        double weight_capacity = 35;  // capacity of the knapsack
        
        // Add items. Format: Name, Value, Weight
        items.add(new Item("Gold Bar",100,20));
        items.add(new Item("Emerald Bar",40,5));
        items.add(new Item("Ruby Bar",13,10));
        items.add(new Item("Silver Bar",88,12));
        items.add(new Item("Sapphire Bar",52,8));
        items.add(new Item("Copper Bar",13,8));
        items.add(new Item("Quartz Bar",1,12));
        items.add(new Item("Pearl",20,1));
                    
        Collections.sort(items, Collections.reverseOrder());
        
        LinkedList<Item> knapsack = new LinkedList<Item>();
        double current_weight = 0.0;
        
        for(Item each: items) {
        	if(current_weight == weight_capacity) {
        		break;
        	}
        	if(each.getWeight() + current_weight < weight_capacity) {
        		knapsack.add(each);
        		current_weight += each.getWeight();
        	}
        	else {
        		double weight_taken = (weight_capacity - current_weight);
        		String name = each.getName() + "(F)";
        		double value = weight_taken * each.getRatio();
        		double weight = weight_taken;
        		knapsack.add( new Item(name, value, weight));
        		current_weight += weight;
        	}
        }
        for(Item s: knapsack) {
        	System.out.println(s.getName() + " " + s.getValue());
        }
    }
}
