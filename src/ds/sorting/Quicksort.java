/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.sorting;

import java.util.Arrays;

/*
 * http://www.programcreek.com/2012/11/quicksort-array-in-java/
 * http://me.dt.in.th/page/Quicksort/
 * http://www.sanfoundry.com/java-program-quick-sort-algorithm/
 */

public class Quicksort {

    public static void main(String[] args) {
        int[] x = {9, 2, 4, 8, 3, 7, 10}; //{9, 2, 4, 7, 3, 7, 10};
        System.out.println(Arrays.toString(x));
        
        quickSort(x, 0, x.length - 1);
        
        System.out.println(Arrays.toString(x));
    }

    /** Quick sort function **/    
    public static void quickSort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (start >= end) {
            return;
        }

        // pick the pivot
        int middle = (start + end) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = start, j = end;
        /** partition **/
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }
            System.out.println("while (i <= j) Start="+start+", end="+end+", i="+i+", j="+j+", pivot="+pivot+", left="+arr[i]+", right="+arr[j]);
            /** swap **/    
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            System.out.println("Before recursively start"+Arrays.toString(arr));
        }
        System.out.println("Before recursively start"+Arrays.toString(arr));
        /**  partition completes here   
         **  j is equal to  i-1
         **  So now sort from start to j or start to i-1
         **  and i to end or j_+1 to end
         **/        
        /** recursively sort lower half **/
        if (start < j) {
            System.out.println("if (start < j) Start="+start+", end="+end+", i="+i+", j="+j+", pivot="+pivot);
            quickSort(arr, start, j);
        }
        /** recursively sort upper half **/
        if (end > i) {
            System.out.println("if (end > i) Start="+start+", end="+end+", i="+i+", j="+j+", pivot="+pivot);
            quickSort(arr, i, end);
        }
    }
}
