package ds.arrays;

import java.util.Arrays;

/*
 * Rotate an array k times to its left.
 * Solution: Reverse the array's n-k elements and then last k elements. Reverse the whole array.
 */
public class RotateKTimes
{
 public static void main(String[] args)
 {
  int[] array =  { 1, 2, 3, 4, 5, 6, 7 };
  int rotation = 3;
  System.out.println("rotation requested = "+ rotation);
  rotation =  rotation % array.length;
  System.out.println("actual rotation required = " +rotation);
  System.out.println(Arrays.toString(array));
  rotateLeftKTimes(array, rotation);
  System.out.println(Arrays.toString(array));
 }

 private static void rotateLeftKTimes(int[] array, int k)
 {
  int n = array.length;
  // Reverse the first `n-k` elements
  reverse(array, 0, n-k-1 );
  System.out.println(Arrays.toString(array));
  // Reverse the last `k` elements
  reverse(array, n - k, n-1);
  System.out.println(Arrays.toString(array));
  // Reverse the whole array
  reverse(array, 0, n-1);
 }

 private static void reverse(int[] array, int i, int j)
 {
  while (i < j)
  {
   int temp = array[i];
   array[i] = array[j];
   array[j] = temp;
   i++;
   j--;
  }
 }

}
