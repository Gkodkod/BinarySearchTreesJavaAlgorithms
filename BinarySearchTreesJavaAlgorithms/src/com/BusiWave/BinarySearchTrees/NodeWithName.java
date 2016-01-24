package com.BusiWave.BinarySearchTrees;

/**
 * @author Gal Levinshtein  BusiWave.com  Twitter: @GKodKod
 * 
 * This package demonstrates using BinarySearchTrees algorithms
 * 
 * Generic Node for Binary Search Tree 
 * 	using Integer as Keys
 * 	and a String for Titles 
 * 
 *  Could be implemented to represent any Data Structure of Objects
 */
class NodeWithName extends Node <Integer>{

    String name;

    NodeWithName(int key, String name) {
	super(key);
	this.name = name;
    }

    public String toString() {
	return "key:" + key + " \t\tTitle = " + name;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the left
     */
    public Node<Integer> getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public Node<Integer> getRight() {
        return right;
    }
    

/*    public String getChildren() {
	 return "\tLeft Child: " + getLeft() + "Right Child: " + getRight();
    }*/
    
    public int compareTo(Node<Integer> o) {
        
	if (this.key < o.key)
	    return -1;
	else if (this.key > o.key)
	    return 1;
	else
	    return 0;
    }

}