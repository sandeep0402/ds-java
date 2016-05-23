package ds.misc;
/*
 *  Write function power(a, b) which return a^b in O(log b) time 
 */
public class PowerAofB {
	public static void main(String[] args) {
		// Basic way with O(n)
		int a = 9;
		int b = 12;
		long result = 1;
		for (int i = 1; i <= b; i++) {
				result *= a;
		}
		System.out.println(result);

		// Efficient way with O(log b)
		System.out.println(ipow(a,b));
	}
	
	private static long ipow(int base, int exp)
	{
	    long result = 1;

	    while (exp != 0)
	    {
		    System.out.println("base " + base);
		    System.out.println("exp " + exp);
		    System.out.println("result " + result);

	    	if ((exp & 1) == 1){
	            result *= base;
	            System.out.println("sddddddddddddddddddddddddddddddddddddddddddddd");   
	    	}
	        //right shifting bytes with sign 1 position
	        //equivalent of division of 2
	        exp >>= 1;
	        base *= base;
	    }

	    return result;
	}
}
