package ds.trees.advanced;

/*
 * http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 * Amazon round 1:  Telephonic
 * Q1. Write a code snippet which will return true/false if given tree contains other tree
 * Q2. Explain the code with interviewer's given sample trees (3-4 trees)
 * Q3. In above question, return true if tree contains subtree or even its mirror
 * Q4. In above question, how to handle the logic when tree is not binary means its n-tree
 */
public class FindSubTreeInTree {

	   Node root1,root2;
	   
	    /* A utility function to check whether trees with roots as root1 and
	       root2 are identical or not */
	    boolean areIdentical(Node root1, Node root2) 
	    {
	  
	        /* base cases */
	        if (root1 == null && root2 == null)
	            return true;
	  
	        if (root1 == null || root2 == null)
	            return false;
	  
	        /* Check if the data of both roots is same and data of left and right
	           subtrees are also same */
	        return (root1.data == root2.data
	                && areIdentical(root1.left, root2.left)
	                && areIdentical(root1.right, root2.right));
	        /*
	        Following condition will be applied if subtree or its mirror either of one should be present
	        return (root1.data == root2.data
	                && ((areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right))
	                		|| (areIdentical(root1.right, root2.left) && areIdentical(root1.left, root2.right)))
	                );
	        */
	    }
	  
	    /* This function returns true if S is a subtree of T, otherwise false */
	    boolean isSubtree(Node T, Node S) 
	    {
	        /* base cases */
	        if (S == null) 
	            return true;
	  
	        if (T == null)
	            return false;
	  
	        /* Check the tree with root as current node */
	        if (areIdentical(T, S)) 
	            return true;
	  
	        /* If the tree with root as current node doesn't match then
	           try left and right subtrees one by one */
	        return isSubtree(T.left, S)
	                || isSubtree(T.right, S);
	    }
	  
	    public static void main(String args[]) 
	    {
	    	FindSubTreeInTree tree = new FindSubTreeInTree();
	          
	        // TREE 1
	        /* Construct the following tree
	              26
	             /   \
	            10     3
	           /    \     \
	          4      6      3
	           \
	            30  */
	           
	        tree.root1 = new Node(26);
	        tree.root1.right = new Node(3);
	        tree.root1.right.right = new Node(3);
	        tree.root1.left = new Node(10);
	        tree.root1.left.left = new Node(4);
	        tree.root1.left.left.right = new Node(30);
	        tree.root1.left.right = new Node(6);
	  
	        // TREE 2
	        /* Construct the following tree
	           10
	         /    \
	         4      6
	          \
	          30  */
	           
	        tree.root2 = new Node(10);
	        tree.root2.right = new Node(6);
	        tree.root2.left = new Node(4);
	        tree.root2.left.right = new Node(30);
	  
	        if (tree.isSubtree(tree.root1, tree.root2))
	            System.out.println("Tree 2 is subtree of Tree 1 ");
	        else
	            System.out.println("Tree 2 is not a subtree of Tree 1");
	    }
}
