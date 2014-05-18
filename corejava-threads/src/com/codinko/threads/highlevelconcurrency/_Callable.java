package com.codinko.threads.highlevelconcurrency;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The Callable interface is in java.util.concurrent package since 1.5
 * 
 * Defines a task that returns a result and may throw an exception. Implementors
 * define a single method with no arguments called call.
 * 
 * The Executors class contains utility methods to convert from other common
 * forms to Callable classes.
 * 
 */
public class _Callable {
	/**
	 * Interface Callable<V>
	 * 
	 * V - the result type of method call
	 * 
	 * V call() throws Exception
	 * 
	 * Computes a result, or throws an exception if unable to do so.
	 * 
	 * Returns: computed result
	 * 
	 * Throws: Exception - if unable to compute a result
	 * 
	 */

	Callable<String> callablee = new Callable<String>() {
		@Override
		public String call() throws Exception {
			return "";
		}
	};

	/**
	 * 
	 * (Q) Difference between the Runnable and Callable interfaces in Java ?
	 * 
	 * The Callable interface is similar to Runnable, in that both are designed
	 * for classes whose instances are potentially executed by another thread. A
	 * Runnable, however, does not return a result and cannot throw a checked
	 * exception
	 * 
	 * (Q) What is the need of having both, if Callable can do all that Runnable
	 * does ?
	 * 
	 * 
	 * Because the Runnable interface cannot do everything that Callable does!
	 * 
	 * Runnable has been around since Java 1.0, but Callable was only introduced
	 * in Java 1.5 ... to handle use-cases that Runnable does not support. In
	 * theory, the Java team could have changed the signature of the
	 * Runnable.run() method, but this would have broken binary compatibility
	 * with pre-1.5 code, requiring recoding when migrating old Java code to
	 * newer JVMs. That is a BIG NO-NO. Java strives to be backwards compatible
	 * ... and that's been one of Java's biggest selling points for business
	 * computing.
	 * 
	 */

	Runnable runnable = new Runnable() {
		public void run() {

		}
	};

	Callable<String> callable = new Callable<String>() {
		@Override
		public String call() throws Exception {
			return "";
		}
	};

	/*
	 * Example code: To pass values to be used inside Callable's call() method,
	 * you can use closures: References:
	 * http://stackoverflow.com/questions/5516383
	 * /how-to-return-object-from-callable
	 * 
	 * This example demonstrates both the use of callable [With ExecutorService
	 * submit()] and also the use of closures to pass values.
	 * 
	 * What we need is method signature : int[][] call(int[][]). If you
	 * reference the Callable javadoc you'll see that the Callable's call()
	 * method does not take any arguments. So your method is an overload, not an
	 * override, and so won't be called by anything that is calling Callable's
	 * call() method.
	 */
	public static Callable<Integer[][]> getMultiplierCallable(final int[][] xs,
			final int[][] ys, final int length) {
		return new Callable<Integer[][]>() {
			public Integer[][] call() throws Exception {
				Integer[][] answer = new Integer[length][length];
				answer = multiplyArray(xs, ys, length);
				return answer;
			}

			private Integer[][] multiplyArray(int[][] xs, int[][] ys, int length) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	public static void main(final String[] args) throws ExecutionException,
			InterruptedException {
		final int[][] xs = { { 1, 2 }, { 3, 4 } };
		final int[][] ys = { { 1, 2 }, { 3, 4 } };
		final Callable<Integer[][]> callable = getMultiplierCallable(xs, ys, 2);
		final ExecutorService service = Executors.newFixedThreadPool(2);
		final Future<Integer[][]> result = service.submit(callable);
		final Integer[][] intArray = result.get();
		for (final Integer[] element : intArray) {
			System.out.println(Arrays.toString(element));
		}
	}

}
/**
 * References: http://stackoverflow.com/questions/141284/the-difference-between
 * -the-runnable-and-callable-interfaces-in-java
 * 
 * http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Callable. html
 */
