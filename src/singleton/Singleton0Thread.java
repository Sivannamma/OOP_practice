package singleton;

// The simple singleton
public final class Singleton0Thread {
	private static Singleton0Thread _instance = null;
	int x = 0;

	private Singleton0Thread() {
		x++;
	}

	public int getX() {
		return x;
	}

	public static synchronized Singleton0Thread getInstance() {
		if (_instance == null)
			_instance = new Singleton0Thread();
		return _instance;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				Singleton0Thread s0 = Singleton0Thread.getInstance();
				System.out.println(s0.getX());
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				Singleton0Thread s1 = Singleton0Thread.getInstance();
				System.out.println(s1.getX());
			}
		};
		Thread t3 = new Thread() {
			public void run() {
				Singleton0Thread s1 = Singleton0Thread.getInstance();
				System.out.println(s1.getX());
			}
		};
		t1.start();
		t2.start();
		t3.start();
	}
}
