package ds.stack;

import java.util.Stack;
/*
https://prismoskills.appspot.com/lessons/Programming_Puzzles/Reverse_a_stack_in_place.jsp
*/
public class StackReverseStack 
{
 
    static void reverseStack(Stack s) 
    {
        printStack(s, "reverse1");
        Object curr = s.pop();
        
        if (s.size() != 1)
            reverseStack (s);
        
        placeCurrAtBottomOfStack (s, curr);
        printStack(s, "place " + curr +  " AtBottom");
    }
 
    static void placeCurrAtBottomOfStack(Stack s, Object curr) 
    {
        Object top = s.pop();
        if (s.size() == 0)
            s.push(curr);
        else
            placeCurrAtBottomOfStack(s, curr);
        s.push(top);
    }
 
 
 
    // main function to test the above
    public static void main (String args[])
    {
        Stack s = new Stack ();
        s.push(1);    s.push(2);    s.push(3);
        s.push(4);    s.push(5);    s.push(6);
        
        reverseStack (s);
    }
    
    
    // function to print a stack with some message.
    static void printStack(Stack s, String msg) 
    {
        System.out.print("\n" + msg + " = ");
        for (int i=s.size()-1; i>=0; i--)
            System.out.print(s.get(i)+", ");
    }
}
