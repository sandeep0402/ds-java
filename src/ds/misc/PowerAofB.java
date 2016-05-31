package ds.misc;

import java.util.Date;

/*
 *  Write function power(a, b) which return a^b in O(log b) time 
 */
public class PowerAofB {
	public static void main(String[] args) {
		// Basic way with O(n)
		int a = 4;
		int b = 102;
		System.out.println(normalapproach(a, b));

		// Efficient way with O(log b)
		System.out.println(ipow(a,b));
	}

	private static long normalapproach(int a, int b) {
		long result = 1;
		long start = System.nanoTime();
		for (int i = 1; i <= b; i++) {
				result *= a;
		}
		long end = System.nanoTime();
		System.out.println("Basic Way - iteration count = " + b +", Execution time = "+ (end - start));
		return result;
	}
	
	private static long ipow(int base, int exp)
	{
	    long result = 1;
	    int count = 1;
		long start = System.nanoTime();
	    while (exp != 0)
	    {
//		    System.out.println("base " + base);
//		    System.out.println("exp " + exp);
//		    System.out.println("result " + result);

	    	if ((exp & 1) == 1){
	            result *= base;
	           // System.out.println("sddddddddddddddddddddddddddddddddddddddddddddd");   
	    	}
	        //right shifting bytes with sign 1 position
	        //equivalent of division of 2
	        exp >>= 1;
	        base *= base;
	        count++;
	    }
		long end = System.nanoTime();
		System.out.println("Bitwise Way - iteration count = " + count +", Execution time = "+ (end - start));

	    return result;
	}
}
