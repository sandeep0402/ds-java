package ds.arrays;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintArrayPairs {
	/*
	 * in d subsets in array whose sum equal to a given number??
		example: S={1,3,5,2,7} and k=10, answer is {1,2,7},{3,5,2},{3,7}  
	 */
	
	private static int[] input = {1, 2, 3, 4, 5, 6, 7};
	private static int targetVal = 12;
	
	public static void main(String[] args) {
		subset(0,0,"");
	}
	
	private static void subset(int sum, int index, String output){
		if (sum > targetVal)
			return;
		
		if (sum == targetVal){
			System.out.println(output);
			return;
		}
		for(int i=index;i<input.length;i++)
			subset(sum+input[i],i+1, output + " " +  input[i] + " ");
	}
}
