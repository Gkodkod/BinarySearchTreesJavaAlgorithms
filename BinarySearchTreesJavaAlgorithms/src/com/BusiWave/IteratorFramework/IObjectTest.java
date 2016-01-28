package com.BusiWave.IteratorFramework;

/**
 * @author Gal Levinshtein  BusiWave.com  Twitter: @GKodKod
 * @version 1.01
 * 
 * An implementation of Iterator (let's call it FilteringIterator) which is initialized with another Iterator and 
 * an IObjectTest instance: new FilteringIterator(myIterator, myTest). 
 * 
 * Your FilteringIterator will then allow iteration over 'myIterator', but skipping any objects which don't pass 
 * the 'myTest' test. Create a simple unit test for this framework.
 * 
 * jUnit Testing
 * 
 */

public interface IObjectTest {
    boolean test(Object o);
}