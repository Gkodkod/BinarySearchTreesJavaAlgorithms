package com.BusiWave.BinarySearchTrees;
 
/**
 * @author Gal Levinshtein  BusiWave.com  Twitter: @GKodKod
 * 
 * This package demonstrates using BinarySearchTrees algorithms
 * 
 *  Determines if binary tree is height balanced
 */


class BalancedBinaryTree {

    static Node<Integer> root;

    /* Returns true if binary tree with root as root is height-balanced */
    public static boolean isBalanced(Node<Integer> node) {
	int lh; /* for height of left subtree */

	int rh; /* for height of right subtree */

	/* If tree is empty then return true */
	if (node == null) {
	    return true;
	}

	/* Get the height of left and right sub trees */
	lh = height(node.left);
	rh = height(node.right);

	if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
	    return true;
	}

	/* If we reach here then tree is not height-balanced */
	return false;
    }

    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /* returns maximum of two integers */
    public static int max(int a, int b) {
	return (a >= b) ? a : b;
    }

    /*
     * The function Compute the "height" of a tree. Height is the number of
     * nodes along the longest path from the root node down to the farthest leaf
     * node.
     */
    public static int height(Node<Integer> node) {

	/* base case tree is empty */
	if (node == null) {
	    return 0;
	}

	/*
	 * If tree is not empty then height = 1 + max of left height and right
	 * heights
	 */
	return 1 + max(height(node.left), height(node.right));
    }

    public static void main(String args[]) {
	BalancedBinaryTree tree = new BalancedBinaryTree();
	tree.root = new Node<Integer>(1);
	tree.root.left = new Node<Integer>(2);
	tree.root.right = new Node<Integer>(3);
	tree.root.left.left = new Node<Integer>(4);
	tree.root.left.right = new Node<Integer>(5);
	tree.root.left.left.left = new Node<Integer>(8);

	BTreePrinter.printNode(root);
	
	if (tree.isBalanced(root))
	    System.out.println("Tree is balanced");
	else
	    System.out.println("Tree is not balanced");
    }
}