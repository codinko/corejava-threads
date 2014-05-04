package com.codinko.threads;

/**
 * Reference:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
 */

//Two important points covered here: exclusive access; happens-before relationship

/**
 * Intrinsic Locks [MonitorLock/Monitor] and Synchronization
 * 
 * Synchronization is built around an internal entity known as the intrinsic
 * lock or monitor lock. (The API specification often refers to this entity
 * simply as a "monitor.") Intrinsic locks play a role in both aspects of
 * synchronization: enforcing exclusive access to an object's state and
 * establishing happens-before relationships that are essential to visibility.
 * 
 * Every object has an intrinsic lock associated with it. By convention, a
 * thread that needs exclusive and consistent access to an object's fields has
 * to acquire the object's intrinsic lock before accessing them, and then
 * release the intrinsic lock when it's done with them.
 * 
 * A thread is said to own the intrinsic lock between the time it has acquired
 * the lock and released the lock. As long as a thread owns an intrinsic lock,
 * no other thread can acquire the same lock. The other thread will block when
 * it attempts to acquire the lock.
 * 
 * When a thread releases an intrinsic lock, a "happens-before relationship" is
 * established between that action and any subsequent acquisition of the same
 * lock
 * 
 */
//@formatter:off
public class _6IntrinsicLock {
       /**
        * Every object has an intrinsic lock associated with it
        *
        * Synchronization is built around an internal entity known as the intrinsic
        * lock
        *
        * Synchronization has 2 aspects
        *     Exclusive access to an object's state
        *     Establishing happens-before relationships that are essential to visibility
        *
        * Intrinsic locks play a role in both of these aspects of Synchronization to enforce them
        *
        * Lock in Synchronized Methods :
        *     When a thread invokes a synchronized method, it automatically acquires the
        *    intrinsic lock for that method's object and releases it when the method returns.
        *    The lock release occurs even if the return was caused by an uncaught exception.
        *   
        *  NOTE: When a static synchronized method is invoked, [ we know that a static method is
        *  associated with a class, not an object], In this case, the thread acquires
        *  the intrinsic lock for the Class object associated with the class.
        *  Thus access to class's static fields is controlled by a lock that's
        *  distinct from the lock for any instance of the class.
        * 
        *  [TODO: Test this]
        *  This also would mean that when one thread access the static synchronized method, another
        *  thread can access a non-static synchronized method of an object of the class, as these
        *  are two different locks.
        *
        */
}
 

