package core;

// http://javahungry.blogspot.com/2013/08/singleton-design-pattern-use-in-java.html

public class SingletonSample {

	private static volatile SingletonSample uniqueInstance;

	private SingletonSample() {
	}

	public static SingletonSample getInstance() {
		/*
		 * Double checked locking:
		 * In double checked locking  first we check if the object is created , 
		 * if not then we create one using synchronized block.
		 */
		if (uniqueInstance == null) {
			synchronized (SingletonSample.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new SingletonSample();
				}
			}
		}
		return uniqueInstance;
	}
}