package com.codinko.threads.highlevelconcurrency;

/**
 * References:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/newlocks.html
 * 
 * Synchronized code relies on a simple kind of reentrant lock. This kind of
 * lock is easy to use, but has many limitations. 
 * 
 * More sophisticated locking idioms are supported by the java.util.concurrent.locks package. 
 * 
 * We won't examine this package in detail, but instead will focus on its most basic
 * interface, Lock.
 * 
 * Lock objects work very much like the implicit locks used by synchronized
 * code. As with implicit locks, only one thread can own a Lock object at a
 * time. Lock objects also support a wait/notify mechanism, through their
 * associated Condition objects.
 * 
 * The biggest advantage of Lock objects over implicit locks is their ability to
 * back out of an attempt to acquire a lock. The tryLock method backs out if the
 * lock is not available immediately or before a timeout expires (if specified).
 * The lockInterruptibly method backs out if another thread sends an interrupt
 * before the lock is acquired.
 * 
 * Let's use Lock objects to solve the deadlock problem we saw in Liveness.
 * Kuttappan and Daasappan have trained themselves to notice when a friend is
 * about to say "hi". We model this improvement by requiring that our Friend
 * objects must acquire locks for both participants before proceeding with saying "hi".
 * Here is the source code for the improved model, _2LockObjects_Safelock. To demonstrate the
 * versatility of this idiom, we assume that Kuttappan and Daasappan are so
 * infatuated with their newfound ability to say "hi" safely that they can't
 * stop saying "hi" to each other:
 * 
 * IMPORTANT SENTENCE: "We model this improvement by requiring that our Friend
 * objects must acquire locks for both participants before proceeding with saying "hi"".
 * 
 * 'impending' word meaning - 'be about to happen'/'approaching'
 * 
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

public class _1LockObjects_Safelock {

	static class Friend {
		private final String name;
		private final Lock lock = new ReentrantLock();

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		// check if both locks are available before locking any one
		public boolean impendingHi(Friend wisher) {
			Boolean myLock = false;
			Boolean yourLock = false;
			try {
				myLock = lock.tryLock();
				yourLock = wisher.lock.tryLock();
			} finally {
				if (!(myLock && yourLock)) {
					if (myLock) {
						lock.unlock();
					}
					if (yourLock) {
						wisher.lock.unlock();
					}
				}
			}
			return myLock && yourLock;
		}

		public void sayHi(Friend wisher) {
			if (impendingHi(wisher)) {
				try {
					System.out.format("%s : %s has" + " said hi to me!%n",
							this.name, wisher.getName());
					wisher.sayBye(this);
				} finally {
					lock.unlock();
					wisher.lock.unlock();
				}
			} else {
				System.out.format("%s : %s started"
						+ " saying hi to me, but saw that"
						+ " I was already saying hi to" + " him.%n", this.name,
						wisher.getName());
			}
		}

		public void sayBye(Friend wisher) {
			System.out.format("%s : %s has" + " said bye to me!%n", this.name,
					wisher.getName());
		}
	}

	static class HiLoop implements Runnable {
		private Friend wisher;
		private Friend recipient;

		public HiLoop(Friend wisher, Friend recipient) {
			this.wisher = wisher;
			this.recipient = recipient;
		}

		public void run() {
			Random random = new Random();
			for (int i = 0; i < 15; i++) {
				try {
					Thread.sleep(random.nextInt(10));
				} catch (InterruptedException e) {
				}
				recipient.sayHi(wisher);// recipient says wisher has said hi to
										// me
				// [not the reverse]
			}
		}
	}

	public static void main(String[] args) {
		final Friend kuttappan = new Friend("Kuttappan");
		final Friend daasappan = new Friend("Daasappan");
		new Thread(new HiLoop(kuttappan, daasappan)).start();
		new Thread(new HiLoop(daasappan, kuttappan)).start();
	}
}

/**
 * 
 * OUTPUT:
 * 
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Kuttappan : Daasappan started saying hi to me, but saw that I was already saying hi to him.
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Kuttappan : Daasappan has said hi to me!
Daasappan : Kuttappan has said bye to me!
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
Kuttappan : Daasappan started saying hi to me, but saw that I was already saying hi to him.
Daasappan : Kuttappan has said hi to me!
Kuttappan : Daasappan has said bye to me!
 * 
 */
