package ds.arrays.advanced;

import java.util.*;
import java.lang.*;
import java.io.*;
public class FindNthUglyNumber
 {
	public static void main (String[] args)
	 {
		 Scanner sc = new Scanner(System.in);
        int tests = Integer.parseInt(sc.nextLine());
        for (int k = 0; k < tests; k++) {
           int n = Integer.parseInt(sc.nextLine());
           findNthUglyNumber(n);
        }
	 }
	 public static void findNthUglyNumber(int n){
	     long[] arr = new long[n];
	     int i2 =0, i3 =0, i5 = 0;
	     long mulOf2 = 2, mulOf3 = 3, mulOf5 = 5;
	     long nextUgly = 1;
	     arr[0] = nextUgly;
	     for(int i = 1 ; i< n; i++){
	        nextUgly = Math.min(Math.min(mulOf2, mulOf3), mulOf5);
			 arr[i] = nextUgly;
			 //System.out.println(" Min of " + mulOf2 +" " + mulOf3 +" " + mulOf5);
			 //System.out.println("nextUgly "+ nextUgly+" i2:"+i2+", i3:"+i3
			 //+", i5:" + i5 +" list:"+list);
			 if(nextUgly == mulOf2){
	        	i2++;
	        	mulOf2 = arr[i2] * 2;
			}
			 if(nextUgly == mulOf3){
				 i3++;
				 mulOf3 = arr[i3] * 3;
			 }

			 if(nextUgly == mulOf5){
				 i5++;
				 mulOf5 = arr[i5] * 5;
			 }
	     }
	     System.out.println(nextUgly);
	 }
}