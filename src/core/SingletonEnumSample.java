package core;

public class SingletonEnumSample {
	public static void main(String[] args) {
		EnumSingleton.INSTANCE.doSomething();
	}
}
enum EnumSingleton {

    INSTANCE;
    
    public static void doSomething(){
        System.out.println("do something");
    }
}
