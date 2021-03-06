package ds.misc;

import java.util.Arrays;

public class ReverseWordsInSentence
{
 public static void main(String[] args)
 {
  String str = "reverse words of a sentence";
  String result = reverseLatest(str);
  System.out.println(result);
 }

 private static String reverseLatest(String str){
	 String strNew = "";
	 String[] strArray = str.split(" ");
	 int  i =0, j = strArray.length -1;
	 while( i < j){
		 String temp = strArray[i];
		 strArray[i] = strArray[j];
		 strArray[j] =  temp;
		 j--;
		 i++;
	 }
	 for (int j2 = 0; j2 < strArray.length; j2++) {
		 strNew += " " + strArray[j2];
	}
	 return strNew;
 }
 private static String reverseWordsNew(String str)
 {
	 String strNew = "";
	 String[] strArray = str.split(" ");
	 for (int i =  strArray.length -1 ;i>=0 ;i--) {
		 strNew += strArray[i] +" ";
	}
	 return strNew;
 }
 private static String reverseWords(String str)
 {
  char[] chars = str.toCharArray();
  reverse(chars, 0, chars.length - 1);
  int wordStart = 0;
  int wordEnd = 0;
  while (wordEnd < chars.length)
  {
   if (chars[wordEnd] == ' ')
   {
    reverse(chars, wordStart, wordEnd - 1);
    wordStart = wordEnd + 1;
   }
   wordEnd++;
  }
  reverse(chars, wordStart, wordEnd - 1);
  return new String(chars);
 }

 private static void reverse(char[] chars, int i, int j)
 {
  while (i < j)
  {
   char temp = chars[i];
   chars[i] = chars[j];
   chars[j] = temp;
   i++;
   j--;
  }
 }
}