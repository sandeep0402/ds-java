package ds.arrays;

import java.util.Arrays;

/*
https://leetcode.com/problems/maximum-subarray/
Solution: https://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/

Find the subarray with the max sum:
Given an integer array nums, find the contiguous
subarray (containing at least one number) which has the largest sum and return its sum.
Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:
    Input: nums = [1]
    Output: 1
Example 3:
    Input: nums = [5,4,-1,7,8]
    Output: 23

Constraints:
    1 <= nums.length <= 3 * 104
    -105 <= nums[i] <= 105

Follow up: If you have figured out the O(n) solution, try coding another solution using
the divide and conquer approach, which is more subtle.

 */
public class MaxSumSubArray_via_KadanesAlgorithm {
    // Kadane’s Algorithm
    public static int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE; // Dont init with 0, will fail for array with all negative values
        for(int i =0; i<nums.length; i++){
            currentSum = currentSum + nums[i];    // currentSum update to include current element
            currentSum = Math.max(nums[i], currentSum);   // maximum sum should be more than the current sum
            maxSum = Math.max(maxSum, currentSum); // update maxSum if the current subarray sum is found to be greater
        }
        return maxSum;
    }

    // Kadane’s Algorithm with indices
    public static int maxSubArrayWithIndices(int[] nums) {
        int startIndex = -1;
        int endIndex = -1;
        int currentStartIndex = -1;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE; // Dont init with 0, will fail for array with all negative values
        for(int i =0; i<nums.length; i++){
            currentSum = currentSum + nums[i];    // currentSum update to include current element
            if(nums[i] >= currentSum){
                currentSum = nums[i];
                currentStartIndex = i;
            }
            if(currentSum >= maxSum){
                maxSum = currentSum;
                startIndex = currentStartIndex;
                endIndex = i;
            }
        }
        System.out.println("Start: "+ startIndex +", end: "+ endIndex);
        return maxSum;
    }

    public static void main(String[] args) {
        int result = 0;
        result += runTest(new int[]{-2,1,-3,4,-1,2,1,-5,4},6);
        result += runTest(new int[]{-8,-3,-6,-2,-5,-4}, -2);
        result += runTest(new int[]{5,4,-1,7,8}, 23);
        if(result == 0){
            System.out.println("All test cases passed");
        }else {
            System.err.println("test cases failed: "+ result);
        }
    }

    public static int runTest(int[] nums, int expected){
        int result = maxSubArrayWithIndices(nums);
        if(result != expected){
            System.err.println("Result: "+ result+ ", Expected: "+ expected+", Input: " + Arrays.toString(nums));
            return 1;
        }else{
            System.out.println("Result: "+ result+ ", Expected: "+ expected+", Input: " + Arrays.toString(nums));
            return 0;
        }
    }
}
