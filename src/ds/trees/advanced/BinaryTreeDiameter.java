package ds.trees.advanced;

/*
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/    
 * Diameter of a Binary Tree : The diameter of a tree (sometimes called the width) 
 * is the number of nodes on the longest path between two leaves in the tree.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeDiameter {
 
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
 
        System.out.println("Diameter is : " + diameterOfBinaryTree(tree));
    } 
    
    static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        findMaxLevel(root);
        return diameter;
    }
 
    private static int findMaxLevel(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = findMaxLevel(node.left);
        int rightHeight = findMaxLevel(node.right);
        
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    

  /* node and key value*/
  static class TreeNode
  {
      int val;
      TreeNode left, right;

      public TreeNode(int val)
      {
          this.val = val;
          left = right = null;
      }
  }
}
