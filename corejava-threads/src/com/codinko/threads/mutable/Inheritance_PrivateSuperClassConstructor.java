package com.codinko.threads.mutable;

/*
 * Compilation error on trying to extend the class - SuperClass
 */
public class Inheritance_PrivateSuperClassConstructor extends SuperClass {

}

class SuperClass {

	private static SuperClass instance = new SuperClass();

	private SuperClass() {

	}

	public static SuperClass getInstance() {
		return instance;
	}

	public void method1(String name) {
		System.out.println("1" + name);
	}
}

/**
 * ERROR:
 * 
 * "Implicit super constructor SuperClass() is not visible for default
 * constructor. Must define an explicit constructor"
 * 
 * Why we did it?
 * 
 * We infact make the constructor private to avoid inheritance, ie when we do
 * not want the methods to be overridden by any subclass [one of the strategy
 * for immutable object creation]
 * 
 * Hope you understand why are we getting the compilation error?
 * 
 * Well explained in error description. There is a default constructor
 * SubClass(). By default this calls super(), and it cannot see the default
 * constructor of SuperClass as it is private, and hence the error.
 * 
 */

