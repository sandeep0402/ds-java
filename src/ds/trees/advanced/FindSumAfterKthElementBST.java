package ds.trees.advanced;

/*
    Find sum of n elements after kth smallest element in BST. Tree is very large, you are
    not allowed to traverse the tree.
    Discussion : Since the array traversal is not allowed so we need to do some preprocessing over the tree, something like storing sum of all its predecessor nodes.For finding kth smallest element, use order statistics approach:
    http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
*/
public class FindSumAfterKthElementBST {
        int sum = 0;
        int index = 0;
        
        private void approach1(Node node, int kthIndex){
        	if (node == null) {
                    return;
                }
                approach1(node.left, kthIndex);
                index++;
                System.out.println("node :"+node.data +", level="+index); 
                if (index <= kthIndex) {
                    process(node); 
                    return;
                }
                approach1(node.right, kthIndex);
        }
        
	private void process(Node node) {           
               // System.out.println(node.data);
                sum += node.data;
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);   
		root.right = new Node(22);
		root.left.left = new Node(4);   
		root.left.right = new Node(12);                   
                root.left.right.left= new Node(10);                   
                root.left.right.right= new Node(14);                   
		FindSumAfterKthElementBST p = new FindSumAfterKthElementBST();
                //if k = 3, then output should be 10, and if k = 5, then output should be 14.
                int k = 3;
                p.approach1(root, k);
                System.out.println("Sum After ("+ k +")th element  :" + p.sum); 
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