package ds.arrays;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FindRepetitionWithoutExtraSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr = { { 8, 8, 13, 16, 17, 22, 24},
				{ 4, 5, 14, 16, 18, 23 }, { 33, 36, 37, 44, 95, 126 },
				{ 5, 7, 15, 18 } };
		Date start = new Date();
		findRepetition(arr);
		Date end = new Date();
		System.out.println("findRepetition: " + (end.getTime()-start.getTime()));
		
		start = new Date();
		findWithSet(arr);
		end = new Date();
		System.out.println("findWithSet: " + (end.getTime()-start.getTime()));
	}
	public static void findWithSet(int[][] arr){
		Set<Integer> set=new HashSet<Integer>();
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; j++) {
				if(i==0){
					set.add( arr[i][j]);
				}else{
					if(!set.add( arr[i][j]))
							System.out.println(arr[i][j]);
				}
			}
		}
	}
	public static void findRepetition(int[][] arr) {
		int index[] = new int[arr.length];
		int frontNumber[] = new int[arr.length];
		int length[] = new int[arr.length];
		for (int i = 0; i < arr.length; ++i) {
			length[i] = arr[i].length;
		}
		boolean modified = true;
		while (modified) {
			modified = false;
			for (int i = 0; i < arr.length; ++i) {				
				if (index[i] < length[i]) {
					modified = true;
					frontNumber[i] = arr[i][index[i]];
				} else {
					frontNumber[i] = Integer.MAX_VALUE;
				}
//				System.out.println("index["+i+"] < length[" + i + "] ==>>> " + index[i] + " < " + length[i] +
//						",       frontNumber["+i+"] =" +frontNumber[i]);

			}
			int min = frontNumber[0];
			int minIndex = 0;
			for (int i = 1; i < arr.length; ++i) {
				if (frontNumber[i] == min) {
					if (frontNumber[i] != Integer.MAX_VALUE)
						System.out.println(frontNumber[i]);
					index[i]++;
				} else if (frontNumber[i] < min) {
					min = frontNumber[i];
					minIndex = i;
				}
			}
			index[minIndex]++;
		}
	}
}
