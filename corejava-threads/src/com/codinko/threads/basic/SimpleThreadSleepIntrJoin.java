package com.codinko.threads.basic;

/**
 * References:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/simple.html
 * 
 * Sleep, Interrupt, Join
 */

public class SimpleThreadSleepIntrJoin {
	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}

	private static class MessageLoop implements Runnable {
		public void run() {
			String importantInfo[] = { "Mares eat oats", "Does eat oats",
					"Little lambs eat ivy", "A kid will eat ivy too" };
			try {
				for (int i = 0; i < importantInfo.length; i++) {
					// Pause for 4 seconds
					Thread.sleep(4000);
					// Print a message
					threadMessage(importantInfo[i]);
				}
			} catch (InterruptedException e) {
				threadMessage("I wasn't done!");
			}
		}
	}

	public static void main(String args[]) throws InterruptedException {

		/*
		 * Delay, in milliseconds before we interrupt MessageLoop thread
		 * (default one hour).
		 */
		long patience = 1000 * 60 * 60;
		/*
		 * TODO: test-change patience to 5 seconds, to see a different behavior
		 */
		/*
		 * If command line argument present, gives patience in seconds.
		 */
		if (args.length > 0) {
			try {
				patience = Long.parseLong(args[0]) * 1000;
			} catch (NumberFormatException e) {
				System.err.println("Argument must be an integer.");
				System.exit(1);
			}
		}

		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop(), "messageloopthread");
		t.start();

		threadMessage("Waiting for MessageLoop thread to finish");
		// loop until MessageLoop
		// thread exits
		while (t.isAlive()) {
			threadMessage("Still waiting...");
			/*
			 * Wait maximum of 1 second for MessageLoop thread to finish.
			 */
			t.join(); // TODO: test-remove the 1 second duration, and see
							// the power of join()
			if (((System.currentTimeMillis() - startTime) > patience)
					&& t.isAlive()) {
				threadMessage("Tired of waiting!");
				t.interrupt();
				// Shouldn't be long now
				// -- wait indefinitely
				t.join();
				/**
				 * TODO: test-remove this line and see how the program
				 * behaves.[normal case] Note that, scenario when, once 't' is
				 * interrupted, this line doesn't make any sense.
				 */
			}
		}
		threadMessage("Finally!");
	}
}

/**
 * main: Starting MessageLoop thread
main: Waiting for MessageLoop thread to finish
main: Still waiting...
main: Still waiting...
main: Still waiting...
main: Still waiting...
main: Still waiting...
messageloopthread: Mares eat oats
main: Still waiting...
main: Still waiting...
main: Still waiting...
messageloopthread: Does eat oats
main: Still waiting...
main: Still waiting...
main: Still waiting...
main: Still waiting...
messageloopthread: Little lambs eat ivy
main: Still waiting...
main: Still waiting...
main: Still waiting...
main: Still waiting...
messageloopthread: A kid will eat ivy too
main: Finally!
 */

/**
 * Replace t.join(1000) with t.join()
 * 
 * OUTPUT:
 * 
 * main: Starting MessageLoop thread
main: Waiting for MessageLoop thread to finish
main: Still waiting...
messageloopthread: Mares eat oats
messageloopthread: Does eat oats
messageloopthread: Little lambs eat ivy
messageloopthread: A kid will eat ivy too
main: Finally!
 * 
 */
