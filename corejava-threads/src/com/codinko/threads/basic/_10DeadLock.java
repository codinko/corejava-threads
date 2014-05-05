package com.codinko.threads.basic;

/**
 * Reference:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html
 * 
 * The most common kind of liveness problem : deadlock
 * 
 * DeadLock:
 * 
 * Deadlock describes a situation where two or more threads are blocked forever,
 * waiting for each other. Here's an example.
 * 
 * Say if there are two threads A and B , and each thread require access to say
 * two shared resources to achieve a particular task. If thread A acquired
 * resource1 and is about to access resource2 so that it can complete its task.
 * Now, threadB acquired resource2 and is about to access resource1 so that it
 * can complete its task. If both of these threads decide to wait until what
 * they need is no longer in use [or released by the other one], then they will
 * wait for each other forever. That's DeadLock.
 * 
 * Another example:
 * 
 * One Person say "hi". The second person has to say "bye". Then only, the first
 * person will be able to complete his task.
 * 
 * John says "hi" to Peter [John is locked]. John will be able to complete his
 * task only if Peter say "bye". [Peter cannot say "bye" as it already said
 * "hi", and can release lock on Peter object only if John say "bye"]
 * 
 * Peter say "hi" to John [Peter is locked]. Peter will be able to complete his
 * task only if John say "bye". [Similarly John cannot say "bye" as it already
 * said "hi", and can release lock on John object only if Peter say "bye"].
 * 
 * Both of them does not complete their task, waiting for each other. DeadLock.
 * 
 */
public class _10DeadLock {
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
			/*
			 * Let's say this is john.sayHi(peter);. "hi" is told by Peter. Now
			 * John have to say "bye" to Peter. invoke sayBye() on this
			 * recipient object[ both the objects hold lock at this point of
			 * Time Hence indefinitely waits!! for other thread to release
			 * lock!!]
			 */
			recipient.sayBye(this);
			/*
			 * if recipient object is locked by a different thread, this current
			 * thread cannot complete!
			 */
		}

		public synchronized void sayBye(Friend recipient) {
			System.out.format("%s" + " said bye to %s %n", this.name,
					recipient.getName());
		}
	}

	public static void main(String[] args) {
		final Friend john = new Friend("John");
		final Friend peter = new Friend("Peter");

		new Thread(new Runnable() {
			public void run() {
				john.sayHi(peter); /*
									 * this thread has put a lock on john object
									 * on encountering synchronized 'sayHi()'
									 */

			}
		}, "thread1").start();
		new Thread(new Runnable() {
			public void run() {
				peter.sayHi(john); /*
									 * this thread has put a lock on peter
									 * object on encountering synchronized
									 * 'sayHi()'
									 */
			}
		}, "thread2").start();
	}
}
