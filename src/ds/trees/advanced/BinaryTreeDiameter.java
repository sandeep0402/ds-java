package ds.trees.advanced;

/*
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/    
 * Diameter of a Binary Tree : The diameter of a tree (sometimes called the width) 
 * is the number of nodes on the longest path between two leaves in the tree.
 */
public class BinaryTreeDiameter {
    Node root;
 
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        BinaryTreeDiameter tree = new BinaryTreeDiameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("The diameter of given binary tree is : "
                           + tree.diameter(tree.root));
    } 
    
    /* Method to calculate the diameter and return it to main */
    public int diameter(Node node)
    {
        /* base case if tree is empty */
        if (node == null)
            return 0;
 
        /* get the height of left and right sub trees */
        int lheight = height(node.left);
        int rheight = height(node.right);
        /* 
            diameter of any node = Height of left subtree + height of right subtree + 1 
        */
        int diameterCurrentNode = lheight + rheight + 1;
 
        /* get the diameter of left and right subtrees */
        int diameterLeftNode = diameter(node.left);
        int diameterRightNode = diameter(node.right);
 
        // Return max of the diameters, which can is be of current node, left node oor right node
        return Math.max(diameterCurrentNode,
                        Math.max(diameterLeftNode, diameterRightNode));
 
    }
 
    /*The function Compute the "height" of a tree. Height is the
      number f nodes along the longest path from the root node
      down to the farthest leaf node.*/
    static int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
 
        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }
}
/* node and key value*/
class Node
{
    int data;
    Node left, right;
 
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
