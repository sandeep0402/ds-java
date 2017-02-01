package ds.arrays;

import java.util.Arrays;

public class SubArrayMaxSum {

    public static void main(String[] args) {
        //int[] arr = {-2, -5, 6, -3, -3, 2, 5, -6};
        int[] arr = {5, 5, 10, 100, 10, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println("Maximum sum = " + maxSumSubarrayContiguous(arr));
        System.out.println("Maximum sum = " + maxSumSubarrayNonContiguous(arr));
    }

    public static int maxSumSubarrayContiguous(int[] a) {
        int startIndex = 0, endIndex = 0;
        int max = a[0], sum = a[0];
	for (int i = 1; i < a.length; i++) {
            sum = Math.max(a[i], sum + a[i]);
            max = Math.max(max, sum);
            // Following just to get the start, end indexes for sub array
            if (max == a[i])
                startIndex = i;
            if (max == sum)
                endIndex = i;
	}
        System.out.println("subarray(" + startIndex+","+endIndex+")");
	return max;
    }    
    
    /*
     * http://n00tc0d3r.blogspot.in/2013/07/maximum-sum-of-non-contiguous.html
     * The basic idea is to calculate sum of all possible subsequences such that no 2 elements in a sequence 
     * would be adjacent in the original array and then keep tracking the maximum sum so far.
    Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110

Input : arr[] = {1, 2, 3}
Output : 4

Input : arr[] = {1, 20, 3}
Output : 20
     */
    public static int maxSumSubarrayNonContiguous2(int[] a) {
        if (a == null) {
            return 0;
        }
        int maxSum = 0, sum = 0;
        for (int i = 0; i < a.length; i++) {
            // current max excluding data[i]  
            int newSum = Math.max(sum, maxSum);
            sum = maxSum + a[i];
            maxSum = newSum;
        }

        return Math.max(sum, maxSum);
    }
    public static int maxSumSubarrayNonContiguous(int[] a) {
        if (a == null) {
            return 0;
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < a.length; i++) {
            int max = Math.max(sum1, sum2);
            //System.out.println("1 sum1=" + sum1+", sum2="+sum2 +", max="+max +", a["+i+"]="+a[i]);
            sum1 = sum2 + a[i];
            sum2 = max;
            System.out.println("sum1=" + sum1+", sum2="+sum2 +", max="+max +", a["+i+"]="+a[i]);
        }
        // Normal standard method
//        sum1 = 0; sum2 = 0;
//        for (int i = 0; i < a.length; i++) {
//            if(i%2 == 0){
//                sum1 += a[i];
//            }else{
//                sum2 += a[i];
//            }
//            System.out.println("sum1=" + sum1+", sum2="+sum2 );
//        }

        return Math.max(sum1, sum2);
    }    
}
