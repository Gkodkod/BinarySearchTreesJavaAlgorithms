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

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

import com.BusiWave.ChallengingHacks.Prime;

public class FilterIteratorTest {

    @Test
    public void filterPrimes() {
	List<Object> primeNumbersList = new LinkedList<Object>(); 
	for (int i = 1; i <= 10; i++) {
	    if (Prime.isPrimeNumber(i)) {
		primeNumbersList.add(i);
	    }
	}
	IObjectTest primesOnly = new IObjectTest() {
	    @Override
	    public boolean test(Object o) {
		return (Prime.isPrimeNumber((Integer)o));
	    }
	};
	Iterator<Object> odds = new FilteringIterator(primeNumbersList.iterator(), primesOnly);
	assertEquals(2, odds.next());
	assertEquals(3, odds.next());
	assertEquals(5, odds.next());
	assertEquals(7, odds.next());
	assertFalse(odds.hasNext());
    }

    @Test
    public void filtersOdds() {
	List<Object> numbers = Arrays.<Object> asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	IObjectTest oddsOnly = new IObjectTest() {
	    @Override
	    public boolean test(Object o) {
		return ((Integer) o) % 2 != 0;
	    }
	};
	Iterator<Object> odds = new FilteringIterator(numbers.iterator(), oddsOnly);
	assertEquals(1, odds.next());
	assertEquals(3, odds.next());
	assertEquals(5, odds.next());
	assertEquals(7, odds.next());
	assertEquals(9, odds.next());
	assertFalse(odds.hasNext());
    }

    @Test
    // This test will fail
    public void filtersEvens() {
	List<Object> numbers = Arrays.<Object> asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	IObjectTest EvensOnly = new IObjectTest() {
	    @Override
	    public boolean test(Object o) {
		return ((Integer) o) % 2 == 0;
	    }
	};
	Iterator<Object> evens = new FilteringIterator(numbers.iterator(), EvensOnly);
	assertEquals(2, evens.next());
	assertEquals(4, evens.next());
	assertEquals(6, evens.next());
	assertEquals(8, evens.next());
	assertEquals(7, evens.next());
	assertFalse(evens.hasNext());
    }

    @Test
    // This test will fail
    public void filtersEvens2() {
	List<Object> numbers = Arrays.<Object> asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	IObjectTest EvensOnly = new IObjectTest() {
	    @Override
	    public boolean test(Object o) {
		return ((Integer) o) % 2 == 0;
	    }
	};
	Iterator<Object> evens = new FilteringIterator(numbers.iterator(), EvensOnly);
	assertEquals(2, evens.next());
	assertEquals(3, evens.next());
	assertEquals(6, evens.next());
	assertEquals(8, evens.next());
	assertEquals(10, evens.next());
	assertFalse(evens.hasNext());
    }
}
