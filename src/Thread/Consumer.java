package Thread;


public class Consumer implements Runnable
{
	private DataCenter data;

	Consumer(DataCenter data)
	{
		this.data = data;
	}
	
	
    public void run()
    { 
		while (true) 
		{
	    	try
	    	{
				String msg;
				
				synchronized(data) 
				{
			        while (data.getCount() == 0) 
			        	data.wait(); 
			        
			        msg = data.getMsg();
			        data.notifyAll();  
				}
				
				Thread.sleep(1000);
				System.out.println("read msg: " + msg);
			}
	    	catch (InterruptedException e) 
	    	{
	    		System.out.println("Somthing went wrong");
			}
    	}

    }
}
