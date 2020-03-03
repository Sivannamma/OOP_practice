package Thread;

public class Producer implements Runnable {
	private DataCenter data;
	private int counter = 0;

	Producer(DataCenter data) {
		this.data = data;
	}

	public void run() {
		while (true) {
			try {

				String product = "" + counter++;
				Thread.sleep(1000);

				synchronized (data) {
					while (data.getCount() == DataCenter.CAPACITY)
						data.wait();

					data.setMsg(product);
					data.notifyAll();
				}
			} catch (InterruptedException e) {
				System.out.println("Somthing went wrong");
			}
		}
	}
}
