import java.util.Arrays;
import java.util.Random;

public class HybridSort {
	private int[] numbers;
	private int[] helper;
	private static int[] numbrs;

	private final static int SIZE = 20;
	private final static int MAX = 20;

	private int number;

	public static void main(String[] args) {
		HybridSort sorter = new HybridSort();
		numbrs = new int[SIZE];
		Random generator = new Random();
		for (int i = 0; i < numbrs.length; i++) {
			numbrs[i] = generator.nextInt(MAX);
		}
		
		System.out.println("Before Sort:" + Arrays.toString(numbrs));

		sorter.sort(numbrs);
		
		System.out.println("After Sort:" + Arrays.toString(numbrs));
		
	}

	public void sort(int[] values) {
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		mergesort(0, number - 1);
	}

	private void mergesort(int low, int high) {
		
		if (high - low <= 10) {
			insertionSort(numbers);
		}
		// check if low is smaller than high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergesort(low, middle);

			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}
	
	public static void insertionSort(int array[]) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }
	}
}
