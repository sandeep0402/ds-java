package ds.arrays.advanced;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
https://practice.geeksforgeeks.org/problems/maximum-prefix-sum-for-a-given-range/0

Given an array of n integers and q queries, each query having a range from l to r. Find the maximum prefix-sum for the range l to r.
NOTE: Assume indexing from 0.

Input: a[] = {-1, 2, 3, -5}
       q = 2
       l = 0, r = 3
       l = 1, r = 3

Output: 4
        5

Explanation:- The range (0, 3) in the 1st query has
              [-1, 2, 3, -5], since it is prefix,
              we have to start from -1. Hence, the
              max prefix sum will be -1 + 2 + 3 = 4.
              The range (1, 3) in the 1st query has
              [2, 3, -5], since it is prefix, we
              have to start from 2. Hence, the max
              prefix sum will be 2 + 3 = 5.
Input:
The first line consists of an integer T i.e number of test cases. The first line of each test case consists of two integers n and q.Then next line consists of n spaced integers. The last line of each test case consists of q pairs of integers representing l and r.

Output:
Print the required answer.

Constraints:
1<=T<=100
1<=n,q,a[i]<=104

Example:
Input:
2
4 2
-1 2 3 -5
0 3 1 3
8 1
-2 -3 4 -1 -2 1 5 -3
1 7

Output:
4 5
4
 */
public class MaxPrefixSumForRange {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();

		while (tests-- > 0) {
			System.out.println("s1");

			int n = sc.nextInt();
			int queries = sc.nextInt();
			//System.out.println("size:" + size+", queries:"+queries)
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println("s2");

			//System.out.println("Array = " + Arrays.toString(arr));

			//System.out.println("Ranges = " + Arrays.toString(qs));
			for(int i=0; i<queries*2; i=i+2){
				System.out.println("s3.1 i="+i);
				int r1 = sc.nextInt();
				int r2 = sc.nextInt();
				System.out.println("s3.2 i="+i);
				int sum = findPrefixSum(arr,r1, r2);
				System.out.println("s3.3 i="+i);
				System.out.print(sum + " ");
			}
			System.out.println("done");
		}
	}
	static int findPrefixSum(int arr[], int startIndex, int lastIndex) {
		int sum = 0;
		for(int i = startIndex; i<lastIndex; i++){
			sum += arr[i];
		}
		return sum;
	}
}