package com.codinko.threads.theory;

/**
 * The questions are to understand what Thread is, from practical sense.
 */
public class ThreadBasicQn {

	static class Friend {
		private final String name;

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		// recipient - the person who greets
		public synchronized void sayHi(Friend recipient) {
			System.out.format("%s" + " said hi to %s %n", this.name,
					recipient.getName());
		}
	}

	public static void main(String[] args) {
		final Friend john = new Friend("John");
		final Friend peter = new Friend("Peter");

		new Thread(new Runnable() {
			public void run() {
				john.sayHi(peter);
			}
		}, "thread1").start();
	}
}

/**
 * QUESTIONS and inline ANSWERS
 * 
 * 1. When invoking john.sayHi(), the Thread thread1 will try to acquire
 * intrinsic lock of john object in-order to access the sayHi() method of john
 * object.
 * 
 * When invoking john.sayHi(), the Thread thread1 will wait until it can acquire
 * a lock on john before executing sayHi. Once it has obtained the lock, it will
 * execute sayHi. It will release the lock when the method exits.
 * 
 * 
 * 2. The Thread thread1 is running independently in JVM.
 * 
 * Independently of what? Other threads? Yes, until it tries to obtain a lock.
 * At that point, it can be impeded by other threads. When it has a lock, it can
 * impede other threads.
 * 
 * 3. The thread thread1 is not running on any other object inside the JVM.
 * 
 * Threads run on CPUs, not objects. A thread cannot execute more than one
 * method in parallel.
 * 
 * 4. A thread never runs on any object(?)
 * 
 * Threads run on CPUs, not objects.
 * 
 * 5. A thread is never executed by an object.
 * 
 * Threads aren't executed by anything. Threads execute code.
 * 
 * 6. A thread never runs on any other thread.
 * 
 * Threads run on CPUs, not threads.
 * 
 * 7. A thread always run directly in JVM.
 * 
 * The JVM has a virtual CPU on which the thread runs.
 * 
 */

