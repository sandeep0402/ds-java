package ds.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class PrintVerticalViewofBT {
	private static TreeMap<Integer, List> ht = new TreeMap<Integer, List>();

	private Node topView(Node root, int level) {
		// 1. If node is null, return and stop recursion
		if (root == null)
			return null;
		// System.out.println( "Checking level=" + level + ", root.data="+ root.data);

		// If map already contains the level then do nothing 7 DON'T OVERRIDE
		if (ht.containsKey(level)) {
			List x = ht.get(level);
			x.add(root.data);
			ht.put(level, x);
		} else {
			// If map don't have this level as key then add it
			// print only the first element at each level in vertical order
			// System.out.println(root.data + " ");
			List list = new ArrayList();
			list.add(root.data);
			ht.put(level, list);
		}
		// After node, process left child first with decreased levels e.g: -1,-2 etc
		topView(root.left, level - 1);
		// After processing left child, process right child with increased levels e.g: 1,2 etc
		topView(root.right, level + 1);
		return null;
	}

	// Just for printing, no logic in this method
	private void printTop(Node node) {
		topView(node, 0);
		Iterator iterator = ht.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key = (Integer) iterator.next();
			//System.out.println(key +" = " +ht.get(key));
			Integer newKey = key;
			if(newKey < 0){
				newKey = -(newKey);
			}
			newKey += 4;
			newKey *= 2;
			System.out.format("%"+newKey+"s", ht.get(key).toString());
			System.out.println();
			System.out.println();

		}
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
		PrintVerticalViewofBT p = new PrintVerticalViewofBT();
		p.printTop(root);
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