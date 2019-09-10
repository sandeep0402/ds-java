package ds.arrays.advanced;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
Reference: https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Expected Time Complexity: O(n)

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.

Output:
Corresponding to each test case, print the kth smallest element in a new line.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N

Example:
Input:
2
6
7 10 4 3 20 15
3
5
7 10 4 20 15
4

Output:
7
15

Explanation:
Testcase 1: 3rd smallest element in the given array is 7.

 */
public class KthSmallestElementInArray {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			int k = sc.nextInt();
			System.out.println("Input: " + Arrays.toString(arr) +" Kth index: "+ k);
			System.out.println(kthsmallest(arr, 0, n - 1, k));
		}
	}
	static int kthsmallest(int arr[], int startIndex, int lastIndex, int k) {
		// If k is smaller than number of elements in array
		if (k > 0 && k <= lastIndex - startIndex + 1) {

			System.out.println("call randomPartition: arr:" + Arrays.toString(Arrays.copyOfRange(arr, startIndex, lastIndex+1))
							   + " startIndex:"+ startIndex + " lastIndex:" +lastIndex);
			// partitioning the array along the pivot
			int pos = randomPartition(arr, startIndex, lastIndex);

			System.out.println("Position received: "+ pos
			 +" findal postion if (pos-startIndex==k-1)="+"("+pos
			+"-"+startIndex+"=="+k+"-"+1+")=>"+(pos - startIndex == k - 1));
			// check if current element gives you the kth smallest element
			if (pos - startIndex == k - 1) {
				return arr[pos];
			}

			System.out.println("Recurse on left if true otherwise on right \n"
							   + " (pos - startIndex > k - 1)="
							   +"("+pos +"-"+startIndex+">"+k+"-"+1+")=>" + (pos - startIndex > k - 1));
			// else recurse for the left and right half accordingly
			if (pos - startIndex > k - 1) {
				return kthsmallest(arr, startIndex, pos - 1, k);
			}
			return kthsmallest(arr, pos + 1, lastIndex, k - pos + startIndex - 1);
		}

		return Integer.MAX_VALUE;
	}

	static int partition(int arr[], int startIndex, int lastIndex) {
		System.out.println("\t start Partition arr: "
						   + Arrays.toString(Arrays.copyOfRange(arr, startIndex, lastIndex+1))
						   + " startIndex:"+ startIndex +" lastIndex:"+lastIndex
							+" x="+ arr[lastIndex]);
		int x = arr[lastIndex], i = startIndex;
		for (int j = startIndex; j <= lastIndex - 1; j++) {
			if (arr[j] <= x) {
				System.out.println("\t in Partition, swapping if (arr[j] <= x)= "
								   + "("+arr[j]+"<= "+x+") => "+(arr[j] <= x));
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
				System.out.println("\t In Partition, after swap arr: "+ Arrays.toString(Arrays.copyOfRange(arr, startIndex, lastIndex+1)));
			}else{
				System.out.println("\t in Partition, No swapping if (arr[j] <= x)= "
								   + "("+arr[j]+"<= "+x+") => "+(arr[j] <= x));
			}
		}
		System.out.println("\t in Partition, swap lastIndex(last swapped index) with ith "
						   + "arr["+lastIndex+"] with arr["+i+"] => "
						   + arr[lastIndex]+" with " + arr[i]);
		int temp = arr[lastIndex];
		arr[lastIndex] = arr[i];
		arr[i] = temp;
		System.out.println("\t After partition arr: "+ Arrays.toString(Arrays.copyOfRange(arr, startIndex, lastIndex+1))
						   + " partition index:"+ i);
		return i;
	}

	// Function to partition the array along the random pivot
	static int randomPartition(int arr[], int startIndex, int lastIndex) {
		Random rand = new Random();
		int n = lastIndex - startIndex + 1;
		// approach 1, use random number as pivot and then swap with last number
		int pivot = rand.nextInt(n);
		System.out.println("in randomPartition, pivot: "+ pivot);
		int temp = arr[lastIndex];
		arr[lastIndex] = arr[startIndex + pivot];
		arr[startIndex + pivot] = temp;
		// approach 2, use last index as pivot and no swap. but takes 50% time more than approach 1
		// int pivot = lastIndex;
		System.out.println("in randomPartition, updated arr: "+ Arrays.toString(Arrays.copyOfRange(arr, startIndex, lastIndex+1))
						   + " startIndex:"+startIndex+" lastIndex:"+lastIndex);
		return partition(arr, startIndex, lastIndex);
	}


}