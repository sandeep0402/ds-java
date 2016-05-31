package ds.arrays;

import java.util.Arrays;

public class DeepEquals {
	public static void main(String[] args) {
		String[] string1 = new String[]{"first","second"};
		String[] string2 = new String[]{"first","second"};
		
		Integer[] num1 = new Integer[]{1};
		Integer[] num2 = new Integer[]{2};
		
		Object[] object1 = new Object[]{"first", "second", new String[]{"third"}};
		Object[] object2 = new Object[]{"first", "second", new String[]{"third"}};
		
		/* Same Behavior when there are no nested array type child elements */
		System.out.println("Compare string1 and string2 Using HashCode and Equals: " + Arrays.equals(string1, string2));
		System.out.println("Compare string1 and string2 Using DeepHashCode and DeepEquals: " + Arrays.deepEquals(string1, string2));
		
		// Marking two arrays as null
		num1 = null;
		num2 = null;
		/* Same Behavior when arrays are null */
		System.out.println("Compare (null arrays) num1 and num2 Using HashCode and Equals: " + Arrays.equals(num1, num2));
		System.out.println("Compare (null arrays) num1 and num2 Using DeepHashCode and DeepEquals: " + Arrays.deepEquals(num1, num2));

		/* With nested objects, Behavior is totally different  */
		System.out.println("Compare object1 and object2 Using HashCode and Equals: " + Arrays.equals(object1, object2));
		System.out.println("Compare object1 and object2 Using DeepHashCode and DeepEquals: " + Arrays.deepEquals(object1, object2));
						
	}
}
