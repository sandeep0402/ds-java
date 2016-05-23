package ds.arrays;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchMinSumPair {
	/*
	 * Complete the function below.
	 */

	static int[] searchMinSumPair(int[] inputArray) {
		Integer sum = null;
		Integer loc1 = null;
		Integer loc2 = null;
		int[] array = new int[2];
		for (int i = 0; i < inputArray.length - 1; i++) {
			for (int j = 0; j < inputArray.length; j++) {
				if (i!=j && (sum== null ||inputArray[i] + inputArray[j] < sum)) {
					sum = inputArray[i] + inputArray[j];
					loc1 = i;
					loc2 = j;
				}
			}
		}
		if (loc1 != null && loc2 != null) {
			if (inputArray[loc1] < inputArray[loc2]) {
				array[0] = inputArray[loc1];
				array[1] = inputArray[loc2];
			} else {
				array[1] = inputArray[loc1];
				array[0] = inputArray[loc2];
			}
		}
		return array;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int[] res;

		// int _inputArray_size = Integer.parseInt(in.nextLine());
		int[] _inputArray = new int[] { 3, -1, 4, 6, -2 };
		// int _inputArray_item;
		// for(int _inputArray_i = 0; _inputArray_i < _inputArray_size;
		// _inputArray_i++) {
		// _inputArray_item = Integer.parseInt(in.nextLine());
		// _inputArray[_inputArray_i] = _inputArray_item;
		// }
		//
		// res = searchMinSumPair(_inputArray);
		// for(int res_i=0; res_i < res.length; res_i++) {
		// bw.write(String.valueOf(res[res_i]));
		// bw.newLine();
		// }
		//
		// bw.close();
		res = searchMinSumPair(_inputArray);
		for (int res_i = 0; res_i < res.length; res_i++) {
			System.out.println(res[res_i]);
		}

	}

	

}
