package com.codinko.threads.highlevelconcurrency;

import java.util.AbstractQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

// ThreadPool implementation using Executors

/**
 * public interface Executor..
 * 
 * public interface ExecutorService extends Executor..
 * 
 * public abstract class AbstractExecutorService implements ExecutorService..
 * 
 * public class ThreadPoolExecutor extends AbstractExecutorService..
 * 
 * ..
 * 
 * ExecutorService executor = Executors.newFixedThreadPool(5);
 */
// @formatter:off
 /** 
  * public class Executors:
  * -----------------------
  * 
  * public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }
    
  * public class ThreadPoolExecutor :
  * ---------------------------------
  * 
  public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             Executors.defaultThreadFactory(), defaultHandler);
    }  
  *
  *public class LinkedBlockingQueue :
  *----------------------------------
  *
  *  public class LinkedBlockingQueue<E> extends AbstractQueue<E>
        implements BlockingQueue<E>, java.io.Serializable {
  
  *
  *An optionally-bounded {@linkplain BlockingQueue blocking queue} based on
 * linked nodes. Linked queues typically have higher throughput[data transfer rate] than array-based queues but
 * less predictable performance in most concurrent applications.
 * 
  *The optional capacity bound constructor argument serves as a
 * way to prevent excessive queue expansion. The capacity, if unspecified,
 * is equal to {@link Integer#MAX_VALUE}.
 * 
 */   
/**
 * 
 * Executors.newFixedThreadPool(5);
 * 
 * Creates a thread pool that reuses a fixed number of threads operating off a
 * shared unbounded queue. At any point, at most 5 threads [in this example]
 * will be active processing tasks. If additional tasks are submitted when all
 * threads are active, they will wait in the queue until a thread is available.
 * If any thread terminates due to a failure during execution prior to shutdown,
 * a new one will take its place if needed to execute subsequent tasks. The
 * threads in the pool will exist until it is explicitly
 * {@link ExecutorService#shutdown shutdown}.
 * 
 */

/**
 * public interface Executor {

    /**
     * Executes the given command at some time in the future.  The command
     * may execute in a new thread, in a pooled thread, or in the calling
     * thread, at the discretion of the <tt>Executor</tt> implementation.
     *
     * @param command the runnable task
     * @throws RejectedExecutionException if this task cannot be
     * accepted for execution.
     * @throws NullPointerException if command is null
     *//**
    void execute(Runnable command);
 } 
 */
// @formatter:on
public class _TP_2ExecutorThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			// System.out.println("printing i " + i); // prints from 0 to 9
			final String command = "" + i;
			Runnable worker = new _TP_1WorkerThread(command); // 10 objects'll
																// be
			// created [not 10
			// threads]
			executor.execute(worker);
		}
		// shutdown the thread pool in order to terminate all the threads of the
		// pool
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}

// @formatter:off
	/**
	 * OUTPUT:
	 *
	pool-1-thread-1 Start. Command = 0
	pool-1-thread-3 Start. Command = 2
	pool-1-thread-2 Start. Command = 1
	pool-1-thread-4 Start. Command = 3
	pool-1-thread-5 Start. Command = 4
	pool-1-thread-4 End.
	pool-1-thread-5 End.
	pool-1-thread-4 Start. Command = 5
	pool-1-thread-2 End.
	pool-1-thread-3 End.
	pool-1-thread-3 Start. Command = 8
	pool-1-thread-1 End.
	pool-1-thread-1 Start. Command = 9
	pool-1-thread-2 Start. Command = 7
	pool-1-thread-5 Start. Command = 6
	pool-1-thread-4 End.
	pool-1-thread-3 End.
	pool-1-thread-2 End.
	pool-1-thread-5 End.
	pool-1-thread-1 End.
	Finished all threads
	 * 
	*/
	}

