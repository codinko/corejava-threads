package com.codinko.example;

/**
 * 
 * References
 * 
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/join.html
 * 
 */
public class SleepInterruptJoin {

	public static void main(String[] args) {
		SleepInterruptJoin obj = new SleepInterruptJoin();
		obj.method1();
	}

	public void method1() {

		Runnable runnable1 = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(1000);
						System.out
								.println("running thread1 for " + i + " time");
					} catch (InterruptedException e) {
						System.out
								.println("InterruptedException from thread1 is caught");
						e.printStackTrace();
						return;
					}
				}
			}
		};
		Thread t1 = new Thread(runnable1, "thread1");
		t1.start();

		Runnable runnable2 = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					try {
						Thread.sleep(1000);
						System.out
								.println("running thread2 for " + i + " time");
					} catch (InterruptedException e) {
						System.out
								.println("InterruptedException from thread2 is caught");
						e.printStackTrace();
						return;
					}
				}
			}
		};
		Thread t2 = new Thread(runnable2, "thread2");
		t2.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}

		t1.interrupt();

		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("main thread printing hello");
				t2.join();
			} catch (InterruptedException e) {
				System.out
						.println("InterruptedException from main thread is caught");
				e.printStackTrace();
				return;
			}

		}
	}
}
//@formatter:on
/**
 * OUTPUT:
 * 
running thread1 for 0 time
running thread2 for 0 time
running thread1 for 1 time
running thread2 for 1 time
running thread1 for 2 time
running thread2 for 2 time
running thread1 for 3 time
running thread2 for 3 time
InterruptedException from thread1 is caught
running thread2 for 4 time
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at com.codinko.example.SleepInterruptJoin$1.run(SleepInterruptJoin.java:27)
	at java.lang.Thread.run(Unknown Source)
main thread printing hello
running thread2 for 5 time
running thread2 for 6 time
running thread2 for 7 time
running thread2 for 8 time
running thread2 for 9 time
running thread2 for 10 time
....
....

 */
