package com.codinko.threads.highlevelconcurrency;

//Covered: Future and FutureTask
/**
 * References:
 * http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Future.html
 * 
 * The Future interface is in java.util.cuncurrent package since 1.5
 * 
 * public interface Future<V>
 * 
 * A Future represents the result of an asynchronous computation. Methods are
 * provided to check if the computation is complete, to wait for its completion,
 * and to retrieve the result of the computation.
 * 
 * The result can only be retrieved using method get() when the computation has
 * completed, blocking if necessary until it is ready.
 * 
 * Cancellation is performed by the cancel() method.
 * 
 * Additional methods are provided to determine if the task completed normally
 * or was cancelled.
 * 
 * Once a computation has completed, the computation cannot be cancelled. If you
 * would like to use a Future for the sake of cancellability but not provide a
 * usable result, you can declare types of the form Future<?> and return null as
 * a result of the underlying task.
 * 
 * **METHODS**: ------------
 * 
 * boolean cancel(boolean mayInterruptIfRunning) - Attempts to cancel execution
 * of this task.
 * 
 * V get() - Waits if necessary for the computation to complete, and then
 * retrieves its result.
 * 
 * V get(long timeout, TimeUnit unit) - Waits if necessary for at most the given
 * time for the computation to complete, and then retrieves its result, if
 * available.
 * 
 * boolean isCancelled() - Returns true if this task was cancelled before it
 * completed normally.
 * 
 * boolean isDone() - Returns true if this task completed.
 * 
 */
public class _Future_FutureTask {
/**
* @formatter:off
* 
* final ExecutorService executor = Executors.newFixedThreadPool(2);
* Future<String> future
     = executor.submit(new Callable<String>() {
       public String call() {
*/


/**
* @formatter:off
* 
* A Sample Usage:
* 
*  
interface ArchiveSearcher { String search(String target); }
class App {
 ExecutorService executor = ...
 ArchiveSearcher searcher = ...
 void showSearch(final String target)
     throws InterruptedException {
   Future<String> future
     = executor.submit(new Callable<String>() {
       public String call() {
           return searcher.search(target);
       }});
   displayOtherThings(); // do other things while searching
   try {
     displayText(future.get()); // use future
   } catch (ExecutionException ex) { cleanup(); return; }
 }
}
*/
//@formatter:on
	/**
	 * The FutureTask class is an implementation of Future that implements
	 * Runnable, and so may be executed by an Executor. For example, the above
	 * construction with submit could be replaced by:
	 */
//@formatter:off
/**

FutureTask<String> future =
 new FutureTask<String>(new Callable<String>() {
   public String call() {
     return searcher.search(target);
 }});
executor.execute(future);
*/ 
//@formatter:on
	/**
	 * Memory consistency effects: Actions taken by the asynchronous computation
	 * happen-before actions following the corresponding Future.get() in another
	 * thread.
	 */
}
