package com.codinko.threads.highlevelconcurrency;

/**
 * 
 * Scenario of ThreadPool: ThreadPool = Serviceprovider(size) + Tasks(size)
 * 
 * A thread pool manages the pool of Worker threads and Runnable threads; it
 * contains a queue that keeps tasks waiting to get executed.
 * 
 * Worker threads from thread pool, execute Runnable(task) from the queue.
 * 
 * java.util.concurrent.Executors provide implementation of
 * java.util.concurrent.Executor interface to create the thread pool in java.
 * 
 */
public class _TP_1WorkerThread implements Runnable {

	private String command;

	public _TP_1WorkerThread(String command) {
		// System.out.println("i am called"); // this is called 10 times
		this.command = command;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()
				+ " Start. Command = " + command);
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	private void processCommand() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.command;
	}

//@formatter:off
/*public static void main(String[] args) {
new Thread(new _1WorkerThread("hi")).start();
}*/

}

