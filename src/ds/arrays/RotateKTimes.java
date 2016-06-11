package ds.arrays;

import java.util.Arrays;

/*
 * Rotate an array k times to its left.
 * Solution: Reverse the whole array, Then reverse the part 0 to n-k and n-k+1 to n.
 */
public class RotateKTimes
{
 public static void main(String[] args)
 {
  int[] array =  { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
  int rotation = 7;   
  System.out.println("rotation requested = "+ rotation);
  rotation =  rotation % array.length;
  System.out.println("actual rotation required = " +rotation);
  System.out.println(Arrays.toString(array));
  rotateLeftKTimes(array, rotation);
  System.out.println(Arrays.toString(array));
 }

 private static void rotateLeftKTimes(int[] array, int k)
 {
  reverse(array, 0, array.length - 1);
  reverse(array, 0, array.length - k - 1);
  reverse(array, array.length - k, array.length - 1);
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