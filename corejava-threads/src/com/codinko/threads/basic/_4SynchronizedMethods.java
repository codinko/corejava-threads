package com.codinko.threads.basic;

/**
 * References
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html
 * 
 * Synchronization - Synchronized methods or Synchronized statements
 * 
 * Where is the Lock? About lock on _6IntrinsicLock.java [If two threads
 * executing the code on same object, they do not interfere as the object-level
 * lock is already acquired by one at a time]
 * 
 */
public class _4SynchronizedMethods {

	private int c = 0;

	public synchronized void increment() {
		c++;
	}

	public synchronized void decrement() {
		c--;
	}

	public synchronized int value() {
		return c;
	}

	/**
	 * 
	 * If count is an instance of this class, then making these methods
	 * synchronized has two effects:
	 * 
	 * (1) It is not possible for two invocations of synchronized methods on the
	 * same object to interleave. When one thread is executing a synchronized
	 * method for an object, all other threads that invoke synchronized methods
	 * for the same object block (suspend execution) until the first thread is
	 * done with the object.
	 * 
	 * (2)
	 * *** happens-before relationship *** -> changes made by one thread visible
	 * to other threads after first thread returned [return or exception thrown.
	 * basically control returned]
	 * 
	 * When a synchronized method exits, it automatically establishes a
	 * happens-before relationship with any subsequent invocation of a
	 * synchronized method for the same object. This guarantees that changes to
	 * the state of the object are visible to all threads.
	 * 
	 */

	/**
	 * Strategy:
	 * 
	 * Synchronized methods enable a simple strategy for preventing thread
	 * interference and memory consistency errors: If an object is visible to
	 * more than one thread, all reads or writes to that object's variables are
	 * done through synchronized methods
	 * 
	 */

	/**
	 * 
	 * An important exception: final fields, which cannot be modified after the
	 * object is constructed, can be safely read through non-synchronized
	 * methods, once the object is constructed) This strategy is effective, but
	 * can present problems with 'liveness' [explained later]
	 * 
	 */

	public _4SynchronizedMethods() {

	}

	/**
	 * Constructors cannot be synchronized
	 * 
	 * Because it doesn't make any sense!!
	 * 
	 * Using the synchronized keyword with a constructor is a syntax error.
	 * Synchronizing constructors doesn't make sense, because only the thread
	 * that creates an object should have access to it while it is being
	 * constructed.
	 */

	/**
	 * 
	 * Warning: When constructing an object that will be shared between threads,
	 * be very careful that a reference to the object does not "leak"
	 * prematurely. For example, suppose you want to maintain a List called
	 * instances containing every instance of class. You might be tempted to add
	 * the following line to your constructor:
	 * 
	 * MyClassConstructor() {
	 * 	instances.add(this); // Let's say instances is shared between Threads
	 * }
	 * But then other threads can use instances to access the object before
	 * construction of the object is complete.
	 * 
	 */

}
