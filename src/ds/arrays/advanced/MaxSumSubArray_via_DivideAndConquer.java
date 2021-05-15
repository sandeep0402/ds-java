package ds.arrays.advanced;

import java.util.Arrays;

/*
https://leetcode.com/problems/maximum-subarray/
Solution: https://iq.opengenus.org/maximum-subarray-sum-divide-and-conquer/

Find the subarray with the max sum with Time complexity O(N Log N):
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
public class MaxSumSubArray_via_DivideAndConquer {
    // Divide and Conquer
    public static int maxSubArray(int[] nums, int start, int end) {
        if(start == end){
            return nums[start];
        }
        int mid = (start + end)/2;
        int leftSum = maxSubArray(nums, start, mid);
        int rightSum = maxSubArray(nums, mid+1, end);
        int midPointSum = midPointSum(nums, start, mid, end);
        return Math.max(midPointSum, Math.max(leftSum, rightSum));
    }

    public static int midPointSum(int[] nums, int start, int mid, int end) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        for(int i=mid; i>=start; i--){
            sum += nums[i];
            if(sum > leftSum){
                leftSum = sum;
            }
        }
        sum = 0;
        for(int i=mid+1; i<=end; i++){
            sum += nums[i];
            if(sum > rightSum){
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
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
        int maxSum = maxSubArray(nums, 0, nums.length-1);
        if(maxSum != expected){
            System.err.println("Result: "+ maxSum+ ", Expected: "+ expected+", Input: " + Arrays.toString(nums));
            return 1;
        }else{
            System.out.println("Result: "+ maxSum+ ", Expected: "+ expected+", Input: " + Arrays.toString(nums));
            return 0;
        }
    }
}
