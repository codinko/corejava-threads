package com.codinko.threads.mutable;

/**
 * References:
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
 * 
 * @formatter:off
 * 
 * Applying this strategy to ImmutableRGB class in
 * _1ImmutableObjects_MutableCase.java results in the following steps:
 * 
 * 1. There are two setter methods in this class. The first one, set, arbitrarily
 *  transforms the object, and has no place in an immutable version of the class.
 *  The second one, invert, can be adapted by having it create a new object
 *  instead of modifying the existing one.
 * 
 * 2. All fields are already private; they are further qualified as final.
 * 
 * 3. The class itself is declared final.
 * 
 * 4. Only one field refers to an object, and that object is itself immutable.
 *  Therefore, no safeguards against changing the state of "contained" mutable
 *  objects are necessary.
 * 
 */
//@formatter:on
public class _3ImmutableObjects_IMMutableCase {
	final public class ImmutableRGB {

		// Values must be between 0 and 255.
		final private int red;
		final private int green;
		final private int blue;
		final private String name;

		private void check(int red, int green, int blue) {
			if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0
					|| blue > 255) {
				throw new IllegalArgumentException();
			}
		}

		public ImmutableRGB(int red, int green, int blue, String name) {
			check(red, green, blue);
			this.red = red;
			this.green = green;
			this.blue = blue;
			this.name = name;
		}

		public int getRGB() {
			return ((red << 16) | (green << 8) | blue);
		}

		public String getName() {
			return name;
		}

		public ImmutableRGB invert() {
			return new ImmutableRGB(255 - red, 255 - green, 255 - blue,
					"Inverse of " + name);
		}
	}
// @formatter:off
}
