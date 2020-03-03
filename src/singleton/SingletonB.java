package singleton;

public final class SingletonB {
	private static final SingletonB instance = new SingletonB();
	private SingletonB() {}
	public static SingletonB getInstance() {
		return instance;
	}
	public static void main(String[] args) {
		SingletonB s0 = SingletonB.getInstance();
		SingletonB s1 = SingletonB.getInstance();
		int x=0;
		System.out.println(x);
	}
}
