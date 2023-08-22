/*
Challenge: Inorder Traversal
Given a binary tree, write an iterative and recursive solution to traverse the tree using inorder traversal.
For traversing a (non-empty) binary tree in an inorder fashion, we must do these three things for every node n starting from the tree’s root:

(L) Recursively traverse its left subtree. When this step is finished, we are back at `n` again.
(N) Process `n` itself.
(R) Recursively traverse its right subtree. When this step is finished, we are back at `n` again.

In normal inorder traversal, we visit the left subtree before the right subtree. If we visit the right subtree before visiting the left subtree, it is referred to as reverse inorder traversal.
*/

//Data structure to store a binary tree node
class Node {
	int data;
	Node left, right;

	//Function to create a new binary tree node having a given key
	public Node(int key) {
		data = key;
		left = right = null;
	}
}

public class DFSInorder {
	//Recursive function to perform inorder traversal on the tree
	public static void inorder(Node root) {
		if(root == null) {
			return;
		}

		//Traverse the left subtree
		inorder(root.left);

		//Display the data part of the root or current node
		System.out.print(root.data + " ");

		//Traverse the right subtree
		inorder(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);
		inorder(root);
	}
}