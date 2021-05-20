package ds.arrays;

import java.util.*;

/*
https://leetcode.com/problems/3sum/
Solution:
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
Example 2:
    Input: nums = []
    Output: []
Example 3:
    Input: nums = [0]
    Output: []
 */
public class GivenSum3ElementOfArray {

    /*
    O(N3) Brute force
     */
    public static List<List<Integer>> threeSum_bruteForce(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            for(int j= i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == target){
                        ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        if(! list.contains(newList)) { // check to remove duplicate
                            list.add(newList);
                        }
                    }
                }
            }
        }
        System.out.println("list: " + list);
        return list;
    }

    /*
    O(N2) with extra space
     */
    public static List<List<Integer>> threeSum_ExtraSpace(int[] nums, int target1) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j= i+1; j<nums.length-1; j++){
                int diff = target1 - (nums[i] + nums[j]);
                if(set.contains(diff)){
                    ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(nums[i], diff, nums[j]));
                    if(! list.contains(newList)) { // check to remove duplicate
                        list.add(newList);
                    }
                }else{
                    set.add(nums[j]);
                }
            }
        }
        System.out.println("list: " + list);
        return list;
    }

    /*
    O(N2) without extra space
     Fix the first element and use 2 pointer sliding window
     */
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            int left = i+1;
            int right = nums.length - 1;
            int diff = target - nums[i];
            while (left < right && right > i) {
                if (nums[left] + nums[right] == diff) {
                    ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    if(! list.contains(newList)) {
                        list.add(newList);
                    }
                    right--;
                } else if (nums[left] + nums[right] > diff) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println("list: " + list);
        return list;
    }


    public static void main(String[] args) {
        threeSum_ExtraSpace(new int[]{-1,0,1,2,-1,-4},0); //Expected result [[-1, -1, 2], [-1, 0, 1]]
        threeSum_ExtraSpace(new int[]{0,0,0,0}, 0); //Expected result [[0,0,0]]
        threeSum_ExtraSpace(new int[]{-2,0,1,1,2}, 0); //Expected result [[-2,0,2],[-2,1,1]]
        threeSum_ExtraSpace(new int[]{0}, 0); //Expected result []

        System.out.println("Done");

    }

}
