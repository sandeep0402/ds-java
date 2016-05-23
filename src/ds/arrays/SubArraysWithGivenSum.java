package ds.arrays;
import java.util.Arrays;

public class SubArraysWithGivenSum {

	public void findRequiredSumSubArray(int[] array, int requiredSum) {
		int start = 0;
		int sum = 0;
		int length = array.length;

		for (int i = 0; i < length; i++) {
			sum = 0;
			start = i;
			for (int j = i; j < length; j++) {
				if (sum + array[j] > requiredSum) {
					break;
				} else if (sum + array[j] < requiredSum) {
					sum += array[j];
				} else {
					int[] subArr = Arrays.copyOfRange(array, start, j + 1);
					System.out.println(Arrays.toString(subArr));
					start = j;
					sum = array[j];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = { 6, 2, 3, 10, 5, 9, 12 };
		int requiredSum = 21;
		new SubArraysWithGivenSum().findRequiredSumSubArray(array, requiredSum);
	}	
}