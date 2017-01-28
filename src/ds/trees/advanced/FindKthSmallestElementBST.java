package ds.trees.advanced;

/*
    Find k-th smallest element in BST 
    Use inorder traversal
    http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
*/
public class FindKthSmallestElementBST {
        int index = 0;
        private void approach1(Node node, int kthIndex){
        	if (node == null) {
                    return;
                }
                approach1(node.left, kthIndex);
                if (kthIndex == ++index) {
                    process(node); 
                    return;
                }
                System.out.println("node :"+node.data +", level="+index); 
                approach1(node.right, kthIndex);
        }

        private int approach2(Node node, int previousLevel, int kthIndex){
        	if (node == null) {
                    return previousLevel;
                }
                int leftNodeLevel = approach2(node.left, previousLevel, kthIndex);
                int nodeLevel = leftNodeLevel + 1;
                if (kthIndex == nodeLevel) {
                    process(node);                    
                }
                int rightNodeLevel = approach2(node.right, nodeLevel, kthIndex);
                System.out.println("node :"+node.data +", level="+nodeLevel); 

                // Return the leve which is heigher from node itself or right sub tree 
		return nodeLevel > rightNodeLevel ? nodeLevel : rightNodeLevel;
	}
	private void process(Node node) {           
                System.out.println(node.data);
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);   
		root.right = new Node(22);
		root.left.left = new Node(4);   
		root.left.right = new Node(12);                   
                root.left.right.left= new Node(10);                   
                root.left.right.right= new Node(14);                   
		FindKthSmallestElementBST p = new FindKthSmallestElementBST();
                //if k = 3, then output should be 10, and if k = 5, then output should be 14.
                int k = 3;
                System.out.println(k+"th element is :"); 
                p.approach1(root, k);
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