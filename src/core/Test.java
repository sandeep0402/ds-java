package core;

public class Test {
    public static void main(String[] args) {
    	System.out.println(Double.MIN_VALUE);
    	System.out.println(0.0d);
    	System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
    	System.out.println("1.0 / 0.0 = " + 1.0 / 0.0 );
    	double a = 1.0 / 0.0;
    	System.out.println(a + " " + (a+1) + " " + a*0 + " " + 0/a);
    	System.out.println("1 / 0 = " + 1 / 0);

    }
}


//Read more: http://java67.blogspot.com/2012/09/top-10-tricky-java-interview-questions-answers.html#ixzz4B5w8j5Xa