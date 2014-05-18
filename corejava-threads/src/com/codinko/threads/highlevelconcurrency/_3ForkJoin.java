package com.codinko.threads.highlevelconcurrency;

//only from JDK 7
/**
* References:
* http://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html
* 
* 
* The fork/join framework is an implementation of the ExecutorService interface
* that helps you take advantage of multiple processors. It is designed for work
* that can be broken into smaller pieces recursively. The goal is to use all
* the available processing power to enhance the performance of your
* application.
* 
* As with any ExecutorService implementation, the fork/join framework
* distributes tasks to worker threads in a thread pool. The fork/join framework
* is distinct because it uses a work-stealing algorithm. Worker threads that
* run out of things to do can steal tasks from other threads that are still
* busy.
* 
* The center of the fork/join framework is the ForkJoinPool class, an extension
* of the AbstractExecutorService class. ForkJoinPool implements the core
* work-stealing algorithm and can execute ForkJoinTask processes.
* 
* Terms: ------
* 
* ExecutorService (I); fork/join framework; worker threads in a thread pool;
* work-stealing algorithm; ForkJoinPool (C); AbstractExecutorService (C);
* ForkJoinTask processes
* 
*/
public class _3ForkJoin {
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
}

