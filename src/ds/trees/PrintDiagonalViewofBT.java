package ds.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* https://www.techiedelight.com/print-diagonal-traversal-binary-tree/
*/
// A class to store a binary tree node
class Node
{
	int data;
	Node left = null, right = null;

	Node(int data) {
		this.data = data;
	}
}

class Main
{
	// Recursive function to perform preorder traversal on the tree and
	// fill the map with diagonal elements
	public static void printDiagonal(Node node, int diagonal,
									Map<Integer, List<Integer>> map)
	{
		// base case: empty tree
		if (node == null) {
			return;
		}

		// insert the current node into the current diagonal
		map.putIfAbsent(diagonal, new ArrayList<>());
		map.get(diagonal).add(node.data);

		// recur for the left subtree by increasing diagonal by 1
		printDiagonal(node.left, diagonal + 1, map);

		// recur for the right subtree with the same diagonal
		printDiagonal(node.right, diagonal, map);
	}

	// Function to print the diagonal elements of a given binary tree
	public static void printDiagonal(Node root)
	{
		// create an empty multimap to store the diagonal element in every slope
		Map<Integer, List<Integer>> map = new HashMap<>();

		// perform preorder traversal on the tree and fill the map
		printDiagonal(root, 0, map);

		// traverse the map and print the diagonal elements
		for (int i = 0; i < map.size(); i++) {
			System.out.println(map.get(i));
		}
	}

	public static void main(String[] args)
	{
		/* Construct the following tree
				  1
				/   \
			   /     \
			  2       3
			 /      /  \
			/      /    \
		   4      5      6
				 / \
				/   \
			   7     8
		*/

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		printDiagonal(root);
	}
}
