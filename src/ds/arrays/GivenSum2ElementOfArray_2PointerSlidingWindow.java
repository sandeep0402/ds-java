package ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/ (similar not exact)
Solution: https://www.callicoder.com/two-sum-problem/
Given an array of integers nums and an integer target, return two numbers(not indices) such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]
Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]
Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
Only one valid answer exists.
 */
public class GivenSum2ElementOfArray_2PointerSlidingWindow {

    /*
    O(N Log N), this approach is called a two-pointer sliding window approach. It will work only when you need elements itself but not the indices. As in this approach, we will sort the array so indices will be changed but elements can be found efficiently.
Sort the array. Initialize two variables, one pointing to the beginning of the array (left) and another pointing to the end of the array (right).
Loop until left < right, and for each iteration
     */
    public static int[] twoSum_2PointerSlidingWindow(int[] nums, int target) {
        System.out.println("2 Pointer window approach - O(N LOG N)");
        int left = 0;
        int right = nums.length -1;
        Arrays.sort(nums);
        while(left < right){
            if(nums[left] + nums[right] == target){
                return new int[]{nums[left], nums[right]};
            }else if(nums[left] + nums[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int failed = 0;
        failed += runTest(new int[]{2,7,11,15},9,new int[]{2,7});
        failed += runTest(new int[]{12, 3, 23, 4}, 7,new int[]{3,4});

        if(failed == 0){
            System.out.println("All test cases passed");
        }else {
            System.err.println("test cases failed: "+ failed);
        }
    }

    public static int runTest(int[] nums, int target, int[] expected){
        int[] result = twoSum_2PointerSlidingWindow(nums, target);
        if(!Arrays.equals(result,expected)){
            System.err.println("Result: "+ Arrays.toString(result)+ ", Expected: "+ Arrays.toString(expected)+", Input: " + Arrays.toString(nums));
            return 1;
        }else{
            System.out.println("Result: "+ Arrays.toString(result)+ ", Expected: "+ Arrays.toString(expected)+", Input: " + Arrays.toString(nums));
            return 0;
        }
    }
}
