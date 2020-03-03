package singleton;

// The simple singleton
public final class Singleton0 {
	private static Singleton0 _instance = null;

	private Singleton0() {
	}

	public static synchronized Singleton0 getInstance() {
		if (_instance == null)
			_instance = new Singleton0();
		return _instance;
	}

}
