package ds.strings;

import java.util.*;

/** Similar to https://leetcode.com/problems/permutations/
 * *****************************************************************************
 * Find all permutations of a given string
 * Enumerates all permutations on n elements. Two different approaches are
 included.

 % java AnagramsFinder 3 abc acb bac bca cab cba
 *
 *****************************************************************************
 */
public class AnagramsFinder {

    public List<String> permute(String s) {
        List<String> results = new ArrayList<>();

        char[] chars = s.toCharArray();

        permutations(chars, 0, results);

        return results;
    }

    private void permutations(
            char[] chars,
            int i,
            List<String> results) {

        // All positions are fixed
        if (i == chars.length) {
            results.add(new String(chars));
            return;
        }

        // Try every character at position i
        for (int j = i; j < chars.length; j++) {

            // Choose
            swap(chars, i, j);

            // Explore
            permutations(chars, i + 1, results);

            // Backtrack
            swap(chars, i, j);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

  public static void main(String[] args) {
      System.out.println((new AnagramsFinder()).permute("abc"));
    
  }
}
