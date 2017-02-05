/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * http://www.topjavatutorial.com/java/java-programs/radix-sort-in-java/
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] num = {170, 45, 75, 90, 802, 2, 24, 66, 23, 234, 3, 232, 44};
        System.out.println(Arrays.toString(num));
        radixsort(num);
        System.out.println(Arrays.toString(num));
    }

    public static void radixsort(int[] input) {
        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // sort
        boolean flag = false;
        int divisor = 1;
        while (!flag) {
            flag = true;
            // split input between lists
            for (Integer num : input) {
                int tmp = num / divisor;
                buckets[tmp % 10].add(num);
                if (flag && tmp > 0) {
                    flag = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (List<Integer> bucket : buckets) {
                if(! bucket.isEmpty()){
                    //System.out.println(bucket);
                    for (Integer i : bucket) {
                        input[a++] = i;
                    }
                    bucket.clear();
                }
            }
            System.out.println(Arrays.toString(input));
            // move to next digit
            divisor *= 10;
        }
    }

}
