package ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintDiagonalViewofBT {
	public void diagonalPrint(Node root)
	{
		//add your code here.
		StringBuilder sb = new StringBuilder();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			Node node =queue.remove();
			diagonalPrint(node, queue, sb);
		}
		System.out.print(sb.toString().trim());
	}
	public void diagonalPrint(Node root,Queue<Node> queue, StringBuilder sb){
		if(root == null){
			return;
		}
		sb.append(root.data);
		sb.append(" ");
		if(root.left != null){
			queue.add(root.left);
		}
		diagonalPrint(root.right, queue, sb);
	}
	

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(8);
		root.left.right = new Node(5);
		root.right.right = new Node(7);
		root.right.left = new Node(11);

		/*
				7
			3		
				11
		1
				5
			2
				4
					8
					
		8	4	2	1,5,11		3	7		
		*/
		PrintDiagonalViewofBT p = new PrintDiagonalViewofBT();
		p.diagonalPrint(root);
	}
	
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

}