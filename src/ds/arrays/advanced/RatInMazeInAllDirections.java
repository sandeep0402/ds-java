package ds.arrays.advanced;

import java.util.ArrayList;
import java.util.Collections;

/*
https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

Consider a rat placed at (0, 0) in a square matrix m[][] of order n and has to reach the destination at (n-1, n-1). Your task is to complete the function printPath() which returns a sorted array of strings denoting all the possible directions which the rat can take to reach the destination at (n-1, n-1). The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line contains an integer n denoting the size of the square matrix. The next line contains n*n space separated values of the matrix m where 0's represents blocked paths and 1 represent valid paths.

Output:
For each test case output will be space separated sorted strings denoting all directions, which the rat could take to reach the destination.

User Task:
Since this is functional problem you don't have to worry about input, you just have to complete the function printPath()

Constraints:
1 <= T <= 10
2 <= n <= 10
0 <= m[][] <= 1

Example
Input:
2
4
1 0 0 0 1 1 0 1 0 1 0 0 0 1 1 1
4
1 0 0 0 1 1 0 1 1 1 0 0 0 1 1 1

Output:
DRDDRR
DDRDRR DRDDRR

Explanation:
Testcase 2: The given input is in the form
1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1
For the above matrix the rat can reach the destination at (3, 3) from (0, 0) by two paths ie DRDDRR and DDRDRR when printed in sorted order we get DDRDRR DRDDRR.

Input:
7
1 1 0 1 1 0 1 0 1 0 0 1 1 1 1 1 1 1 0 1 0 0 1 0 1 1 1 1 0 1 0 0 1 0 1 0 1 1 1 1 0 1 0 0 0 0 1 1 1

Its Correct output is:
RDDDDDRRRDRR RDDDDDRRRUURRDDD RDDRRDRDDDRR RDDRRDRRRDDD

And Your Code's output is:
RDDDDDRRRDRR RDDRRDRDDDRR RDDRRDRRRDDD
 */
class RatInMazeInAllDirections {

    public static void main(String args[]) {
        //int[][] arr = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {0, 1, 1, 1}};
        int[][] arr = { {1, 1, 0, 1, 1, 0, 1},
                        {0, 1, 0, 0, 1, 1, 1},
                        {1, 1, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 1, 1},
                        {0, 1, 0, 0, 1, 0, 1},
                        {0, 1, 1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1, 1, 1}};
        System.out.println(printPath(arr, arr.length));
    }

	public static ArrayList<String> printPath(int[][] m, int n)
     {
         boolean[][] visits = new boolean[n][n];
         ArrayList<String> paths = findPath(m,visits, "", 0, 0);
         if(paths !=null && !paths.isEmpty()){
             Collections.sort(paths);
         }
         return paths;
     }
     
     public static ArrayList<String> findPath(int[][] arr,boolean[][] visits, String path, int i, int j){
         System.out.println("Path="+ path +", i="+i+", j="+j);
         ArrayList<String> paths = new ArrayList<String>();
         int size = arr.length;
         if( i == size-1 && j == size-1){  // last element
             paths.add(path);
             return paths;
         }
         visits[i][j] = true;
         if(isSafe(arr, visits, size, i + 1,j)){
             AddPaths(paths,
                     findPath(arr, visits, path + "D", i+1, j));
         }
         if(isSafe(arr, visits, size, i, j + 1)){
             AddPaths(paths,
                     findPath(arr, visits, path + "R", i, j+1));
         }
         if(isSafe(arr, visits, size, i - 1,j)){
             AddPaths(paths,
                     findPath(arr, visits, path + "U", i-1, j));
         }
         if(isSafe(arr, visits, size, i, j - 1)){
             AddPaths(paths,
                     findPath(arr, visits, path + "L", i, j-1));
         }
         visits[i][j] = false;
         return paths;
     }

    private static void AddPaths(ArrayList<String> paths, ArrayList<String> paths1) {
        if(paths1 != null && !paths1.isEmpty()){
		   paths.addAll(paths1);
		}
    }

    private static boolean isSafe(int[][] arr, boolean[][] visits, int size, int i, int j){
         return (i>=0 && j>=0 && i<size && j<size) // within range
                && arr[i][j]==1              // path open
                && !visits[i][j];            // not visited
    }
}
