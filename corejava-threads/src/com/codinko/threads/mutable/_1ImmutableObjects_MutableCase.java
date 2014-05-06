package com.codinko.threads.mutable;

//References: http://docs.oracle.com/javase/tutorial/essential/concurrency/syncrgb.html
/**
 * 
 * An object is considered immutable if its state cannot change after it is
 * constructed. Maximum reliance on immutable objects is widely accepted as a
 * sound strategy for creating simple, reliable code.
 * 
 * Immutable objects are particularly useful in concurrent applications. Since
 * they cannot change state, they cannot be corrupted by thread interference or
 * observed in an inconsistent state.
 * 
 * Programmers are often reluctant to employ immutable objects, because they
 * worry about the cost of creating a new object as opposed to updating an
 * object in place. The impact of object creation is often overestimated, and
 * can be offset by some of the efficiencies associated with immutable objects.
 * These include decreased overhead due to garbage collection, and the
 * elimination of code needed to protect mutable objects from corruption.
 */
//@formatter:off
/** Efficiencies associated with immutable objects:
*  -> Decreased overhead due to garbage collection.
*  -> Elimination of code needed to protect mutable objects from corruption.
*  -> Useful in concurrent applications. Since they cannot change state, 
*   they cannot be corrupted by thread interference or observed in an 
*    inconsistent state.
*  
* Cons: Cost of creating a new object is much more.
* @formatter:on
* 
* The following subsections take a class whose instances are mutable and
* derives a class with immutable instances from it. In so doing, they give
* general rules for this kind of conversion and demonstrate some of the
* advantages of immutable objects.
* 
* The class, SynchronizedRGB, defines objects that represent colors. Each
* object represents the color as three integers that stand for primary color
* values and a string that gives the name of the color.
* 
*/
public class _1ImmutableObjects_MutableCase {

	class SynchronizedRGB {

		// Values must be between 0 and 255.
		private int red;
		private int green;
		private int blue;
		private String name;

		private void check(int red, int green, int blue) {
			if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0
					|| blue > 255) {
				throw new IllegalArgumentException();
			}
		}

		public SynchronizedRGB(int red, int green, int blue, String name) {
			check(red, green, blue);
			this.red = red;
			this.green = green;
			this.blue = blue;
			this.name = name;
		}

		public void set(int red, int green, int blue, String name) {
			check(red, green, blue);
			synchronized (this) {
				this.red = red;
				this.green = green;
				this.blue = blue;
				this.name = name;
			}
		}

		public synchronized int getRGB() {
			return ((red << 16) | (green << 8) | blue);
		}

		public synchronized String getName() {
			return name;
		}

		public synchronized void invert() {
			red = 255 - red;
			green = 255 - green;
			blue = 255 - blue;
			name = "Inverse of " + name;
		}
	}

	/**
	 * SynchronizedRGB must be used carefully to avoid being seen in an
	 * inconsistent state. Suppose, for example, a thread executes the following
	 * code:
	 */

/*
* @formatter:off

SynchronizedRGB color = new SynchronizedRGB(0, 0, 0, "Pitch Black");
...
int myColorInt = color.getRGB();      //Statement 1
String myColorName = color.getName(); //Statement 2
*/
//@formatter:on
	/**
	 * If another thread invokes color.set after Statement 1 but before
	 * Statement 2, the value of myColorInt won't match the value of
	 * myColorName. To avoid this outcome, the two statements must be bound
	 * together:
	 */

	// IMPORTANT: This also tell us that calling statements also need to be
	// synchronized to preserve the intention

/*
* @formatter:off 
 synchronized (color) { 
 int myColorInt = color.getRGB();
 String myColorName = color.getName();
 } 
*/
/**
* @formatter:on
* This kind of inconsistency is only possible for mutable objects — it will
* not be an issue for the immutable version of SynchronizedRGB.
* */

}
