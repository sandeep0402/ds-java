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
public class SelectionSort {

    public static void main(String args[]) {
        //testing our bubble sort method in Java
        int[] arr = {32, 39, 21, 45, 23, 3};
        System.out.println("unsorted array before sorting : " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("sorted array After sorting : " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // keep looking for small idex till end (don't swap elements till element. MinIndex may be updated number of times
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

}
