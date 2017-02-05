package ds.trees;

public class CheckForBST {
	public static void main(String[] args) {
		new CheckForBST().processTree();
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
		System.out.println(isBst1(a, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	public boolean isBst1(Node node, int min, int max){
		if( node == null ){
			return true;
		}
		return (min <= node.value && max >= node.value) 
                        && isBst1(node.left, min, node.value)
                        && isBst1(node.right, node.value, max);
	}
        
	// method 2: do inOrder and check if it is in ascending order
	// doesnt work in case of duplicates
        public static Node prevNode = null;
	public boolean isBST2(Node node) {
		if (node != null) {
			if (!isBST2(node.left))
				return false;
			if (prevNode != null && prevNode.value >= node.value) {
				return false;
			}
			prevNode = node;
			return isBST2(node.right);
		}
		return true;
	}
        
        class Node {
		Node left;
		Node right;
		int value;
		public Node(int value) {
			this.value = value;
		}
	}
}
