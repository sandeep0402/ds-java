package ds.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// Sort Digits according to their first alphabets

public class SortDigitsWithAplhbets {
	static int[] sortArray(int[] arr) {
		int res[] = new int[arr.length];
		String words[] = new String[arr.length];
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "zero");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		for (int i = 0; i < arr.length; i++) {

			words[i] = map.get(arr[i]);
		}
		Arrays.sort(words);
		for (int i = 0; i < words.length; i++) {
			for (Integer key : map.keySet()) {
				if (words[i].equals(map.get(key))) {
					res[i] = key;
					break;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortArray(new int[] { 2, 8, 3, 4 })));

		System.out.println(Arrays.toString(sortArray(new int[] { 2, 3, 4 })));
	}
}