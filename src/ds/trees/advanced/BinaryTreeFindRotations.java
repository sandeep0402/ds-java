/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.trees.advanced;

import java.util.Arrays;
import java.util.Collections;

/**
 * Binary search to find the rotation point in a rotated sorted tree
   Or Find how many times a BST has been rotated
   Or Given a sorted array which has been rotated n number of times. Find the value of n. It is similar to below post where you need to find only the pivot element. 
 * If you have the Index of pivot element, you can get the number of times the array is rotated.
 * http://stackoverflow.com/questions/2796413/binary-search-to-find-the-rotation-point-in-a-rotated-sorted-list 
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * Index of first element in sorted BST = number of rotations
 */
public class BinaryTreeFindRotations {
    static int findMinimum(Integer[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (arr[low] > arr[high]) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        // must be in sorted order, allowing rotation, and contain no duplicates

        for (int i = 0; i < arr.length; i++) {
            int minIndex = findMinimum(arr);
            System.out.println(Arrays.toString(arr)+" Min is " + arr[minIndex] + " at " + minIndex+", so Rotations = " + minIndex);
            Collections.rotate(Arrays.asList(arr), 1);
        }
    }
}