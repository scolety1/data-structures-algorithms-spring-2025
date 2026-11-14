package lab6;

import java.util.Arrays;

public class HeapSort implements HeapSortMethods{
	
	private int[] data;
	private int size;
	
	public HeapSort(int[] array) {
		this.data = array;
		this.size = array.length;
	}

	@Override
	public int[] heapSort() {
		buildHeap();
		
		for(int i = size - 1; i > 0; i--) {
			swap(0,i);
			heapifyDown(i,0);
		}
		return data;
	}
	
	@Override
	public void buildHeap() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapifyDown(size, i);
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
		
		int largest_child = current;
		int left_child_index = getLeftChildIndex(current);
		int right_child_index = getRightChildIndex(current);
		
		if(left_child_index < bound && data[left_child_index] > data[largest_child]) {
			largest_child = left_child_index;
		}
		
		if(right_child_index < bound && data[right_child_index] > data[largest_child]) {
			largest_child = right_child_index;
		}
		
		if(largest_child != current) {
			swap(current, largest_child);
			heapifyDown(bound, largest_child);
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