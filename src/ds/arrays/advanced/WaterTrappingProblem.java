package ds.arrays.advanced;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/trapping-rain-water/
 * https://www.youtube.com/watch?v=KV-Eq3wYjxI
 */
public class WaterTrappingProblem {

    public static void main(String[] args) {
        int[] arr = new int[]{3,0,2,0, 4} ;
            // {3,0,2,0, 4}          7 UNITS
        // {2,0,2}   2UNITS
        // {3,0,0,2,0,4}    10 UNITS
        // {0,1,0,2,1,0,1,3,2,1,2,1}   6 UNITS
        System.out.println("Array= " + Arrays.toString(arr));
        int units = trapWater(arr);
        System.out.println("Total water trapped= " + units + " units.");

    }

    public static int trapWater(int arr[]) {
        int length = arr.length;
    // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int[] left = new int[length];

    // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int[] right = new int[length];

        // Initialize result
        int water = 0;

        // Fill left array
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                left[i] = arr[i];
            } else {
                left[i] = Math.max(left[i - 1], arr[i]);
            }
        }
        System.out.println("left=" + Arrays.toString(left));
        // Fill right array
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                right[i] = arr[i];
            } else {
                right[i] = Math.max(right[i + 1], arr[i]);
            }
        }
        System.out.println("right=" + Arrays.toString(right));
        System.out.println();
    // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < length; i++) {
            System.out.print(Math.min(left[i], right[i]));System.out.print(",");
            water += Math.min(left[i], right[i]) - arr[i];
        }

        return water;
    }
}
