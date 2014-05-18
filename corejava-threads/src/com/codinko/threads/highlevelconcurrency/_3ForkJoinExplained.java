package com.codinko.threads.highlevelconcurrency;

//only from JDK 7 
public class _3ForkJoinExplained {

	/**
	 * References:
	 * http://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html
	 * 
	 * 
	 * The fork/join framework is an implementation of the ExecutorService
	 * interface that helps you take advantage of multiple processors. It is
	 * designed for work that can be broken into smaller pieces recursively. The
	 * goal is to use all the available processing power to enhance the
	 * performance of your application.
	 * 
	 * As with any ExecutorService implementation, the fork/join framework
	 * distributes tasks to worker threads in a thread pool. The fork/join
	 * framework is distinct because it uses a work-stealing algorithm. Worker
	 * threads that run out of things to do can steal tasks from other threads
	 * that are still busy.
	 * 
	 * The center of the fork/join framework is the ForkJoinPool class, an
	 * extension of the AbstractExecutorService class. ForkJoinPool implements
	 * the core work-stealing algorithm and can execute ForkJoinTask processes.
	 * 
	 * Terms: ------
	 * 
	 * ExecutorService (I); fork/join framework; worker threads in a thread pool;
	 * work-stealing algorithm; ForkJoinPool (C); AbstractExecutorService (C);
	 * ForkJoinTask processes
	 * 
	 */

	/**
	 * The first step for using the fork/join framework is to write code that
	 * performs a segment of the work. Your code should look similar to the
	 * following pseudocode:
	 */
	//@formatter:off
	/* 
	if (my portion of the work is small enough)
	   do the work directly
	else
	   split my work into two pieces
	   invoke the two pieces and wait for the results
	*/
	//@formatter:on
	/**
	 * Wrap this code in a ForkJoinTask subclass, typically using one of its more
	 * specialized types, either RecursiveTask (which can return a result) or
	 * RecursiveAction.
	 * 
	 * After your ForkJoinTask subclass is ready, create the object that
	 * represents all the work to be done and pass it to the invoke() method of a
	 * ForkJoinPool instance.
	 */

	/**
	 * 
	 * To help you understand how the fork/join framework works, consider the
	 * following example. Suppose that you want to blur an image. The original
	 * source image is represented by an array of integers, where each integer
	 * contains the color values for a single pixel. The blurred destination
	 * image is also represented by an integer array with the same size as the
	 * source.
	 * 
	 * Performing the blur is accomplished by working through the source array
	 * one pixel at a time. Each pixel is averaged with its surrounding pixels
	 * (the red, green, and blue components are averaged), and the result is
	 * placed in the destination array. Since an image is a large array, this
	 * process can take a long time. You can take advantage of concurrent
	 * processing on multiprocessor systems by implementing the algorithm using
	 * the fork/join framework. Here is one possible implementation:
	 * 
	 */
	class RecursiveAction {// to cover the compilation error
		}
 class ForkBlur extends RecursiveAction {
	int[] mSource;
	private int mStart;
	private int mLength;
	private int[] mDestination;

	// Processing window size; should be odd.
	private int mBlurWidth = 15;

	public ForkBlur(int[] src, int start, int length, int[] dst) {
	mSource = src;
	mStart = start;
	mLength = length;
	mDestination = dst;
	}

	protected void computeDirectly() {
	int sidePixels = (mBlurWidth - 1) / 2;
	for (int index = mStart; index < mStart + mLength; index++) {
	// Calculate average.
	float rt = 0, gt = 0, bt = 0;
	for (int mi = -sidePixels; mi <= sidePixels; mi++) {
	int mindex = Math.min(Math.max(mi + index, 0), mSource.length - 1);
	int pixel = mSource[mindex];
	rt += (float) ((pixel & 0x00ff0000) >> 16) / mBlurWidth;
	gt += (float) ((pixel & 0x0000ff00) >> 8) / mBlurWidth;
	bt += (float) ((pixel & 0x000000ff) >> 0) / mBlurWidth;
	}

	// Reassemble destination pixel.
	int dpixel = (0xff000000) | (((int) rt) << 16) | (((int) gt) << 8)
	| (((int) bt) << 0);
	mDestination[index] = dpixel;
	}
	}

	// ....

	/**
	 * Now you implement the abstract compute() method, which either performs
	 * the blur directly or splits it into two smaller tasks. A simple array
	 * length threshold helps determine whether the work is performed or
	 * split.
	 */
	//@formatter:off
	//declared final only to cover the compilation error
	protected static final int sThreshold = 100000;

	protected void compute() {
	    if (mLength < sThreshold) {
	        computeDirectly();
	        return;
	    }
	    
	    int split = mLength / 2;
	    
	    invokeAll(new ForkBlur(mSource, mStart, split, mDestination),
	              new ForkBlur(mSource, mStart + split, mLength - split,
	                           mDestination));
	}

	private void invokeAll(ForkBlur forkBlur, ForkBlur forkBlur2) {
		// to cover the compilation error
		
	}
	//@formatter:on
	/**
	 * If the previous methods are in a subclass of the RecursiveAction class,
	 * then setting up the task to run in a ForkJoinPool is straightforward,
	 * and involves the following steps:
	 */
	/**
	 * putting it together:
	 * 
	 * Wrap this code in a ForkJoinTask subclass, typically using one of its
	 * more specialized types, either RecursiveTask (which can return a
	 * result) or RecursiveAction.
	 * 
	 * After your ForkJoinTask subclass is ready, create the object that
	 * represents all the work to be done and pass it to the invoke() method
	 * of a ForkJoinPool instance.
	 */

	//@formatter:off
	/**
	 * STEPS:
	 * 
	 * Create a task that represents all of the work to be done.
	 * 
	 *  // source image pixels are in src
	 *  // destination image pixels are in dst
	 *  ForkBlur fb = new ForkBlur(src, 0, src.length, dst);
	 * 
	 * Create the ForkJoinPool that will run the task.
	 *  
	 *  ForkJoinPool pool = new ForkJoinPool();
	 * 
	 * Run the task.
	 * 
	 *  pool.invoke(fb);
	 * 
	 */
	//@formatter:on 
	}

	}

