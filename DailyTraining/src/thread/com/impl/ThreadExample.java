package thread.com.impl;

public class ThreadExample implements Runnable {

	private Integer index;
	
	public ThreadExample(Integer index) {
		this.index = index;
	}
	
	@Override
	public void run() {
		for(Integer i=index; i<100; i++) {
			try {
				System.out.println(i + " Index | Thread : Name : " + Thread.currentThread().getName());
				Thread.sleep(1000);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
