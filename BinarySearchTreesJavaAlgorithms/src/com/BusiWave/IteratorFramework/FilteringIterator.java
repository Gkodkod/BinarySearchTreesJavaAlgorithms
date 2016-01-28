package com.BusiWave.IteratorFramework;

import java.util.Iterator;

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
 */

public class FilteringIterator implements Iterator<Object> {
    private final Iterator<Object> myIterator;
    private final IObjectTest myTest;
    private Object next;

    FilteringIterator(Iterator<Object> myIterator, IObjectTest myTest) {
        this.myIterator = myIterator;
        this.myTest = myTest;
    }

    @Override
    public boolean hasNext() {
        while (next == null && myIterator.hasNext()) {
            next = myIterator.next();
            if (myTest.test(next))
                return true;
            next = null;
        }
        return next != null;
    }

    @Override
    public Object next() {
        if (next == null)
            hasNext();
        try {
            return next;
        } finally {
            next = null;
            hasNext();
        }
    }

    @Override
    public void remove() {
        myIterator.remove();
    }
}