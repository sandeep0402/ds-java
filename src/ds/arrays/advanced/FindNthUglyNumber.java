package ds.arrays.advanced;

import java.util.*;
import java.lang.*;
import java.io.*;
/*
Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included. Write a program to find Nth Ugly Number.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. For each testcase there is one line of input that contains the number N.

Output:
Print the Nth Ugly Number.

Constraints:
1 ≤ T ≤ 104
1 ≤ N ≤ 104

Example:
Input:
2
10
4
Output:
12
4

Note 1: Using list or set instead of array consumes more execution time due to internal colleciton methods
Note 2: use "long" array instead of "int", to find nth elements on edges of int range
 */
public class FindNthUglyNumber
 {
	public static void main (String[] args)
	 {
		 Scanner sc = new Scanner(System.in);
        int tests = Integer.parseInt(sc.nextLine());
        for (int k = 0; k < tests; k++) {
           int n = Integer.parseInt(sc.nextLine());
           findNthUglyNumber(n);
        }
	 }
	 public static void findNthUglyNumber(int n){
	     long[] arr = new long[n];
	     int i2 =0, i3 =0, i5 = 0;
	     long mulOf2 = 2, mulOf3 = 3, mulOf5 = 5;
	     long nextUgly = 1;
	     arr[0] = nextUgly;
	     for(int i = 1 ; i< n; i++){
	        nextUgly = Math.min(Math.min(mulOf2, mulOf3), mulOf5);
			 arr[i] = nextUgly;
			 //System.out.println(" Min of " + mulOf2 +" " + mulOf3 +" " + mulOf5);
			 //System.out.println("nextUgly "+ nextUgly+" i2:"+i2+", i3:"+i3
			 //+", i5:" + i5 +" list:"+list);
			 if(nextUgly == mulOf2){
	        	i2++;
	        	mulOf2 = arr[i2] * 2;
			}
			 if(nextUgly == mulOf3){
				 i3++;
				 mulOf3 = arr[i3] * 3;
			 }

			 if(nextUgly == mulOf5){
				 i5++;
				 mulOf5 = arr[i5] * 5;
			 }
	     }
	     System.out.println(nextUgly);
	 }
}