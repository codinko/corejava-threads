package com.codinko.threads.basic;

/**
 * 
 * Also explained in _1ThreadCommunicationIntro.java
 * 
 */
public class _11StarvationLiveLock {
	/**
	 * Starvation and Livelock
	 * 
	 * Starvation and livelock are much less common a problem than deadlock, but
	 * are still problems that every designer of concurrent software is likely
	 * to encounter.
	 * 
	 * Starvation
	 * 
	 * Starvation describes a situation where a thread is unable to gain regular
	 * access to shared resources and is unable to make progress. This happens
	 * when shared resources are made unavailable for long periods by "greedy"
	 * threads. For example, suppose an object provides a synchronized method
	 * that often takes a long time to return. If one thread invokes this method
	 * frequently, other threads that also need frequent synchronized access to
	 * the same object will often be blocked.
	 * 
	 * Livelock
	 * 
	 * A thread often acts in response to the action of another thread. If the
	 * other thread's action is also a response to the action of another thread,
	 * then livelock may result. As with deadlock, livelocked threads are unable
	 * to make further progress. However, the threads are not blocked � they are
	 * simply too busy responding to each other to resume work. This is
	 * comparable to two people attempting to pass each other in a corridor:
	 * Kuttappan moves to his left to let Daasappan pass, while Daasappan moves
	 * to his right to let Kuttappan pass. Seeing that they are still blocking
	 * each other, Kuttappan moves to his right, while Daasappan moves to his
	 * left. They're still blocking each other!!
	 * 
	 */
}
