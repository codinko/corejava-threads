package com.codinko.threads.highlevelconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * @formatter:off
 * public abstract interface Executor
 * 
 * public abstract interface ExecutorService extends Executor
 * 
 * public abstract class AbstractExecutorService implements ExecutorService
 * 
 * public class ThreadPoolExecutor extends AbstractExecutorService
 * 
 * Executors.execute() returns ThreadPoolExecutor of type ExecutorService
 * 
 * public class Executors .. 
 * 
 *  	public static ExecutorService newFixedThreadPool(int nThreads) {
        	return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    	}
 * 
 * 
 * public abstract interface ScheduledExecutorService extends ExecutorService
 */
//@formatter:on
/**
 * References:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/exinter.html
 * 
 * The 3 executor object types are defined by the "Executor Interfaces".
 * 
 * The java.util.concurrent package defines three executor interfaces:
 * 
 * (I)Executor, a simple interface that supports launching new tasks.
 * 
 * (I)ExecutorService, a subinterface of Executor, which adds features that help
 * manage the lifecycle, both of the individual tasks and of the executor
 * itself.
 * 
 * (I)ScheduledExecutorService, a subinterface of ExecutorService, supports
 * future execution of tasks and/or periodic execution of tasks.
 * 
 * Typically, variables that refer to executor objects are declared as one of
 * these three interface types, not with an executor class type.
 * 
 */
public class _21ExecutorInterfaces {
	/**
	 * 
	 * The Executor Interface (I)
	 * 
	 * The Executor interface provides a single method, execute(), designed to
	 * be a drop-in replacement for a common thread-creation idiom. If r is a
	 * Runnable object, and e is an Executor object you can replace
	 */
// @formatter:off 
/*
(new Thread(r)).start();
with
e.execute(r);
 */
// @formatter:on

	/**
	 * However, the definition of execute is less specific. The low-level idiom
	 * creates a new thread and launches it immediately. Depending on the
	 * Executor implementation, execute may do the same thing, but is more
	 * likely to use an existing worker thread to run r, or to place r in a
	 * queue to wait for a worker thread to become available. (We'll describe
	 * worker threads in the section on Thread Pools.)
	 * 
	 * The executor implementations in java.util.concurrent are designed to make
	 * full use of the more advanced ExecutorService and
	 * ScheduledExecutorService interfaces, although they also work with the
	 * base Executor interface.
	 */
	// --------------------------------------------------------------------------------------
	/**
	 * The ExecutorService Interface (I)
	 * 
	 * The ExecutorService interface supplements execute with a similar, but
	 * more versatile submit() method. Like execute, submit accepts Runnable
	 * objects, but also accepts Callable objects, which allow the task to
	 * return a value. The submit method returns a Future object, which is used
	 * to retrieve the Callable return value and to manage the status of both
	 * Callable and Runnable tasks.
	 * 
	 * ExecutorService also provides methods for submitting large collections of
	 * Callable objects. Finally, ExecutorService provides a number of methods
	 * for managing the shutdown of the executor. To support immediate shutdown,
	 * tasks should handle interrupts correctly.
	 */

	/**
	 * The ScheduledExecutorService Interface (I)
	 * 
	 * The ScheduledExecutorService interface supplements the methods of its
	 * parent ExecutorService with schedule, which executes a Runnable or
	 * Callable task after a specified delay. In addition, the interface defines
	 * scheduleAtFixedRate and scheduleWithFixedDelay, which executes specified
	 * tasks repeatedly, at defined intervals.
	 * 
	 */
}
