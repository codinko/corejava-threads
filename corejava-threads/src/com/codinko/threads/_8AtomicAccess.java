package com.codinko.threads;

//Atomic access; volatile keyword [establishing a 'happens-before relationship']
/**
 * references:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/atomic.html
 * 
 * What is atomic action?
 * 
 * An atomic action cannot stop in the middle: it either happens completely, or
 * it doesn't happen at all. No side effects of an atomic action are visible
 * until the action is complete.
 * 
 * Who is not atomic?
 * 
 * An increment expression, such as c++, does not describe an atomic action. It
 * is in-fact three actions [retrieve c, increment, store result in c]
 * 
 * Who is atomic?
 * 
 * Reads and writes are atomic for reference variables and for most primitive
 * variables (all types except long and double).
 * 
 * Reads and writes are atomic for all variables declared volatile (including
 * long and double variables).
 * 
 * Is Atomic action thread-safe?
 * 
 * Atomic actions cannot be interleaved, so they can be used without fear of
 * thread interference
 * 
 * But, memory consistency errors are still possible!!
 * 
 * How to save atomic action from risk of memory consistency errors?
 * 
 * IMPORTANT: Using volatile variables reduces the risk of memory consistency
 * errors, because any write to a volatile variable establishes a happens-before
 * relationship with subsequent reads of that same variable.
 * 
 * This means that changes to a volatile variable are always visible to other
 * threads. What's more, it also means that when a thread reads a volatile
 * variable, it sees not just the latest change to the volatile, but also the
 * side effects of the code that led up the change.
 * 
 * Extra note for me?
 * 
 * Using simple atomic variable access is more efficient than accessing these
 * variables through synchronized code, but requires more care by the programmer
 * to avoid memory consistency errors. Whether the extra effort is worthwhile
 * depends on the size and complexity of the application.
 * 
 * Atomic methods, that don't rely on Synchronization?
 * 
 * Some of the classes in the java.util.concurrent package provide atomic
 * methods that do not rely on synchronization. hmmmm.. Reference:
 * http://docs.oracle
 * .com/javase/8/docs/api/java/util/concurrent/package-summary.html High Level
 * Concurrency objects :
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/highlevel.html
 * 
 */
public class _8AtomicAccess {
	/**
	 * @formatter:off Last question - you said volatile reference variable
	 *                reduces the risk of memory consistency errors, and also
	 *                they are already free from thread interference. This is
	 *                exactly what synchronization offers. So Are Volatile
	 *                variables same as using 'synchronized' ?
	 * 
	 * @formatter:on Answer: NO. Volatile means the variable is not cached in
	 *               any per-thread cache, and its value is always retrieved
	 *               from main memory when needed. Synchronization means that
	 *               those per-thread caches will be kept in sync at certain
	 *               points. In theory, using a volatile variable can come with
	 *               a great speed penalty if many threads need to read the
	 *               value of the variable, but it is changed only rarely [or,
	 *               should be used only for such a situation(s)]
	 * 
	 *               There is one more example that shows the power of using
	 *               volatile reference variable. Refer example
	 *               ThreadVolatileVariable.java in my examples. //TODO
	 * 
	 */
}
