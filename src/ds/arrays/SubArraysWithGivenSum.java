package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubArraysWithGivenSum {

    // Function to print subarray with sum as given sum
    public static void findGivenSumSubarray(int arr[], int givenSum) {
        int sum = 0;
        int sStart = 0, sEnd = Integer.MAX_VALUE - 1;  // Start & end position of the shortest sub-array
        int lStart = Integer.MAX_VALUE - 1, lEnd = 0;  // Start & end position of the longest  sub-array

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        ArrayList<Integer> initialIndex = new ArrayList<>();
        initialIndex.add(-1);
        map.put(0, initialIndex);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ArrayList<Integer>  indexes = map.get(sum - givenSum);
            if (indexes != null) {
                for (int index : indexes) {
                    System.out.println("sum ="+sum+" sum-givenSum=" + (sum - givenSum) +" From #" + (index + 1) + " to #" + i);
                }
                if (i - indexes.get(indexes.size() - 1) < (sEnd - sStart + 1)) {
                    sStart = indexes.get(indexes.size() - 1) + 1;
                    sEnd = i;
                }
                if (i - indexes.get(0) > (lEnd - lStart + 1)) {
                    lStart = indexes.get(0) + 1;
                    lEnd = i;
                }
            }
            indexes = map.get(sum);
            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            map.put(sum, indexes);
            System.out.println(map);
        }

        if(sStart == 0 && lEnd == 0){
            System.out.println("No sub array present with given sum");
        }else{
            System.out.println("Shortest sub-arry: Length = " + (sEnd - sStart + 1) + ", [" + sStart + " - " + sEnd + "]");
            System.out.println("Longest  sub-arry: Length = " + (lEnd - lStart + 1) + ", [" + lStart + " - " + lEnd + "]");
        }
    }

    public static void main(String[] args) {
        int[] array =  {10, 2, -2, -20, 10};
        int requiredSum = -10;
        System.out.println(Arrays.toString(array) + ", requiredSum=" + requiredSum);
        new SubArraysWithGivenSum().findGivenSumSubarray(array, requiredSum);
    }
}
