package com.codinko.threads.highlevelconcurrency;

/**
 * References:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/executors.html
 * 
 * In all of the previous examples, there's a close connection between the task
 * being done by a new thread, as defined by its Runnable object, and the thread
 * itself, as defined by a Thread object. This works well for small
 * applications, but in large-scale applications, it makes sense to separate
 * {thread management and creation} from {the rest of the application}. Objects
 * that encapsulate these functions are known as executors. The following
 * subsections describe executors in detail.
 * 
 * IMPORTANT STATEMENT: "Executors play the role to separate {thread management
 * and creation} from {the rest of the application}"
 * 
 */
public class _2Executors {
	/**
	 * 
	 * The 3 executor object types are defined by the "Executor Interfaces".
	 * 
	 * The most common kind of executor implementation is "Thread Pools".
	 * 
	 * Fork/Join is a framework (new in JDK 7) for taking advantage of multiple
	 * processors.
	 * 
	 */
}
