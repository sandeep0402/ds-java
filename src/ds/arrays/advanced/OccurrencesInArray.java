/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.arrays.advanced;

/**
 * Given a sorted array and a number write a method that returns the number of occurences of given number
    
    Method 1 (Linear Search)
        Linearly search for x, count the occurrences of x and return the count.     Time Complexity: O(n)

    Method 2 (Use Binary Search)
    1) Use Binary search to get index of the first occurrence of x in arr[]. Let the index of the first occurrence be i.
    2) Use Binary search to get index of the last occurrence of x in arr[]. Let the index of the last occurrence be j.
    3) Return (j – i + 1); 

 * http://algorithms.tutorialhorizon.com/find-the-number-of-occurrences-of-a-number-in-a-given-sorted-array/
 */
public class OccurrencesInArray {

    public int findOccurrences(int[] arr, int num) {
        int count = 0;
        int firstOccurence = findFirstOccurrence(arr, num, 0, arr.length - 1);
        if (firstOccurence < 0) {
            return -1;
        }
        int lastOccurence = findLastOccurrence(arr, num, 0, arr.length - 1);
        count = lastOccurence - firstOccurence + 1;
        return count;
    }

    public int findFirstOccurrence(int[] arr, int num, int start, int end) {
        if (start <= end ) {
            int mid = (start + end) / 2;
            if (arr[mid] == num && (mid == 0 || (arr[mid - 1] < num))) {
                return mid;
            } else if (num > arr[mid]) {
                return findFirstOccurrence(arr, num, mid + 1, end);
            } else {
                return findFirstOccurrence(arr, num, start, mid - 1);

            }
        } else {
            return -1;
        }
    }

    public int findLastOccurrence(int[] arr, int num, int start, int end) {
        if (start <= end ) {
            int mid = (start + end) / 2;
            if (arr[mid] == num && (mid == arr.length - 1 || arr[mid + 1] > num)) {
                return mid;
            } else if (num >= arr[mid]) {
                return findLastOccurrence(arr, num, mid + 1, end);
            } else {
                return findLastOccurrence(arr, num, start, mid - 1);
            }
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {
        int[] arrA = {1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5, 5, 6,7 ,9, 12,45};
        int x = 2;
        OccurrencesInArray i = new OccurrencesInArray();
        int r = i.findOccurrences(arrA, x);
        System.out.println("No of Occurrences of number " + x + " is : " + r);
    }
}
