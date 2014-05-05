package com.codinko.threads.basic;

/**
 * I am a foodie!
 * 
 * One person ask if he has something to eat polling the "food" variable.
 * Another person updates the shared variable food.
 * 
 * food = true means the first person can start eating. food = false means he
 * has to wait and poll the value until food is available(food = true). This is
 * not a producer-consumer problem.
 * 
 * Also note that notifyAll doesn't throw Interrupted Exception. It just wake up
 * the threads.
 * 
 */
public class _16GuardedBlockWithWait_NotifyAll {

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

		public synchronized void provideFood() {
			this.setFood(true); // this refers to current object. In this case,
								// the
			// 'kuttappan' object
			notifyAll(); // In our case, notifyAll() is associated with
							// 'kuttappan'
			// object
			/**
			 * Also note that notifyAll doesn't throw Interrupted Exception. It
			 * just wake up the threads.
			 */
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
					Thread.sleep(5000); // 5 seconds
					kuttappan.provideFood();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}
}
