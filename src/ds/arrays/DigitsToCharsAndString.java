package ds.arrays;
import java.util.*;

/*
 * If a=1, b=2, c=3,....z=26. 
 * Given a string, find all possible codes that string can generate. 
 * Give a count as well as print the strings. 
 */
public class DigitsToCharsAndString {
	public static void main(String[] args) {
		int number = 254;
		List<Integer> nums = new ArrayList<Integer>();
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		map.put(1, 'a');
		map.put(2, 'b');
		map.put(3, 'c');
		map.put(4, 'd');
		map.put(5, 'e');
		map.put(6, 'f');

		while(number > 0){
			nums.add(number % 10);
			number = number / 10;
		}
		System.out.println(nums);
		Collections.reverse(nums);
		System.out.println(nums);
		
		StringBuilder sb = new StringBuilder();
		for (Integer integer : nums) {
			sb.append(map.get(integer));
		}
		System.out.println(sb.toString());
	}
}
