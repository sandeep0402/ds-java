package ds.misc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DistictSubstrings_usingHashTable {
	
	public static void findAllUniqueStrings(String string){
		int stringLength = string.length();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < stringLength; ++i) {
			for (int j = 0; j < (stringLength - i); ++j) {
				String str = string.substring(i, i + j + 1);
				if (!list.contains(str)) {
					list.add(str);
				}
			}
		}
		System.out.println( list);
	}
	
	public static void main(String args[]) {
		findAllUniqueStrings("abcde");
	}
}