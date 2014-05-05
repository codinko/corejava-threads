package com.codinko.threads.basic;

/**
 * I am a foodie!
 * 
 * One person ask if he has something to eat polling the "food" variable.
 * Another person updates the shared variable food.
 * 
 * food = true means the first person can start eating. food = false means he
 * has to wait and poll the value until food is available(food = true).
 * 
 */
public class _15GuardedBlockWithWait_NotifyAllError {

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
		 * Efficient way of implementation making it suspend execution until it
		 * gets interrupted. But an interruption alone does not mean food is
		 * available. May be interrupt was called by someone else who does not
		 * provide food. So check the condition too.
		 * 
		 * Through wait(), the execution is suspended, CPU is free to take other
		 * tasks, The lock on object is released so that othe rthreads can
		 * acquire the lock on the object. woww many advantages on using wait()
		 */
		public synchronized void eatFood() {
			while (!isFood()) {
				// food is currently unavailable. I'm waiting..
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("eatFood() caught InterruptedException");
					e.printStackTrace();
				}
				// The lock on the object is released.
			}
			// if control comes here, then it means food is available
			System.out.println("got the food.. yummyy..thanks!");
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
		new Thread(runnable1, "thread1").start();

		// someone is needed to make the food available for kuttappan.

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000); // 5 seconds
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				kuttappan.setFood(true);
				/*
				 * inform threads. Try by commenting notifyAll(); The first
				 * thread will wait for ever!
				 */
				// the below way of invoking notifyAll gives you ERROR!
				notifyAll();
			}
		}).start();

	}
}
/**
 * @formatter:off OUTPUT is error: Exception in thread "Thread-0"
 *                java.lang.IllegalMonitorStateException at
 *                java.lang.Object.notifyAll(Native Method) at
 *                com.example4._15GuardedBlockWithWait$2
 *                .run(_15GuardedBlockWithWait.java:97) at
 *                java.lang.Thread.run(Thread.java:662)
 * 
 *                and the program keeps on running for ever!
 * 
 *                Reason quite obvious: notifyAll() - notify all threads
 *                associated with which object???
 */
/**
 * 
 * notifyAll():
 * 
 * void java.lang.Object.notifyAll()
 * 
 * Wakes up all threads that are waiting on this object's monitor. A thread
 * waits on an object's monitor by calling one of the wait methods.
 * 
 * The awakened threads will not be able to proceed until the current thread
 * relinquishes the lock on this object. The awakened threads will compete in
 * the usual manner with any other threads that might be actively competing to
 * synchronize on this object; for example, the awakened threads enjoy no
 * reliable privilege or disadvantage in being the next thread to lock this
 * object.
 * 
 * This method should only be called by a thread that is the owner of this
 * object's monitor. See the notify method for a description of the ways in
 * which a thread can become the owner of a monitor.
 * 
 */
