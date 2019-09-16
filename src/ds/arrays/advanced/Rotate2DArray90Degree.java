package ds.arrays.advanced;

import java.util.Arrays;
import java.util.Scanner;

/*
https://practice.geeksforgeeks.org/problems/rotate-a-2d-array-without-using-extra-space/0
Best solution on this link:-
https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

1 2 3 4 5 6 7 8 9

Then the rotated array becomes:

7 4 1 8 5 2 9 6 3

Input:

The first line contains an integer 'T' denoting the total number of test cases.
In each test cases, the first line contains an integer 'N' denoting the size of the 2D square matrix.

And in the second line, the elements of the matrix A[][], each separated by a space in row major form.


Output:

For each test case, print the elements of the rotated array row wise, each element separated by a space. Print the output of each test case in a new line.


Constraints:

1 ≤ T ≤ 70
1 ≤ N ≤ 10
1 ≤ A [ i ][ j ] ≤ 100


Example:

Input:

2
3
1 2 3 4 5 6 7 8 9
2
56 96 91 54

Output:

7 4 1 8 5 2 9 6 3
91 56 54 96


 */
class Rotate2DArray90Degree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = Integer.parseInt(sc.nextLine());
		for (int k = 0; k < tests; k++) {

			int size = Integer.parseInt(sc.nextLine());
			String[] arr1 = sc.nextLine().trim().split(" ");
			int[][] arr = new int[size][size];
			int count = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arr[i][j] = Integer.parseInt(arr1[count]);
					count++;
				}
			}
			//System.out.println(Arrays.toString(arr));
			rotateAndPrint(arr);
			System.out.println();
		}
	}

	public static void rotateAndPrint(int[][] arr) {
		int size = arr.length;
		int a = 0, b = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				a = Math.abs((size-1) - j);
				b = i;
				//System.out.println("Printing arr["+a+"]["+b+"]="+arr[a][b]);
				System.out.print(arr[a][b] + " ");
			}
		}
	}
}