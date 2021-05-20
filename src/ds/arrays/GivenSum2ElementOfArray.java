package ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/
Solution: https://www.callicoder.com/two-sum-problem/
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
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
public class GivenSum2ElementOfArray {

    // Log(n2)
    public static int[] twoSum_BruteForce(int[] nums, int target) {
        System.out.println("Brute force approach - O(N2)");
        for(int i= 0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(target == nums[i] + nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    // Log(n2)
    public static int[] twoSum_additionalSpace(int[] nums, int target) {
        System.out.println("\033[0;1m" + "Additional space approach - O(N)");
        Map<Integer, Integer> map = new HashMap<>();
        for(int i= 0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }else{
                map.put(nums[i], i);
            }
        }
        System.out.println(map.keySet());
        return new int[]{};
    }

    public static void main(String[] args) {
        int failed = 0;
        failed += runTest(new int[]{2,7,11,15},9,new int[]{0,1}, true);
        failed += runTest(new int[]{12, 3, 23, 4}, 7,new int[]{1,3}, true);


        failed += runTest(new int[]{2,7,11,15},9,new int[]{0,1}, false);
        failed += runTest(new int[]{12, 3, 23, 4}, 7,new int[]{1,3}, false);

        if(failed == 0){
            System.out.println("All test cases passed");
        }else {
            System.err.println("test cases failed: "+ failed);
        }
    }

    public static int runTest(int[] nums, int target, int[] expected, boolean bruteFoce){
        int[] result;
        if(bruteFoce){
            result = twoSum_BruteForce(nums, target);
        }else{
            result = twoSum_additionalSpace(nums, target);
        }
        if(!Arrays.equals(result,expected)){
            System.err.println("Result: "+ Arrays.toString(result)+ ", Expected: "+ Arrays.toString(expected)+", Input: " + Arrays.toString(nums));
            return 1;
        }else{
            System.out.println("Result: "+ Arrays.toString(result)+ ", Expected: "+ Arrays.toString(expected)+", Input: " + Arrays.toString(nums));
            return 0;
        }
    }
}
