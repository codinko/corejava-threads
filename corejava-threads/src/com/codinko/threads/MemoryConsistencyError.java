package com.codinko.threads;

//@formatter:off
/**
* References:
* http://docs.oracle.com/javase/tutorial/essential/concurrency/memconsist.html
*/
public class MemoryConsistencyError {
  /**
	* Describes errors that result from inconsistent views of shared memory.
	* 
	* Occurs when different threads have inconsistent views of what should be the same data. 
	*
	* How to avoid?
	*  Key is to understand the 'happens-before relationship'.
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
	*  Actions that create 'happens-before relationships'.
	*
	* 1. Synchronization
	* 2. Thread.start()
	* 3. Thread.join()
	* 4. java.util.concurrent package
	*
	*/
}

