package ds.sorting;

import java.util.Arrays;

/**
 * Java program to sort integer array using bubble sort sorting algorithm.
 * bubble sort is one of the simplest sorting algorithm but performance
 * of bubble sort is not good, its average and worst case performance
 * ranges in O(n2) and that's why it is not used to sort large set of
 * unsorted data. Bubble sort can be used for educational and testing
 * purpose to sort small number of data to avoid performance penalty. 
 * This program is also a good example of how to print contents of Array in Java
 *
 * http://www.java67.com/2012/12/bubble-sort-in-java-program-to-sort-integer-array-example.html
 * @author http://java67.blogspot.com
 */
public class BubbleSort {
  
  
    public static void main(String args[]) {
        //testing our bubble sort method in Java
        int[] arr = {32, 39,21, 45, 23, 3};
        System.out.println("unsorted array before sorting : " + Arrays.toString(arr));        
        bubbleSort(arr);      
    }   
  
    /*
     * In bubble sort we need n-1 iteration to sort n elements
     * at end of first iteration larget number is sorted and subsequently numbers smaller
     * than that.
     */
    public static void bubbleSort(int[] arr){
        for(int i= arr.length-1; i>=0 ; i--){
            //Inner loop to perform comparision and swapping between adjacent numbers
            //After each iteration one index from last is sorted
            for(int j= 1; j<= i; j++){
              
                //If current number is greater than swap those two
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.printf("unsorted array after %d pass %s: %n", i+1, Arrays.toString(arr));
        }
    }

    /*
     * In bubble sort, we basically traverse the array from first
     * to array_length - 1 position and compare the element with the next one.
     * Element is swapped with the next element if the next element is greater.
     *
     * Bubble sort steps are as follows.
     *
     * 1. Compare array[0] & array[1]
     * 2. If array[0] > array [1] swap it.
     * 3. Compare array[1] & array[2]
     * 4. If array[1] > array[2] swap it.
     * ...
     * 5. Compare array[n-1] & array[n]
     * 6. if [n-1] > array[n] then swap it.
     *
     * After this step we will have largest element at the last index.
     *
     * Repeat the same steps for array[1] to array[n-1]
     *  
     */

}