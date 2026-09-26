package ds.trees;
package ds.trees;

import java.util.*;

/*
    Print Left View of a Binary Tree
    or Print Right View of a Binary Tree
	https://leetcode.com/problems/binary-tree-right-side-view/submissions/2153553556/
*/
public class Main {
	
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private static void dfs(TreeNode node, int level, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (level == list.size()) {
            list.add(node.val);
        }

        dfs(node.right, level + 1, list);
        dfs(node.left, level + 1, list);
    }

    public static void printList(List<Integer> list) {
        for (Integer value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        /*
                 1              Level 0
               /   \
              2     3           Level 1
             / \   / \
            4   5 6   7         Level 2
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = rightSideView(root);

        printList(result);
    }

	static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
