package singleton;
//Double Checked Locking & volatile
public final class SingletonV {
	private static volatile SingletonV _instance; //volatile variable 
	public static SingletonV getInstance(){
		if(_instance == null){
			synchronized(SingletonV.class){
				if(_instance == null)
					_instance = new SingletonV();
			}
		}
		return _instance;
	}

}
