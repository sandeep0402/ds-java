package ds.trees;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
* https://leetcode.com/problems/validate-binary-search-tree/
*/
public class Main {
	private boolean isBst(Node node, long minVal, long maxVal){
        if(node == null){
            return true;
        }
        if(node.val <= minVal || node.val >= maxVal ){
            return false;
        }
        return isBst(node.left, minVal, node.val)
        && isBst(node.right, node.val, maxVal);
    }
	
	public static void main(String[] args) {
		new Main().processTree();
	}
	
	public void processTree(){
		  Node a=new Node(12);
		  Node b=new Node(3);
		  Node c=new Node(15);
		  Node d=new Node(10);
		  Node e=new Node(14);
		  Node f=new Node(17);
		  Node g=new Node(4);
		  Node h=new Node(11);
		  Node i=new Node(5);
		  a.left=b;
		  a.right=c;
		  b.right=d;
		  c.left=e;
		  c.right=f;
		  d.left=g;
		  d.right=h;
		  g.right=i;
		System.out.println(isBst(a, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
        
   class Node {
		Node left;
		Node right;
		int val;
		public Node(int val) {
			this.val = val;
		}
	}
}
