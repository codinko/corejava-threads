package com.codinko.threads.basic;

/**
 * 
 * References:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html
 * 
 * Threads communicate primarily by sharing : - access to fields and - the
 * objects reference fields refer to.
 * 
 * Thread communication lead to (1) Thread interference; (2) Memory consistency
 * errors. Tool to prevent this: Synchronization
 * 
 * Synchronization introduce "Thread Contention" which occurs when two or more
 * threads try to access the same resource simultaneously and cause the Java
 * runtime to execute one or more threads more slowly, or even suspend their
 * execution.
 * 
 * Thread Contention types : Deadlock, Starvation, Livelock
 * 
 * Starvation describes a situation where a thread is unable to gain regular
 * access to shared resources and is unable to make progress. This happens when
 * shared resources are made unavailable for long periods by "greedy" threads.
 * For example, suppose an object provides a synchronized method that often
 * takes a long time to return. If one thread invokes this method frequently,
 * other threads that also need frequent synchronized access to the same object
 * will often be blocked.
 * 
 * Livelock: A thread often acts in response to the action of another thread. If
 * the other thread's action is also a response to the action of another thread,
 * then livelock may result. As with deadlock, livelocked threads are unable to
 * make further progress. However, the threads are not blocked — they are simply
 * too busy responding to each other to resume work. This is comparable to two
 * people attempting to pass each other in a corridor: Kuttappan moves to his
 * left to let Daasappan pass, while Daasappan moves to his right to let
 * Kuttappan pass. Seeing that they are still blocking each other, Kuttappan
 * moves to his right, while Daasappan moves to his left. They're still blocking
 * each other!!
 * 
 * 
 * 
 */
public class _1ThreadCommunicationIntro {

	public static void main(String[] args) {
		System.out.println("various " + "topics:");

		// @formatter:off
		/**
		 * Thread communication lead to (1) and (2).
		 * (1) and (2) are prevented by (3)
		 * 
		 * 1. Thread Interference - describes how errors are introduced when
		 * multiple threads access shared data.
		 * 
		 * 2. Memory Consistency Errors - describes errors that result from
		 * inconsistent views of shared memory.
		 * 
		 * 3. Synchronized Methods - effectively prevent thread interference and
		 * memory consistency errors.
		 * 
		 * 4. Implicit Locks and Synchronization -describes how synchronization
		 * is based on implicit locks.
		 * 
		 * 5. Atomic Access - talks about the general idea of operations that
		 * can't be interfered with by other threads.
		 * 
		 */
		// @formatter:on

	}

}
