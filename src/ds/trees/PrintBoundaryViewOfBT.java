
package ds.trees;
//Java program to print boundary traversal of binary tree


public class PrintBoundaryViewOfBT {

	static Node root;

	// A simple function to print leaf nodes of a binary tree
	void printLeaves(Node node) {
		if (node != null) {
			printLeaves(node.left);

			// Print it if it is a leaf node
			if (node.left == null && node.right == null) {
				System.out.print(node.data + " ");
			}

			printLeaves(node.right);
		}
	}

	// A function to print all left boundry nodes, except a leaf node.
	// Print the nodes in TOP DOWN manner
	void printBoundaryLeft(Node node) {
		if (node != null) {
			if (node.left != null) {
				
				// to ensure top down order, print the node
				// before calling itself for left subtree
				System.out.print(node.data + " ");
				printBoundaryLeft(node.left);
			} else if (node.right != null) {
				System.out.print(node.data + " ");
				printBoundaryLeft(node.right);
			}

			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

	// A function to print all right boundry nodes, except a leaf node
	// Print the nodes in BOTTOM UP manner
	void printBoundaryRight(Node node) {
		if (node != null) {
			if (node.right != null) {

				// to ensure bottom up order, first call for right
				// subtree, then print this node
				printBoundaryRight(node.right);
				System.out.print(node.data + " ");
			} else if (node.left != null) {
				printBoundaryRight(node.left);
				System.out.print(node.data + " ");
			}

			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

	// A function to do boundary traversal of a given binary tree
	void printBoundary(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");

			// Print the left boundary in top-down manner.
			printBoundaryLeft(node.left);

			// Print all leaf nodes
			printLeaves(node.left);
			printLeaves(node.right);

			// Print the right boundary in bottom-up manner
			printBoundaryRight(node.right);
		}
	}
	
	// driver program to test above functions
	public static void main(String args[]) {
		PrintBoundaryViewOfBT tree = new PrintBoundaryViewOfBT();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);
		tree.root.right.right = new Node(25);
		tree.printBoundary(root);
		/*
		 * 			20
		 * 		8			22
		 * 4		12			25
		 * 		10		14
		 */

	}
	
	
// A binary tree node
static class Node {

	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}
}
