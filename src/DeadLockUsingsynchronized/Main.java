package DeadLockUsingsynchronized;

import java.lang.reflect.Constructor;

public class Main {
	
	//Creating two static strings
	static String str1 = "String 1";
	static String str2 = "String 2";
	
	//Creating two threads
	Thread thread1 = null;
	Thread thread2 = null;
	
	//Constructor
	Main(){
		
		initiateFirstThread();
		initiateSecondThread();
		
	}
	
	//This method use thread1 to lock str1 using synchronized then try to access str2
	private void initiateFirstThread() {
		this.thread1 = new Thread() {
			@Override
			public void run() {
				//super.run();
				
				synchronized (str1) {
					try {
						System.out.println(str1 + " is locked by " + Thread.currentThread().getName() + "\n		Next trying to lock " +str2);
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
		
					synchronized (str2) {
						System.out.println("\n" +str2 + " is locked by " + Thread.currentThread().getName());
					}
				}
				
			}
		};
		
	}
	
	//This method use thread2 to lock str2 using synchronized then try to access str1
	private void initiateSecondThread() {
		this.thread2 = new Thread() {
			@Override
			public void run() {
				//super.run();
				
				synchronized (str2) {
					System.out.println("\n\n" +str2 + " is locked by " + Thread.currentThread().getName() + "\n		Next trying to lock " +str1);
				
				
					synchronized (str1) {
						System.out.println("\n" + str1 + " is locked by " + Thread.currentThread().getName());
					}
				}
			}
		};
		
	}

	public static void main(String[] args) {

		Main main = new Main();
		main.thread1.start();
		main.thread2.start();
		
	}

}
