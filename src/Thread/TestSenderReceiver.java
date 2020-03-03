package Thread;

class MessageBox {
	int contents;
	boolean avialable = false;

	public int get() {
//wait until the sender puts some messages
		while (avialable == false) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
		avialable = false;// before return message, rest the flag
		return contents;
	}

	public void put(int val) {
		contents = val;
		avialable = true;
	}
}

class Sender extends Thread {
	private MessageBox messBox;
	private String name;

	public Sender(MessageBox messBox, String name) {
		this.messBox = messBox;
		this.name = name;
	}

	public void run() {
		for (int i = 1; i <= 5; i++) {
			messBox.put(i);
			System.out.println("#" + name + " put: " + i);
			try {
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
			}
		}
	}
}

class Receiver extends Thread {
	private MessageBox messBox;
	private String name;

	public Receiver(MessageBox messBox, String name) {
		this.messBox = messBox;
		this.name = name;
	}

	public void run() {
		int val = 0;
		do {
			val = messBox.get();
			System.out.println("#" + name + " got: " + val);
		} while (val < 5);
	}
}

public class TestSenderReceiver {
	public static void main(String[] args) {
		MessageBox mb = new MessageBox();
		Sender sender = new Sender(mb, "Sender");
		Receiver receiver = new Receiver(mb, "Receiver");
		sender.start();
		receiver.start();
	}
}