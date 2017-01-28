/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.misc;

/**
 *
 * @author sandeep
 */
public class NumbersWithUniqueDigits {
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } 
        int ret = 10, count = 9;
        for (int i = 2; i <= n; i++) {
            count *= 11-i;
            ret += count;
        }
        return ret;
    }

    public static void main(String[] args) {
        int count = countNumbersWithUniqueDigits(8);
        System.out.println("Numbers with Unique digits : " + count);
    }    
}
