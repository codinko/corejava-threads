package com.codinko.threads.basic;

import java.util.List;

/**
 * References
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
 * 
 * Synchronization - Synchronized methods or Synchronized statements
 * 
 * Where is the Lock? About lock on _6IntrinsicLock.java [Lock is on the object
 * associated with synchronized keyword. Must note that there is difference when
 * compared to lock associated with concept of synchronized method]
 * 
 * 
 * Another way to create synchronized code is with synchronized statements.
 * Unlike synchronized methods, synchronized statements must specify the object
 * that provides the intrinsic lock:
 * 
 */

public class _5SynchronizedStatements {

	String lastName;
	int nameCount;
	@SuppressWarnings("rawtypes")
	List nameList;

	/*
	 * one way of usage - synchronized (this)
	 */
	@SuppressWarnings("unchecked")
	public void addName(String name) {
		synchronized (this) { // current object or current instance of the class
								// [@runtime]
			lastName = name;
			nameCount++;
		}
		nameList.add(name);
	}

	/**
	 * 
	 * Synchronized statements are also useful for improving concurrency with
	 * fine-grained synchronization.
	 * 
	 * For example, class MsLunch has two instance fields, c1 and c2, that are
	 * never used together. All updates of these fields must be synchronized,
	 * but there's no reason to prevent an update of c1 from being interleaved
	 * with an update of c2 — and doing so reduces concurrency by creating
	 * unnecessary blocking. Instead of using synchronized methods or otherwise
	 * using the lock associated with this, we create two objects solely to
	 * provide locks.
	 * 
	 * interleave meaning 'both the threads interact/mix at same time'
	 */

	/*
	 * Another way of usage - synchronized (a dedicated new object)
	 */
	@SuppressWarnings("unused")
	public class MsLunch {
		private long c1 = 0;
		private long c2 = 0;
		private Object lock1 = new Object();
		private Object lock2 = new Object();

		public void inc1() {
			synchronized (lock1) {
				c1++;
			}
		}

		public void inc2() {
			synchronized (lock2) {
				c2++;
			}
		}
	}

	/*
	 * What's the advantage you see over here? If you use synchronized method,
	 * the lock is on the object level, and another thread cannot access or make
	 * update to a different field say 'c2' of the same object even if there's
	 * no reason to prevent an update of c1 from being interleaved with an
	 * update of c2 , or vice-versa. But with the above fine-grained way of
	 * synchronization, you can overcome that restriction.
	 * 
	 * But USE with EXREME CARE: You must be absolutely sure that it really is
	 * safe to interleave access of the affected fields.
	 */

}
