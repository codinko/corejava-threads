package com.codinko.threads;

/**
 * 
 * Describes how errors are introduced when multiple threads access shared data.
 */

public class ThreadInterference {
	public static void main(String[] args) {
		//@formatter:off
		/**
		* The single step of c++ is decomposed into three steps by the virtual machine.
		*
		* 1. Retrieve the current value of c.
		* 2. Increment the retrieved value by 1.
		* 3. Store the incremented value back in c.
		*
		* If c is shared variable,
		* If ThreadA and ThreadB try to increment at same time, it might perhaps be like this:
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
