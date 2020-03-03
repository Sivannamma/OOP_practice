package singleton;
//lazy initialization (On Demand Holder idiom)
public final class SingletonLazy {
	private SingletonLazy() {}

	private static class Holder {
		private static final SingletonLazy _instance = new SingletonLazy();
	}

	public static SingletonLazy getInstance() {
		return Holder._instance;
	}

	public static void main(String[] args) {

	}

}
