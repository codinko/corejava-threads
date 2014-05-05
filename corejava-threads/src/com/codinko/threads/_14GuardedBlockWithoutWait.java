package com.codinko.threads;

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
public class _14GuardedBlockWithoutWait {

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
		 * Dirty way of implementation making CPU busy. though the loop does
		 * nothing.
		 */
		public synchronized void eatFood() {
			while (!isFood()) {
				// food is currently unavailable. I'm waiting..
				// The lock on the object is not released.
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
					Thread.sleep(5000); // 5 seconds
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				kuttappan.setFood(true);
			}
		}).start();

	}
}
