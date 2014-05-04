package com.codinko.threads;

/**
 * References:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html
 * 
 * Describes how errors are introduced when multiple threads access shared data.
 * 
 * Interference happens when two operations, running in different threads, but
 * acting on the same data, interleave
 * 
 */

public class ThreadInterference {
	public static void main(String[] args) {

		/**
		 * Counter (below class) is designed so that each invocation of
		 * increment will add 1 to c, and each invocation of decrement will
		 * subtract 1 from c. However, if a Counter object is referenced from
		 * multiple threads, interference between threads may prevent this from
		 * happening as expected.
		 * 
		 * Interference happens when two operations, running in different
		 * threads, but acting on the same data, interleave. This means that the
		 * two operations consist of multiple steps, and the sequences of steps
		 * overlap.
		 */
		//@formatter:off
		/**
		* The single step of c++ is decomposed into three steps by the virtual machine.
		*
		* 1. Retrieve the current value of c.
		* 2. Increment the retrieved value by 1.
		* 3. Store the incremented value back in c.
		*
		* If c is shared variable,
		* Suppose Thread A invokes increment at about the same time 
		* Thread B invokes decrement. If the initial value of c is 0, 
		* their interleaved actions might follow this sequence:
		*
		* Thread A: Retrieve c.
		* Thread B: Retrieve c.
		* Thread A: Increment retrieved value; result is 1.
		* Thread B: Decrement retrieved value; result is -1.
		* Thread A: Store result in c; c is now 1.
		* Thread B: Store result in c; c is now -1.
		*
		* This is Thread interference. Here Thread A's result is lost as it is overwritten by Thread B.
		* It can be in other way around or , no error at all, quite unpredictable.
		*
		*/
		       }
		}
		class Counter {
		       private int c = 0;
		 
		       public void increment() {
		              c++;
		       }
		 
		       public void decrement() {
		              c--;
		       }
		 
		       public int value() {
		              return c;
		       }
		}
