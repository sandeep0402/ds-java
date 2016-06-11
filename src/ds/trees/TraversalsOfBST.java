package ds.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraversalsOfBST {
	Node root;

	public TraversalsOfBST() {
		root = null;
	}

	public Node createTree() {
		if (root == null) {
			root = new Node(12);
		}
		root.setLeftChild(new Node(23));
		root.setRightChild(new Node(18));
		root.getLeftChild().setLeftChild(new Node(11));
		root.getLeftChild().setRightChild(new Node(43));
		root.getRightChild().setLeftChild(new Node(19));
		root.getRightChild().setRightChild(new Node(50));

		/*
		 * 			  12 
		 * 			/ 	 \ 
		 * 		   23     18 
		 * 		  / \     / \
		 * 		11   43  19	 50
		 */
		return root;
	}

	/*
	 * preOrder traversal - Recursive version Root, Left, Right
	 */
	public void preorderTraversal(Node root, StringBuffer sbr) {
		if (root == null)
			return;
		/* Append node data in string buffer */
		processNode(root, sbr);
		preorderTraversal(root.getLeftChild(), sbr);
		preorderTraversal(root.getRightChild(), sbr);
	}

	/*
	 * inOrder traversal - Recursive version Left, Root, Right
	 */
	public void inorderTraversal(Node root, StringBuffer sbr) {
		if (root == null)
			return;
		inorderTraversal(root.getLeftChild(), sbr);
		processNode(root, sbr);
		inorderTraversal(root.getRightChild(), sbr);
	}

	/*
	 * postOrder traversal - Recursive version Left, Right, Root
	 */
	public void postorderTraversal(Node root, StringBuffer sbr) {
		if (root == null)
			return;
		postorderTraversal(root.getLeftChild(), sbr);
		postorderTraversal(root.getRightChild(), sbr);
		processNode(root, sbr);
	}

	/*
	 * Level order traversal - Recursive version Root, 
	 * Root's Children from Left to Right, 
	 * Root's Children's Children from Left to Right 
	 * and so on
	 */
	public void levelOrderBottomToTopTraversal(Node root, StringBuffer sbr) {
		if (root == null)
			return;
		LinkedList<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		LinkedList<Node> queueOrder = new LinkedList<Node>();

		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			stack.push(node);
			queueOrder.add(node);

			if (node.getLeftChild() != null)
				queue.add(node.getLeftChild());
			if (node.getRightChild() != null)
				queue.add(node.getRightChild());
		}
		while (!stack.isEmpty()) {
			processNode(stack.pop(), sbr);
		}
	}

	/*
	 * Given a binary tree. Print its nodes in level order using array for
	 * implementing queue
	 */
	void levelOrderTopToBottomTraversal(Node root, StringBuffer sbr) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			processNode(node, sbr);

			/* Enqueue left child */
			if (node.getLeftChild() != null)
				queue.add(node.getLeftChild());

			/* Enqueue right child */
			if (node.getRightChild() != null)
				queue.add(node.getRightChild());

		}
	}

	/*
	 * Zigzag or Spiral Traversal
	 * Algorithm
	 * 1.  Take 2 Stack, one for current level and one for next level.
	 * 2.  For filling the next Level stack, we have to see whether it need to be filled Left to Right or Right
	 * to left as we are reading the Level Order spirally.
	 * 3.  When we are reading current level stack, all the children's of current level stack will go to next level stack.
	 * 4.  When current level stack has no value and is Empty at that time point current level stack
	 * reference to hold next level stack values, that is current level stack will now point to next level
     * stack and next level stack should be reinitialize for its next level.
     * Also, this is the time when we need to alter our reading style for childrens that is it need to be
     * read in left - right fashion.
	 */
	private void zigZagTraverse(Node rootNode, StringBuffer sbr) {
		if (rootNode == null) {
			return;
		}
		Stack<Node> currentLevelStack = new Stack<Node>();
		Stack<Node> nextLevelStack = new Stack<Node>();

		boolean isLeftRightReading = true;
		currentLevelStack.add(rootNode);

		while (!currentLevelStack.isEmpty()) {
			Node node = currentLevelStack.pop();
			processNode(node, sbr);

			if (isLeftRightReading) {
				if (node.getLeftChild() != null)
					nextLevelStack.push(node.getLeftChild());
				if (node.getRightChild() != null)
					nextLevelStack.push(node.getRightChild());
			} else {
				if (node.getRightChild() != null)
					nextLevelStack.push(node.getRightChild());
				if (node.getLeftChild() != null)
					nextLevelStack.push(node.getLeftChild());
			}
			if (currentLevelStack.isEmpty()) {
				isLeftRightReading = !isLeftRightReading;
				currentLevelStack = nextLevelStack;
				nextLevelStack = new Stack<Node>();
			}
		}
	}

	 /* Given a binary tree, print its nodes in reverse level order */
    void reverseLevelOrder(Node node, StringBuffer sbr) {
        Stack<Node> stack = new Stack<Node>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
 
        // Do something like normal level order traversal order. Following are the
        // differences with normal level order traversal
        // 1) Instead of printing a node, we push the node to stack
        // 2) Right subtree is visited before left subtree
        while (queue.isEmpty() == false) {
             
            /* Dequeue node and make it root */
            node = queue.poll();
            stack.push(node);
 
            /* Enqueue right child */
            if (node.getRightChild() != null) {
                queue.add(node.getRightChild()); // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
            }
            /* Enqueue left child */
            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }
        }
 
        // Now pop all items from stack one by one and print them
        while (stack.empty() == false) {
            node = stack.pop();
			processNode(node, sbr);
        }
    }

	private void processNode(Node root, StringBuffer sbr) {
		sbr.append(root.getData() + " ");
	}

	public static void main(String[] args) {
		TraversalsOfBST bt = new TraversalsOfBST();
		Node root = bt.createTree();
		StringBuffer sbr = new StringBuffer();
		bt.preorderTraversal(root, sbr);
		System.out.println("1. Pre order traversal:\t" + sbr.toString());
		sbr = new StringBuffer();
		bt.inorderTraversal(root, sbr);
		System.out.println("2. In order traversal: \t" + sbr.toString());
		sbr = new StringBuffer();
		bt.postorderTraversal(root, sbr);
		System.out.println("3. Post order traversal:\t" + sbr.toString());
		sbr = new StringBuffer();
		bt.levelOrderBottomToTopTraversal(root, sbr);
		System.out.println("4. Level order traversal - Bottom To Top:\t"
				+ sbr.toString());
		sbr = new StringBuffer();
		bt.levelOrderTopToBottomTraversal(root, sbr);
		System.out.println("5. Level order traversal - Top To Bottom:\t"
				+ sbr.toString());
		sbr = new StringBuffer();
		bt.zigZagTraverse(root, sbr);
		System.out.println("6. Level order traversal - zigzag or Sprial:\t"
				+ sbr.toString());
		sbr = new StringBuffer();
		bt.reverseLevelOrder(root, sbr);
		System.out.println("7. Reverse Level order traversal :\t"
				+ sbr.toString());
//http://algorithms.tutorialhorizon.com/print-the-binary-tree-in-vertical-order-path/
		// http://algorithms.tutorialhorizon.com/print-the-top-view-of-a-binary-tree/
	}

class Node {

	private int data;
	private Node leftChild;
	private Node rightChild;

	public Node(int data) {
		this.data = data;
		leftChild = null;
		rightChild = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
}
}