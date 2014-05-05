package com.codinko.threads.basic;

/**
 * WARNING: This is not good code! This is only for showing how bad something is!
 * 
 * Objective of this program:
 * 
 * Have you thought, yhy can't we achieve the guarded block with Sleep and Interrupt,
 * why only with wait and notify..
 * 
 * Wait releases lock; while Sleep does not . 
 * Sleeping a Thread does not release the locks it holds, while waiting releases the lock on the 
 * object that wait() is called on.
 * 
 * But both suspend the execution. 
 * 
 * If you use Sleep, and also synchronizing on the object, then we cannot have the second thread
 * to modify the object state due the lock on the object, and the second thread cannot acquire it.
 * 
 * So I did a explicit interrupt on the first thread.
 * 
 */
/**
 * Example case scenario:
 * 
 * One person ask if he has something to eat polling the "food" variable.
 * Another person updates the shared variable food.
 * 
 * food = true means the first person can start eating. food = false means he
 * has to wait and poll the value until food is available(food = true). This is
 * not a producer-consumer problem.
 * 
 */
public class _17GuardedBlockWithSleep_Interrupt_Badcase {

	static class Person {

		volatile boolean food;

		public boolean isFood() {
			return food;
		}

		public void setFood(boolean food) {
			this.food = food;
		}

		String name;

		Person(String name) {
			this.name = name;
		}

		/*
		 * Sloppy/Bad way of implementation making it pause execution until it
		 * gets interrupted. An interruption alone does not mean food is
		 * available. May be interrupt was called by someone else who does not
		 * provide food. So check the condition too.
		 * 
		 * Through sleep(), the execution is paused. CPU is free to take other
		 * tasks, The lock on object is NOT released so other threads CANNOT
		 * acquire the lock on the object.
		 */

		// Guarded Block
		public synchronized void eatFood() {
			while (!isFood()) {
				// food is currently unavailable. I'm waiting..
				try {
					/**
					 * Ideally we do wait() and notifyAll() in such a scenario.
					 * I am trying with Sleep and Interrupt.
					 */
					Thread.sleep(1000000000);
				} catch (InterruptedException e) {
					this.setFood(true);// it's not some other thread that
										// provide
					// food. it's itself!
					System.out.println("eatFood() caught InterruptedException");
					// e.printStackTrace();
				}
			}
			// if control comes here, then it means food is available
			System.out.println("got the food.. yummyy..thanks!");
		}

		public synchronized void provideFood(Thread t) {
			this.setFood(true); // this refers to current object. In this case,
								// the
			// 'kuttappan' object
			// interrupt the first thread
			t.interrupt();
		}

	}

	public static void main(String[] args) {
		final Person kuttappan = new Person("Kuttappan");

		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				/*
				 * if kuttappan is not already defined as final, you get an
				 * error
				 * "Cannot refer to a non-final variable kuttappan inside an inner class defined in a different method"
				 */
				kuttappan.eatFood();
				/*
				 * thread will try to acquire the lock on 'kuttappan' object
				 * when it invokes the synchronized method.
				 */
			}
		};
		final Thread t = new Thread(runnable1, "thread1");
		t.start();

		// someone is needed to make the food available for kuttappan.

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000); // 5 seconds
					t.interrupt(); // MY IMPORTANT LINE
					// kuttappan.provideFood(t);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}

/**
 * OUTPUT:
 * 
 * Observe the line commented as "MY IMPORTANT LINE"
 * 
 * If you do 'kuttappan.provideFood(t);' then the program Keeps on running. no
 * output, because
 * 
 * The second thread cannot get into provideFood() of kuttappan object because
 * the first thread has not released the lock on the object!
 * 
 * But if you do t.interrupt(); the thread is interrupted and the program
 * behaves as expected. The second thread just interrupt the first thread, not
 * provide the food. On catching the interruption, the first thread itself feed
 * food.
 */

/**
 * Observations:
 * 
 * (1) In this scenario producer thread should always have reference to consumer
 * thread in order to interrupt() it and give it possibility to process "event".
 * 
 * If you use wait()/notify() you do not need threads to know each other, all
 * you need is a synchronization point - object that you wait/notify on. Also
 * you can share this object with as many threads as you want. So at the end
 * producer thread does not care who exactly waits for the resource, it only
 * needs to send signal that resource is available.
 * 
 * (2) It's a poor choice because you are counting on one thread catching an
 * interrupted exception every time. Exceptions are a high overhead mechanism
 * for IPC.
 * 
 * (3) Part of the problem is that you rely on the original thread itself to do
 * the work that the second thread should have done. So really you're not doing
 * much better than having a single thread add food then consume it.
 * 
 * (4) Infact, this isn't wrong in terms of functionality... The guess is that
 * it's the poor use of exceptions and increased complexity that make
 * programmers prefer wait() and notifyAll(). Also, although this doesn't apply
 * to this example, using this idea probably wouldn't scale too well if you have
 * many providers.
 * 
 * (5) If you have too many producers you'll end up with lots of
 * InterruptedExceptions, but because you aren't interacting with the object
 * directly I don't think that'd be too horrible. Multiple consumers for the
 * same object is not possible because they would all need to lock that same
 * object. Unless you have multiple consumers each locking different objects, in
 * which case the only issue is keeping track of all the Thread references. In
 * any case, wait() and notifyAll() are probably simpler solutions
 * 
 */

