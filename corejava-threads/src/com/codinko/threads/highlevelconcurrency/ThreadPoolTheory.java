package com.codinko.threads.highlevelconcurrency;

public class ThreadPoolTheory {
	/**
	 * Thread Pools are useful when you need to limit the number of threads
	 * running in your application at the same time. There is a performance
	 * overhead associated with starting a new thread, and each thread is also
	 * allocated some memory for its stack etc.
	 * 
	 * Instead of starting a new thread for every task to execute concurrently,
	 * the task can be passed to a thread pool. As soon as the pool has any idle
	 * threads the task is assigned to one of them and executed. Internally the
	 * tasks are inserted into a Blocking Queue which the threads in the pool
	 * are dequeuing from. When a new task is inserted into the queue one of the
	 * runnable threads will dequeue it successfully and execute it (it became a
	 * worker thread). The rest of the runnable threads in the pool will be
	 * blocked waiting to dequeue tasks.
	 * 
	 * Java 5 comes with built in thread pools in the java.util.concurrent
	 * package, so you don't have to implement your own thread pool.
	 * 
	 */

}
