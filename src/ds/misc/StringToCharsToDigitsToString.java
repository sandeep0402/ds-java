package ds.misc;

import java.util.*;
import java.util.Map.*;
/*
 * If a=1, b=2, c=3,....z=26. 
 * Given a string, break the string into chars, get the corresponding number, increment the numbers by 1, 
 * convert numbers to chars back and join them to return as a string
 */

public class StringToCharsToDigitsToString 
{
    public static void main(String[] args) 
    {
        final Map<Character, Integer> map;
        final String str = "cab";

        map = new HashMap<>();  
        // or map = new HashMap<Character, Integer> if you are using something before Java 7.
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 4);
        map.put('e', 5);
        map.put('f', 6);
        map.put('g', 7);
        map.put('h', 8);
        map.put('i', 9);
        map.put('j', 10);
        map.put('k', 11);
        map.put('l', 12);
        map.put('m', 13);
        map.put('n', 14);
        map.put('o', 15);
        map.put('p', 16);
        map.put('q', 17);
        map.put('r', 18);
        map.put('s', 19);
        map.put('t', 20);
        map.put('u', 21);
        map.put('v', 22);
        map.put('w', 23);
        map.put('x', 24);
        map.put('y', 25);
        map.put('z', 26);

        int[] array = new int[str.length()];
        for (int i=0; i<str.length(); i++){
        	array[i] = map.get(str.charAt(i));
        }
        char[] chars = new char[str.length()];
        for(int i=0; i<array.length; i++){
        	int number = array[i] + 1;
        	for(Entry entry : map.entrySet()){
        		if((Integer)entry.getValue() == number){
        			chars[i] = (char)entry.getKey();
        		}
        	}
        }
        System.out.println(new String(chars));
    }
}