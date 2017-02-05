package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
http://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
http://stackoverflow.com/questions/5534063/zero-sum-subarray
It include contigous pairs
*/
public class SubArraysGivenSumInclNegative {

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
            if (map.containsKey(sum - givenSum)) {
                ArrayList<Integer>  indexes = map.get(sum - givenSum);                
                for (int index : indexes) {
                    System.out.println("sum ="+sum+" sum-givenSum=" + (sum - givenSum) +" From #" + (index + 1) + " to #" + i);
                }
                // indexes.get(indexes.size() - 1) means last index present in list
                // (sEnd - sStart + 1) means means the last possible index
                // if currentIndex - list's last index < last possible index
                if (i - indexes.get(indexes.size() - 1) < (sEnd - sStart + 1)) {
                    sStart = indexes.get(indexes.size() - 1) + 1;
                    sEnd = i;
                }
                if (i - indexes.get(0) > (lEnd - lStart + 1)) {
                    lStart = indexes.get(0) + 1;
                    lEnd = i;
                }
            }
            ArrayList<Integer>  indexList = map.get(sum);
            if (indexList == null) {
                indexList = new ArrayList<>();
            }
            indexList.add(i);
            map.put(sum, indexList);
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
        findGivenSumSubarray(array, requiredSum);
    }
}
