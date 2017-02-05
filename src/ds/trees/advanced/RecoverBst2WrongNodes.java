/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.trees.advanced;

/**
 * Recover a Binary Search Tree if positions of two nodes are swapped.
 * http://www.ideserve.co.in/learn/how-to-recover-a-binary-search-tree-if-two-nodes-are-swapped
 * 
    The main idea that we are going to use is that in-order traversal array for a BST would be a sorted array. 
    If this order is not maintained, then we know that the nodes are not correctly placed.
    Please see the pseudo-code below to understand the algorithm.

    1. Initialize firstStartPoint = null, lastEndPoint = null, previous_node = null
    2. Visit all nodes of a tree in in-order fashion. Keep track of previously visited node.
    3. At each node that is being visited, 
        if value of previously visited node > current node
        {
            if(firstStartPoint == null)
             {
                firstStartPoint = previous_node
             }
             lastEndPoint = current_node;
        }
    4. After all nodes are visited :swap firstStartPoint with lastEndPoint     
 */
public class RecoverBst2WrongNodes{
   static class TreeNode
   {
        TreeNode left;
        TreeNode right;
        int val;
         
        public TreeNode(int x)
        {
            this.val = x;
        }
   }
 
    TreeNode faultyNode1, faultyNode2;
    TreeNode prevNode;
 
    public void findSegments(TreeNode root) 
    {
        if (root == null) return;
         
        findSegments (root.left);
         
        if (prevNode != null) 
        {
            if (prevNode.val   >  root.val) 
            {   
                if (faultyNode1 == null)
                {
                    faultyNode1 = prevNode;
                }
                faultyNode2 = root;
    //System.out.println("\nroot.val="+root.val+",prevNode="+prevNode.val+", firstStartPoint="+faultyNode1.val+", lastEndPoint="+faultyNode2.val+", ");                
             }
        }
        prevNode = root;
         
        findSegments (root.right);   
   }
     
   public void recoverTree(TreeNode root) 
   {
       findSegments(root);
       System.out.println("\nElement1= "+faultyNode1.val+", Element2="+faultyNode2.val);
       int x = faultyNode1.val;
       faultyNode1.val = faultyNode2.val;
       faultyNode2.val = x;
   }
 
   public void printInOrder(TreeNode root)
   {
       if (root == null) return;
            
       printInOrder(root.left);
       System.out.print(root.val +" ");
       printInOrder(root.right);
   }
    
   public static void main(String[] args)
   {
       TreeNode root = new TreeNode(10);
       TreeNode n1   = new TreeNode(15);
       TreeNode n2   = new TreeNode(5);
       TreeNode n3   = new TreeNode(4);
       TreeNode n4   = new TreeNode(7);
       TreeNode n5   = new TreeNode(14);
       TreeNode n6   = new TreeNode(17);
       /*           10
              15            5
            4    7      14      17
       */ 
       root.left  = n1;
       root.right = n2;
        
       n1.left  = n3;
       n1.right = n4;
        
       n2.left  = n5;
       n2.right = n6;
        
       RecoverBst2WrongNodes solution = new RecoverBst2WrongNodes();
        
       System.out.println("In-Order traversal of BST before recovery: ");
       solution.printInOrder(root);
 
       solution.recoverTree(root);
        
       System.out.println("\nIn-Order traversal of BST after recovery: ");
       solution.printInOrder(root);
   }
}