package ds.misc;
public class StringMatcherInSeq {

	public static boolean matchStringPattern(String string, String word) {
		int stringLength = string.length();
		char[] array = word.toCharArray();
		int currentArrayInd = 0;
		for (int i = 0; i < stringLength; i++) {
			char character = string.charAt(i);
                        System.out.println("currentArrayInd="+currentArrayInd+", Comparing , character="+character+" with array[currentArrayInd]="+array[currentArrayInd]);
			if (character == array[currentArrayInd]) {
                            currentArrayInd++;
                            //System.out.println((currentArrayInd-1) +" ,array[currentArrayInd]="+array[currentArrayInd-1]);
                            if (currentArrayInd >= array.length) {
                                    return Boolean.TRUE;
                            }
                        }
                        // Remove this else block in case of distributed string seach but in same sequence of letters
                        else{
                            // Reset the counter if modified and compare current element again
                            if(currentArrayInd > 0){
                                currentArrayInd = 0;
                                i--;
                            }
                        }
		}
		return Boolean.FALSE;
	}

	public static void main(String[] args) {
            String string1 = "ababzc";
            String pattern = "abc";
            boolean r = matchStringPattern(string1, pattern);
            System.out.println(r);
	}
}
