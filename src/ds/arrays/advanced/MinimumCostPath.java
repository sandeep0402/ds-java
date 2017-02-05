package ds.arrays.advanced;

/**
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0,
 * 0). Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that
 * path (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given
 * cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
 * 
 * @see http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 * 
 */
class MinimumCostPath{
    /* Method 1: using recursion 
    issue: It should be noted that the above function computes the same subproblems again and again. */
    public static int minCostRecuresive(int[][] cost, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return cost[m][n];
        }
        return cost[m][n] + Math.min(Math.min(minCostRecuresive(cost, m - 1, n), minCostRecuresive(cost, m, n - 1)), 
                                minCostRecuresive(cost, m - 1, n - 1));
    }

    /* Method 1(Effiecient: using Dynamic programming     */
    private static int minCostDP(int cost[][], int m, int n)
    {
        int i, j;
        int tc[][]=new int[m+1][n+1];
 
        tc[0][0] = cost[0][0]; 
        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];
 
        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];
 
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)                
                tc[i][j] = Math.min( Math.min(tc[i-1][j], tc[i][j-1]), tc[i-1][j-1])
                            + cost[i][j];
        return tc[m][n];
    }
    
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        System.out.println("minimum cost to reach (2,2) = " +
                                         minCostDP(cost,2,2));
    }
}