package ds.trees;

public class BinaryTree {
	Node root;

	public BinaryTree() {
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
		root.getRightChild().setLeftChild(new Node(12));

		return root;
	}

	/* preOrder traversal - Recursive version */
	public void preorderTraversal(Node root, StringBuffer sbr) {
		if (root == null)
			return;
		/* Append node data in string buffer */
		sbr.append(root.getData() + " ");
		preorderTraversal(root.getLeftChild(), sbr);
		preorderTraversal(root.getRightChild(), sbr);
	}

	/* inOrder traversal - Recursive version */
	public void inorderTraversal(Node root, StringBuffer sbr) {
		if (root == null)
			return;
		inorderTraversal(root.getLeftChild(), sbr);
		/* Append node data in string buffer */
		sbr.append(root.getData() + " ");
		inorderTraversal(root.getRightChild(), sbr);
	}

	/* postOrder traversal - Recursive version */
	public void postorderTraversal(Node root, StringBuffer sbr) {
		if (root == null)
			return;
		postorderTraversal(root.getLeftChild(), sbr);
		postorderTraversal(root.getRightChild(), sbr);
		/* Append node data in string buffer */
		sbr.append(root.getData() + " ");
	}

	/* Level order traversal - Recursive version */
	public void levelorderTraversal(Node root, StringBuffer sbr) {
		if (root == null)
			return;
		postorderTraversal(root.getLeftChild(), sbr);
		postorderTraversal(root.getRightChild(), sbr);
		/* Append node data in string buffer */
		sbr.append(root.getData() + " ");
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Node root = bt.createTree();
		StringBuffer sbr = new StringBuffer();
		bt.preorderTraversal(root, sbr);
		System.out.println("Pre order traversal:\t" + sbr.toString());
		sbr = new StringBuffer();
		bt.inorderTraversal(root, sbr);
		System.out.println("In order traversal: \t" + sbr.toString());
		sbr = new StringBuffer();
		bt.postorderTraversal(root, sbr);
		System.out.println("Post order traversal:\t" + sbr.toString());
	}
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