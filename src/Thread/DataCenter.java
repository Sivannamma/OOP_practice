package Thread;

public class DataCenter {
	public static final int CAPACITY = 500;
	private String[] msg = new String[CAPACITY];
	private int count = 0;

	public String getMsg() {
		count--;
		return msg[count];
	}

	public void setMsg(String msg) {
		this.msg[count] = msg;
		count++;
	}

	public int getCount() {
		return count;
	}
}
