package com.codinko.threads.basic;

/**
 * References:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
 * 
 */
public class _7ReentrantSynchronization {
	/**
	 * 
	 * A Thread cannot acquire a lock owned by another thread.
	 * 
	 * But a thread can acquire a lock that it already owns.
	 * 
	 * Allowing a thread to acquire the same lock more than once enables
	 * "reentrant synchronization".
	 * 
	 * This describes a situation where synchronized code, directly or
	 * indirectly, invokes a method that also contains synchronized code, and
	 * both sets of code use the same lock. [Without reentrant synchronization,
	 * synchronized code would have to take many additional precautions to avoid
	 * having a thread cause itself to block, Thank God!]
	 * 
	 */

	/**
	 * 
	 * ie: Situation like: A thread that invoke obj1.method1(), and if method1()
	 * is calling method2()
	 * 
	 * synchronized method1()
	 * 
	 * synchronized method2()
	 * 
	 * There is only one lock , and this concept here is referred to as
	 * 'reentrant synchronization'
	 */
}
