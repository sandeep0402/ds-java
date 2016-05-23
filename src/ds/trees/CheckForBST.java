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
		System.out.println(isBst(a, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	public boolean isBst(Node node, int min, int max){
		boolean nodeOk = true;
		boolean rightOk = true;
		boolean  leftOk = true;
		if( node == null ){
			return true;
		}
		if(node.value >= min && node.value <= max){
			nodeOk = true;
		}else{
			nodeOk = false;
		}
		if(node.right != null){
			rightOk = isBst(node.right, node.value, max);
		}
		if(node.left != null){
			leftOk = isBst(node.left, min, node.value);
		}
		return nodeOk && rightOk && leftOk;
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
