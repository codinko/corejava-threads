package com.codinko.threads.highlevelconcurrency;

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
//@formatter:off
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
*The optional capacity bound constructor argument serves as a
* way to prevent excessive queue expansion. The capacity, if unspecified,
* is equal to {@link Integer#MAX_VALUE}.
* 
*/   
//@formatter:on
/*
 * Executors class provide simple implementation of ExecutorService using
 * ThreadPoolExecutor;
 * 
 * But ThreadPoolExecutor provides much more feature than that.
 * 
 * We can specify the number of threads that will be alive when we create
 * ThreadPoolExecutor instance and,
 * 
 * we can limit the size of thread pool and create our own
 * RejectedExecutionHandler implementation to handle the jobs that can’t fit in
 * the worker queue.
 */

