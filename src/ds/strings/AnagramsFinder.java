package ds.strings;

/**
 * *****************************************************************************
 * Find all permutations of a given string
 * Enumerates all permutations on n elements. Two different approaches are
 included.

 % java AnagramsFinder 3 abc acb bac bca cab cba
 *
 *****************************************************************************
 */
public class AnagramsFinder {

    // print n! permutation of the characters of the string s (in order)
    public static void perm1(String s) {
        perm1("", s);
    }

    private static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
            }
        }

    }

    // print n! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
        int n = s.length();
        char[] a = new char[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i);
        }
        perm2(a, n);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            System.out.println(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            perm2(a, n - 1);
            swap(a, i, n - 1);
        }
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
        System.out.println("swapped = "+new String(a));
    }

    public static void getPossibleAnalogCount(String elements){
        int n = elements.length();
        /*
            count = !n / !(n-r)
                n - Total number of chars
                r- Number of chars used iin permutation out of n
                if r and n are equal than !0 gives 1
        */
        int count = factorial(n); //ignoring !n-n as its 1 as above comments
        System.out.println("Possible Analog count = "+count);
    }
    public static int factorial(int n)
    {
        if( n== 0 || n ==1){
            return 1;
        }
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
    public static void main(String[] args) {
        String elements = "abc";
        //getPossibleAnalogCount(elements);
       // perm1(elements);
        System.out.println();
        perm2(elements);
    }
}
