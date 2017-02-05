package ds.strings;

import java.util.HashMap;

/*
Palindrome Partitioning– Spilt a string into minimum number of substring such that each substring is a pallindrome.
http://algorithms.tutorialhorizon.com/dynamic-programming-split-the-string-into-minimum-number-of-palindromes/

Dynamic programming is when you use past knowledge to make solving a future problem easier.

A good example is solving the fibonacci sequence for n=1,000,002.

This will be a very long process, but what if I give you the results for n=1,000,000 and n=1,000,0001? Suddenly the problem just became more manageable.

Dynamic programming is used a lot in string problems, such as the string edit problem. You solve a subset(s) of the problem and then use that information to solve the more difficult original problem.

With dynamic programming, you store your results in some sort of table generally. When you need the answer to a problem, you reference the table and see if you already know what it is. If not, you use the data in your table to give yourself a stepping stone towards the answer.
*/
public class PalindromePartitioningInMinCuts {

    static HashMap<String, Integer> map = new HashMap<String, Integer>();

    public int splitViaRecursion(String x) {
        if (x == "" || isPalindrome(x)) {
            return 0;
        } else {
            int maxCuts = Integer.MAX_VALUE;
            for (int i = 1; i < x.length(); i++) {
                int leftCuts = splitViaRecursion(x.substring(0, i)); // divide string start to i
                int rightCuts = splitViaRecursion(x.substring(i, x.length())); // divide string i to end
                int cuts = 1 + leftCuts +rightCuts;
                maxCuts = Math.min(cuts, maxCuts);
            }
            return maxCuts;
        }
    }

    
    public int splitViaDynamicProgramming(String x) {
        if (x == "" || isPalindrome(x)) {
            return 0;
        } else {
            int cuts = Integer.MAX_VALUE;
            for (int i = 1; i < x.length(); i++) {
                int leftCuts = 0;
                int rightCuts = 0;
                String leftStr = x.substring(0, i);
                String rightStr = x.substring(i, x.length());
                if(! map.containsKey(leftStr)) {
                    map.put(leftStr, splitViaDynamicProgramming(leftStr));
                }
                leftCuts = map.get(leftStr);
                if(! map.containsKey(rightStr)) {
                    map.put(rightStr, splitViaDynamicProgramming(rightStr));
                }
                rightCuts = map.get(rightStr);
                cuts = Math.min(1 + leftCuts + rightCuts, cuts);
            }
            return cuts;
        }
    }
    
    public boolean isPalindrome(String text) {
        /*
         * stringBuffer has reverse method, string don't have
         * Otherwise convert string to char array and loop ffrom end to 0 and form a reverse string;
        */
        StringBuffer stringBuffer = new StringBuffer(text);
        return stringBuffer.reverse().toString().equals(text);
    }

    public static void main(String[] args) {
        String a = "cdcdddcdadcdcdcd";
        System.out.println("String is: " + a);
        PalindromePartitioningInMinCuts s = new PalindromePartitioningInMinCuts();
        long startTime = System.currentTimeMillis();
        System.out.println("Recursion- Cuts Required: " + s.splitViaRecursion(a));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Recursion- Time Taken(ms): " + elapsedTime);
        startTime = System.currentTimeMillis();
        System.out.println("Dynamic Programming- Cuts Required: " + s.splitViaDynamicProgramming(a));
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("Dynamic Programming- Time Taken(ms): " + elapsedTime);

    }

}
