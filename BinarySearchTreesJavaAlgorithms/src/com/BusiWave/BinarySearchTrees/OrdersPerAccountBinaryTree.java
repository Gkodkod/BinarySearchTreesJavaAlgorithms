package com.BusiWave.BinarySearchTrees;

/**
 * @author Gal Levinshtein  BusiWave.com  Twitter: @GKodKod
 * 
 * This package demonstrates using BinarySearchTrees algorithms
 * 
 * 
 * 
 *  Could be implemented to represent any Data Structure of Objects
 */


public class OrdersPerAccountBinaryTree {

    static NodeWithName root;

    public void addNode(int key, String name) {

	if (name == null){
	    System.out.println("Adding Node to Tree with Key:" + key + " Title = " + name + " failed. Title cannot be null.");
	    return;
	}
	if (key == 0){
	    System.out.println("Adding Node to Tree with Key:" + key + " Title = " + name + " failed. Key cannot be 0.");
	    return;
	}
	
	// Create a new Node and initialize it
	NodeWithName newNode = new NodeWithName(key, name);
	System.out.println("Adding Node to Tree with Key:" + key + " \tTitle = " + name);
 
	
	// If there is no root this becomes root
	if (root == null) {
	    root = newNode;
	} else {
	    // Set root as the Node we will start
	    // with as we traverse the tree
	    Node<Integer> focusNode = root;
	    // Future parent for our new Node
	    Node<Integer> parent;

	    while (true) {
		// root is the top parent so we start
		// there
		parent = focusNode;
		// Check if the new node should go on
		// the left side of the parent node
		if (key < focusNode.getKey()) {
		    // Switch focus to the left child
		    focusNode = focusNode.left;
		    // If the left child has no children
		    if (focusNode == null) {
			// then place the new node on the left of it
			parent.left = newNode;
			return; // All Done
		    }
		} else if (key > focusNode.getKey()) { // If we get here put the node on the right
		    focusNode = focusNode.right;
		    // If the right child has no children
		    if (focusNode == null) {
			// then place the new node on the right of it
			parent.right = newNode;
			return; // All Done
		    }
		}
		else {
		    System.out.println("Adding Node to Tree with Key:" + key + " Title = " + name + " failed. Key already exists.");
		    break;
		}
	    }
	}
    }
    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth
    public void inOrderTraverseTree(Node<Integer> focusNode) {
	if (focusNode != null) {
	    // Traverse the left node
	    inOrderTraverseTree(focusNode.getLeft());
	    // Visit the currently focused on node
	    System.out.println(focusNode);
	    // Traverse the right node
	    inOrderTraverseTree(focusNode.getRight());
	}
    }

    public void preorderTraverseTree(Node<Integer> focusNode) {
	if (focusNode != null) {
	    System.out.println(focusNode);
	    preorderTraverseTree(focusNode.getLeft());
	    preorderTraverseTree(focusNode.getRight());
	}
    }

    public void postOrderTraverseTree(Node<Integer> focusNode) {
	if (focusNode != null) {
	    postOrderTraverseTree(focusNode.getLeft());
	    postOrderTraverseTree(focusNode.getRight());
	    System.out.println(focusNode);
	}
    }

    public Node<Integer> findNode(int key) {
	// Start at the top of the tree
	Node<Integer> focusNode = root;
	// While we haven't found the Node
	// keep looking
	while (focusNode.getKey() != key) {
	    // If we should search to the left
	    if (key < focusNode.getKey()) {
		// Shift the focus Node to the left child
		focusNode = focusNode.left;
	    } else {
		// Shift the focus Node to the right child
		focusNode = focusNode.right;
	    }
	    // The node wasn't found
	    if (focusNode == null)
		return null;
	}
	return focusNode;
    }

    public static void main(String[] args) {
	OrdersPerAccountBinaryTree theTree = new OrdersPerAccountBinaryTree();
	
	System.out.println("===Creating Org Chart Binary Search Tree===");
	theTree.addNode(50, "Boss");
	theTree.addNode(25, "Vice President");
	theTree.addNode(15, "Office Manager");
	theTree.addNode(30, "Secretary");
	theTree.addNode(75, "Sales Manager");
	theTree.addNode(100, "Sr. Software Engineer/AVP");
	theTree.addNode(85, "Salesman 1");
	theTree.addNode(101, "Jr. Developer");
	theTree.addNode(101, "Developer");
	theTree.addNode(99, null);
	theTree.addNode(0, "Office worker");
	
	// Different ways to traverse binary trees
	BTreePrinter.printNode(root);
        if (BalancedBinaryTree.isBalanced(root))
	    System.out.println("===Tree is balanced===");
	else
	    System.out.println("===Tree is not balanced==="); 
        
	System.out.println("\n===Binary Search Tree in-Order Traversal===");
	theTree.inOrderTraverseTree(OrdersPerAccountBinaryTree.root);
	System.out.println("\n===Binary Search Tree pre-Order Traversal===");
	theTree.preorderTraverseTree(OrdersPerAccountBinaryTree.root); 
	System.out.println("\n===Binary Search Tree post-Order Traversal===");
	theTree.postOrderTraverseTree(OrdersPerAccountBinaryTree.root);
      
	// Find the node with key 101
	System.out.println("\nFind Node in Binary Search Tree = " + theTree.findNode(100));
    }
}

