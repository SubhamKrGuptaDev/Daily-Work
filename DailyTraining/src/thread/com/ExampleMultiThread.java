package thread.com;

import thread.com.impl.ThreadExample;

public class ExampleMultiThread {

	public static void main(String[] args) {

		// 
//		Runnable runnable = new Runnable() {
//			
//			@Override
//			public void run() {
//				for(Integer i=0; i<100; i++) {
//					try {
//						System.out.println(i + " Index | Thread : Name : " + Thread.currentThread().getName());
//						Thread.sleep(1000);
//					} catch(Exception ex) {
//						ex.printStackTrace();
//					}
//				}
//				
//			}
//		};
		
		// Lambda 
//		Thread thread = new Thread(() -> System.out.println("Hello"));
		
		for(Integer i=0; i<2; i++) {
			ThreadExample t1 = new ThreadExample(i);
			
			Thread thread1 = new Thread(t1);
			
			thread1.start();
		}
		
		
	}
	
	
}
