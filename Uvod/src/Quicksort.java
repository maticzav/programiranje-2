import java.util.Arrays;
import java.util.Random;

public class Quicksort {

	private static Random r = new Random();

	public static void main(String[] args) {
		final int SIZE = 7;
		
		// Create a randomly populated array of integers.
		float[] nums = new float[SIZE];
		for (int i = 0; i < SIZE; i++) nums[i] = r.nextFloat();
		
		// Data
		System.out.print("Before sorting:");
		System.out.println(Arrays.toString(nums));
		
		// Quicksort
		quicksort(nums, 0, SIZE - 1);
		
		// Results
		System.out.print("After sorting:");;
		System.out.print(Arrays.toString(nums));
		
	}
	
	private static void quicksort(float[] array, int i, int j) {
		// If i = j then the array being sorted is empty. We only want to sort
		// arrays with two or more elements.
		if (i < j) {
			// First, we randomly choose a pivot;
			int pix = i + r.nextInt(j - i + 1);
			
			// Partition the array.
			int p = partition(array, i, j, pix);

			// Recurse down. We don't need to sort the pivot.
			quicksort(array, i, p - 1);
			quicksort(array, p + 1, j);
		}
	}
	
	private static int partition(float[] array, int i, int j, int p) {
		float pval = array[p];

		while (i < j) {
			if (array[i] < pval) { i++; } // smaller elements stay on the left
			else if (array[j] > pval) { j--; } // larger elements stay on the right
			else if (array[i] == pval && array[j] == pval) { j--; } // handles pivot repetitions
			else { // switch the numbers if none of the above matched
				float temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		
		return i;
	}

}
