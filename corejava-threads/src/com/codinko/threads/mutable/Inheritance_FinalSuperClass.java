package com.codinko.threads.mutable;

/*
 * Compilation error on trying to extend the class - MySuperClass
 */
public class Inheritance_FinalSuperClass extends MySuperClass {

}

final class MySuperClass {

	MySuperClass() {

	}

	public void method1(String name) {
		System.out.println("1" + name);
	}
}

/**
 * ERROR:
 * 
 * "The type Inheritance_FinalSuperClass cannot subclass the final class MySuperClass"
 * 
 * Why we did it?
 * 
 * We infact make the class final to avoid inheritance, ie when we do not want
 * the methods to be overridden by any subclass [one of the strategy for
 * immutable object creation]
 * 
 */
