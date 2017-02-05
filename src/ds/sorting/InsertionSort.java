/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.sorting;

import java.util.Arrays;

/**
 *
 * @author sandeep
 */
public class InsertionSort {

    public static void main(String args[]) {
        //testing our bubble sort method in Java
        int[] arr = {32, 39, 21, 45, 23, 3};
        System.out.println("unsorted array before sorting : " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("sorted array After sorting : " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while (array[j - 1] > current && j > 0) {
                array[j] = array[j - 1]; // shifting element
                j--;
            } // compareIndex now denotes proper place for number to be sorted 
            array[j] = current;
        }
    }

    /* 
     * Method to Sort String array using insertion sort in Java. * This can also sort any object array which implements 
     * Comparable interface. 
     */
    public static void insertionSort(Comparable[] objArray) { // insertion sort starts from second element 
        for (int i = 1; i < objArray.length; i++) {
            Comparable objectToSort = objArray[i];
            int j = i;
            while (j > 0 && objArray[j - 1].compareTo(objectToSort) > 1) {
                objArray[j] = objArray[j - 1];
                j--;
            }
            objArray[j] = objectToSort;
        }
    }

}
