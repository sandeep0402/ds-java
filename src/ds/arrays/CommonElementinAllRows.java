package ds.arrays;

import java.util.Arrays;

/*
 * http://www.joblagao.com/voices/joblagao-university/paytm-one-97-walkin-drive-interview-questions-2015
 * Given a matrix where each row is sorted in increasing order.You have to find element which is common in each row. If that element exist then return the element otherwise return -1.
     Eg.

                        Matrix[4][4]={{2,5,8,14},

                          {3,6,8,9},

                          {1,8,15,17},

                          {2,3,8,10 }}

     Answer - 8
 * Explanation at http://www.geeksforgeeks.org/find-common-element-rows-row-wise-sorted-matrix/
 */
public class CommonElementinAllRows {
	public static void main(String[] args) {
		int[][] array = new int[][]{
				{1,4,6,7},
				{2,3,4,9},
				{0,4,6,78},
				{4,23,34,39}
			};
		System.out.println(commonElement(array));
	}

public static int commonElement(int[][] array){
		int[] nums = new int[array.length];
		boolean isCommonFound = false;
		Integer lastMinNum = null;
		for(int i= array.length - 1; i >= 0 && !isCommonFound; i--){
			for(int j = array[i].length - 1; j >= 0; j--){
				if(lastMinNum == null){
					nums[j] = array[j][i];
				}else if(lastMinNum != nums[j]){
					nums[j] = array[j][i];
				}
			}
			// check if array is having same elements
			int n = nums[0];
			for(int k=1; k<nums.length; k++){
				if(n != nums[k]){
					break;
				}
				if( k == nums.length-1)
					isCommonFound = false;
			}
			if(!isCommonFound){
				for(int k=0; k<nums.length; k++){
					if(lastMinNum == null){
						lastMinNum = nums[k];
					}
					else if(lastMinNum > nums[k]){
						lastMinNum = nums[k];
					}
				}
			}
			System.out.println(Arrays.toString(nums));
			System.out.println("lastMinNum = "+lastMinNum );
		}
		return nums[0];
	}

}
