package ds.arrays.advanced;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
Input:
1
5
@ % $ # ^
% @ # $ ^

Its Correct output is:
# $ % @ ^
# $ % @ ^
 */
class NutsAndBoltsProblem
 {
	public static void main (String[] args)
	 {
		 Scanner sc = new Scanner(System.in);
	     int tests = Integer.parseInt(sc.nextLine());
		 System.out.println("Total tests: "+tests);
		 for(int m = 0; m < tests; m++){
	         int size = Integer.parseInt(sc.nextLine());

	         char[] nuts = sc.nextLine().trim()
	            .replaceAll("\\s+","").toCharArray();
			 //System.out.println("nuts: "+Arrays.toString(nuts) + " size:"+nuts.length);

	         char[] bolts = sc.nextLine().trim()
	            .replaceAll("\\s+","").toCharArray();
			 //System.out.println("bolts: "+Arrays.toString(bolts) + " size:"+bolts.length);

			 //System.out.println("matchPairs ");
	         matchPairs(nuts, bolts, 0, size-1);
			 //System.out.println("matchPairs Done");

			 printArray(nuts);
			 //System.out.println();
			 printArray(bolts);
	     }
	 }
	 public static void matchPairs(char[] nuts,char[] bolts,int low,int high){
	     if(low < high){
			 //System.out.println("matchPairs find pivot loc");
	         int pivotLoc = partition(nuts, low, high, bolts[high]);
			 //System.out.println("matchPairs found pivot loc: "+ pivotLoc);
	         partition(bolts, low, high, nuts[pivotLoc]);
			 //System.out.println("matchPairs left right");
	         matchPairs(nuts, bolts, low, pivotLoc-1);
	         matchPairs(nuts, bolts, pivotLoc+1, high);
	     }
	 }
	 public static int partition(char[] arr,int low,int high, char pivot){
	     int i = low;
	     char temp;
		 //System.out.println("start loop from "+ low + " to "+ high);
	     for(int j = low; j< high; j++){
			 //System.out.println("compare " + arr[j] + " with " + pivot + " i:" + i);
			 if(arr[j] < pivot){
	             temp = arr[i];
	             arr[i] = arr[j];
	             arr[j] = temp;
	             i++;
	         }
	         else if(arr[j] == pivot){
	             temp = arr[high];
	             arr[high] = arr[j];
	             arr[j]= temp;
	             j--;
	         }
			 //System.out.println("in loop "+ j);
		 }
	     temp = arr[high];
	     arr[high] = arr[i];
	     arr[i] = temp;
	     return i;
	 }
	  private static void printArray(char[] arr) {
		  StringBuilder sb = new StringBuilder();
		  for (char ch : arr){
             sb.append(ch);
             sb.append(" ");
        }
		  System.out.println(sb.toString().trim());
	  }
}