package com.codinko.threads.mutable;

/**
 * References:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html
 * 
 * A Strategy for Defining Immutable Objects
 * 
 */
public class _2ImmutableCreationStrategy {
/**
 * The following rules define a simple strategy for creating immutable
 * objects. Not all classes documented as "immutable" follow these rules.
 * This does not necessarily mean the creators of these classes were sloppy �
 * they may have good reason for believing that instances of their classes
 * never change after construction. However, such strategies require
 * sophisticated analysis and are not for beginners.
 * 
 * @formatter:off
 * 
 * 1. Don't provide "setter" methods � methods that modify fields or objects
 * referred to by fields.
 * 
 * 2. Make all fields final and private.
 * 
 * 3. Don't allow subclasses to override methods. The simplest way to do this is
 * to declare the class as final. A more sophisticated approach is to make
 * the constructor private and construct instances in factory methods.
 * 
 * 4. If the instance fields include references to mutable objects, don't allow
 * those objects to be changed:
 * 
 *  a. Don't provide methods that modify the mutable objects.
 * 
 *  b. Don't share references to the mutable objects. Never store references to
 *  external, mutable objects passed to the constructor; if necessary, create
 *  copies, and store references to the copies. Similarly, create copies of
 *  your internal mutable objects when necessary to avoid returning the
 *  originals in your methods.
 * 
 */
// @formatter:on
}
