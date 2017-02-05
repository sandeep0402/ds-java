package ds.misc;

/**
 * Count ways to reach nth stair.
    It is similar to fibonacci series. Interviewer asked various ways to implement the same -Recursion, 1-D array, with 3 variables and complexity of each.
 * http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 */
public class StaircaseProblem {
    // Finding ways sing fibonacci problem
    public static int fib(int n) {
        if(n <= 1) 
            return n;
        int n1 = 0;
        int n2 = 1;

        // Taking look to n+1 istead of n, as staircase steps require +1 to get the total count ways
        for(int i = 2; i <= n+1; i++) {
            int fibVal = n1 + n2;
            n1 = n2;
            n2 = fibVal;
            System.out.println(fibVal);
        }
        return n2;
    }
    public static void main(String[] args){
        int ways = fib(5);
        System.out.println("ways : " + ways);
    }
}
