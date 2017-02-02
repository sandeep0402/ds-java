package ds.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/*
http://stackoverflow.com/questions/18305843/find-all-subsets-that-sum-to-a-particular-value
It include contigous and noncontiguous pairs
*/
public class SubArraysAllPairsGivenSumInclNegative {
    /*
     * in d subsets in array whose sum equal to a given number??
     example: S={1,3,5,2,7} and k=10, answer is {1,2,7},{3,5,2},{3,7}  
     */

    /**
     * The collection for storing the unique sets that sum to a target.
     */
    private static HashSet<List<Integer>> map = new HashSet<>();

    /**
     * The String token
     */
    private static final String token = " ";

    /**
     * The method for finding the subsets that sum to a target.
     */
    public static void findTargetSumSubsets(int[] input, int target,List<Integer> list, int index) {
        if(list == null){
            list = new ArrayList();
        }
        if(index > (input.length - 1)) {
            if(getSum(list) == target) {
                map.add(list);
            }            
            return;
        }
        //Second recursive call going ahead WITHOUT selecting the int at the currenct index value
        findTargetSumSubsets(input, target, new ArrayList(list), index + 1);        
        list.add(input[index]);
        //First recursive call going ahead selecting the int at the currenct index value
        findTargetSumSubsets(input, target, list, index + 1);
    }

    private static int getSum(List<Integer> list) {
        int sum = 0;
        for (Integer list1 : list) {
            sum+= list1;
        }
        return sum;
    }    

    /**
     * Cracking it up here : )
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int [] n = {10, 2, -2, -20, 10};// {24, 1, 15, 3, 4, 15, 3};
        int givenSum = -10;//25;
        findTargetSumSubsets(n, givenSum, null, 0);
        System.out.println(map);
    }
}
