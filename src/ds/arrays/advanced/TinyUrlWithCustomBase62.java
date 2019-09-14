package ds.arrays.advanced;

import java.util. * ;
import java.lang. * ;
import java.io. * ;

/*
Design a system that takes big URLs like “http://www.geeksforgeeks.org/count-sum-of-digits-in-numbers-from-1-to-n/” and converts them into a short 6 character URL. It is given that URLs are stored in database and every URL has an associated integer id.  So your program should take an integer id and generate a 6 character long URL.

A URL character can be one of the following

A lower case alphabet [‘a’ to ‘z’], total 26 characters
An upper case alphabet [‘A’ to ‘Z’], total 26 characters
A digit [‘0′ to ‘9’], total 10 characters
There are total 26 + 26 + 10 = 62 possible characters.

So the task is to convert an integer (database id) to a base 62 number where digits of 62 base are "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

Input:
The first line of input contains an integer T denoting the number of test cases. The second line consists of a long integer.

Output:
For each testcase, in a new line, print the shortened string in the first line and convert the shortened string back to ID (to make sure that your conversion works fine) and print that in the second line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 232-1

Example:
Input:
1
12345

Output:
dnh
12345
 */
public class TinyUrlWithCustomBase62 {
	public static void main(String[] args){
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Scanner sc = new Scanner(System. in );
		int tests = Integer.parseInt(sc.nextLine());
		for (int k = 0; k < tests; k++) {
			int num1 = Integer.parseInt(sc.nextLine());
			String num2 = convertToBase62(num1, chars);
			System.out.println(num2);
			int num3 = convertFromBase62(num2, chars);
			System.out.println(num3);
		}
	}

	public static String convertToBase62(int num, String chars){
		int base = 62;
		String str = "";
		while(num >= base){
			int n = num%base;
			str = chars.charAt(n)+ str;
			num = num/base;
		}
		str = chars.charAt(num)+ str;
		return str;
	}

	public static int convertFromBase62(String num, String chars){
		int base = 62;
		int n = 0;
		char[] arr = num.toCharArray();
		//System.out.println(Arrays.toString(arr));
		for(int i = arr.length-1; i >=0 ; i--){
			//System.out.println("Finding " + (arr[i]) + " in " + chars );
			int index = chars.indexOf(arr[i]);
			int nn = index * ((int) Math.pow(base, arr.length-(i+1)));
			n += nn;
			//System.out.println("n=" + n +" nn="+nn + " index ="+ index);
		}
		return n;
	}
}