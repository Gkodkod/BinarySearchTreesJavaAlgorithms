package com.BusiWave.BinarySearchTrees;
/**
 * @author Gal Levinshtein  BusiWave.com  Twitter: @GKodKod
 * 
 * This package demonstrates using BinarySearchTrees algorithms
 * Class for representing a Node with at most 2 children nodes 
 * Left could be used for less than
 * Right for greater than
 * 
 */

//A binary tree node
class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T key;
    
    public Node() {
        super();
    }    
    
    public Node(T key) {
        this.key = key;
    }

    /**
     * @return the key
     */
    public T getKey() {
        return key;
    }

    /**
     * @return the left
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public Node<T> getRight() {
        return right;
    }


    
}