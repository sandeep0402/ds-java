package ds.arrays;
import java.util.*;

/* https://leetcode.com/problems/permutations/
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
class FindAllPermuationsOfArray {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permutations(nums, 0, results);
        return results;
    }
    private void permutations(int[] nums, int i, List<List<Integer>> results){
        if(i == nums.length){
            List<Integer> list = new ArrayList<>();
            for(Integer num: nums){
                list.add(num);
            }
            results.add(list);
        }
        for(int j=i; j< nums.length; j++){
            swap1(nums, i, j);
            permutations(nums, i+1, results);
            swap1(nums, i, j);
        }
    }
    private void swap1(int[] nums, int i, int j){
       int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void swap2(int[] nums, int i, int j) {
        if(i==j){
            return;
        }
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
