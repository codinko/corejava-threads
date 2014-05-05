package com.codinko.threads.basic;

//@formatter:off
/**
* References:
* http://docs.oracle.com/javase/tutorial/essential/concurrency/memconsist.html
*/
public class _3MemoryConsistencyError {
  /**
	* Describes errors that result from inconsistent views of shared memory.
	* 
	* Occurs when different threads have inconsistent views of what should be the same data. 
	*
	* How to avoid?
	*  The key to avoiding memory consistency errors is understanding the 
	*  'happens-before relationship'. This relationship is simply a guarantee 
	*  that memory writes by one specific statement are visible to another specific statement.
	* 
	*  Scenario: Absence of 'happens-before relationship':
	* 
	*  counter=0;
	*  counter field is shared between two threads, A and B
	* 
	*  Thread A - { counter++; }
	*  Thread B - { print counter; }
	* 
	*  If the statements were executed by different threads A and B, then value of counter could be even 0
	*  There's no guarantee that thread A's change to counter will be visible to thread B
	* 
	*  Some of the Actions that create 'happens-before relationships'.
	*
	* 1. Synchronization
	* 2. Thread.start() - When a statement invokes Thread.start, every statement that has a 
	* 					  happens-before relationship with that statement also has a 
	* 					  happens-before relationship with every statement executed by the new thread.
	* 					  The effects of the code that led up to the creation of the new thread 
	* 					  are visible to the new thread.
	* 3. Thread.join() -  When a thread terminates and causes a Thread.join in another thread 
	* 					  to return, then all the statements executed by the terminated thread 
	* 					  have a happens-before relationship with all the statements following 
	* 					  the successful join. The effects of the code in the thread are now 
	* 					  visible to the thread that performed the join.
	* 4. java.util.concurrent package
	*
	*/
}

