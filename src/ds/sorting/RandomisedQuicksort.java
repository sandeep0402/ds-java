/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.sorting;

import java.util.Arrays;

/*
 * There are N bolts each of which different size and N nuts, they are also with different sizes. and each bolt fits with exactly 1 nut.
 * Two ways to solve
    1. Brute force Way: Start with the first bolt and compare it with each nut until we find a match. In the worst case we require n comparisons. Doing this for all bolts gives us O(n^2) complexity.
    2. Randomised Quick Sort Way: We can use quick sort technique to solve this.  here compare function will be comparing NUT with Bolt.
            Now, say first time, when you choose a bolt and try to match its nut with each of available nuts. Here, if choosen nut is smaller to fit the bolt, put it in left side else put it in right side. Finally, in first pass, you will have a matching nut-bolt and some nuts on left(smaller than matching nut) and some nuts on right(bigger than matching nut). 
            So, for second bolt, try the bolt with previous matched nut, if it is smaller, then you need to search only right side collected nuts. And if it is bigger in size, then you need to search only left side collected nuts. 
            This way.. You will have a search to logN steps. First pass took N. 
            So, O(NlogN)
 */

public class RandomisedQuicksort {

    public static void main(String[] args) {
        int[] nuts  = {9, 2, 4, 8, 3, 7, 10}; //{9, 2, 4, 7, 3, 7, 10};
        int[] bolts = {3, 10, 2, 7, 9, 4, 8};
        System.out.println("Nuts: "+ Arrays.toString(nuts));
        System.out.println("Bolts:"+Arrays.toString(bolts));
        matchNutsAndBolts(nuts,bolts);
        System.out.println("Nuts: "+ Arrays.toString(nuts));
        System.out.println("Bolts:"+Arrays.toString(bolts));
    }

    public static void matchNutsAndBolts(int nuts[], int bolts[]) {
        if (nuts == null || bolts == null || nuts.length != bolts.length) {
            return;
        }
        if(nuts.length == 1) return; // nothing to do
        matchNutsAndBolts(nuts, bolts, 0, nuts.length - 1);
    }

    private static void matchNutsAndBolts(int nuts[], int bolts[], final int start, final int end) {
        if (start < end) {
            int pivatIndex = (start +end)/2;
            int newPivatIndex = partition(nuts, start, end, nuts[pivatIndex]);
            partition(bolts, start, end, nuts[newPivatIndex]);
            System.out.println("pivatIndex:"+ pivatIndex +", newPivatIndex:"+newPivatIndex+",nuts:"
                    +Arrays.toString(nuts)+",bolts:"+Arrays.toString(bolts));
            matchNutsAndBolts(nuts, bolts, start, newPivatIndex - 1);
            matchNutsAndBolts(nuts, bolts, newPivatIndex + 1, end);
        }
    }

    // save one iteration to find the pivatIndex
    private static int partition(int arr[], final int start, final int end, final int pivatValue) {
        int lastIndex = start;
        for(int i = start; i < end; i++) {
            if (arr[i] < pivatValue) {
                swap(arr, i, lastIndex);
                lastIndex += 1;
            } else if (arr[i] == pivatValue) {
                swap(arr, i, end);
                i--; // Go back to compare the original last elements.
            }
        }
        swap(arr, end, lastIndex);
        return lastIndex;
    }

    private static void swap(int arr[], final int i, final int j) {
        if(arr[i] == arr[j]) return; // do nothing
      
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
