package mar4;

import java.util.Arrays;

public class MinHeap {

	private int[] data;
	private int capacity;
	private int size;
	
	public MinHeap() {
		this.data = new int[5];
		this.capacity = data.length;
		this.size = 0;
	}
	
	public void add(int newItem) {
		
		addMoreCapacityIfNeeded();
		data[size] = newItem;
		size++;
		
		heapifyUp();
		
	}
	
	private void addMoreCapacityIfNeeded() {
		// TODO Auto-generated method stub
		if(size == capacity) {
			data = Arrays.copyOf(data, capacity + 1);
			capacity++;
		}
	}

	public int poll() {
		if(size == 0) {
			return -1;
		}
		
		int min = data[0];
		
		data[0] = data[size -1];
		size--;
		heapifyDown(data.length, 0);
		data = Arrays.copyOf(data, data.length - 1);
		return min;
	}
	
	public void heapifyDown(int bound, int current) {
		
		int smallest_child = current;
		int left_child_index = getLeftChildIndex(current);
		int right_child_index = getRightChildIndex(current);
		
		if(left_child_index < bound && data[left_child_index] < data[smallest_child]) {
			smallest_child = left_child_index;
		}
		
		if(right_child_index < bound && data[right_child_index] < data[smallest_child]) {
			smallest_child = right_child_index;
		}
		
		if(smallest_child != current) {
			swap(current, smallest_child);
			heapifyDown(bound, smallest_child);
		}
		
		
		
	}
	
	public void heapifyUp() {
		int current = size - 1;
		while(hasParent(current) && data[getParentIndex(current)] > data[current]) {
			swap(getParentIndex(current), current);
			current = getParentIndex(current);
		}
	}
	
	public void printHeap() {
		System.out.println(Arrays.toString(data));
	}
	
	public void swap(int indexOne, int indexTwo) {
		int temp = data[indexOne];
		data[indexOne] = data[indexTwo];
		data[indexTwo] = temp;
	}
	
	//helper
	public int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}
	public int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}
	public int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}
	
	public boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	public boolean hasRightChild(int index ) {
		return getRightChildIndex(index) < size;
	}
	
	public boolean hasParent(int index) {
		return index > 0;
	}
	
	
	
	
	
	
}
