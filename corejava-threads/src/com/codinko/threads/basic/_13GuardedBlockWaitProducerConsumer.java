package com.codinko.threads.basic;

/**
 * Naming of class name : Guarded Blocks. Wait helps for that. This is a
 * Producer-Consumer example
 * 
 * Reference:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
 * 
 * In this example, the data is a series of text messages, which are shared
 * through an object of type Drop:
 */
public class _13GuardedBlockWaitProducerConsumer {
	class Drop {
		// Message sent from producer
		// to consumer.
		private String message;
		// True if consumer should wait
		// for producer to send message,
		// false if producer should wait for
		// consumer to retrieve message.
		private boolean empty = true;

		// consumer take
		public synchronized String take() {
			// Wait until message is
			// available.
			while (empty) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			// Toggle status.
			empty = true;
			// Notify producer that
			// status has changed.
			notifyAll();
			return message;
		}

		// producer put
		public synchronized void put(String message) {
			// Wait until message has
			// been retrieved.
			while (!empty) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			// Toggle status.
			empty = false;
			// Store message.
			this.message = message;
			// Notify consumer that status
			// has changed.
			notifyAll();
		}
	}
}
