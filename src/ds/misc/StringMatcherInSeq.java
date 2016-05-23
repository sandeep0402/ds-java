package ds.misc;
public class StringMatcherInSeq {

	public static boolean matchStringPattern(String string, String word) {
		int stringLength = string.length();
		char[] array = word.toCharArray();
		int currentArrayInd = 0;
		for (int i = 0; i < stringLength; i++) {
			char character = string.charAt(i);
			if (character == array[currentArrayInd]) {
				currentArrayInd++;
				if (currentArrayInd >= array.length) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}

	public static void main(String[] args) {

		String string1 = "nagarro01";
		String pattern = "nagarro";
		boolean r = matchStringPattern(string1, pattern);
		System.out.println(r);
	}
}
