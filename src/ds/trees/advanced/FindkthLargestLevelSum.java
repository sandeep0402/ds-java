package ds.trees.advanced;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

/*
 * https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/
 * You are given the root of a binary tree and a positive integer k.
 * The level sum in the tree is the sum of the values of the nodes that are on the same level.
 * Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.
 * Note that two nodes are on the same level if they have the same distance from the root.
 */
class FindkthLargestLevelSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        // Default PriorityQueue = MIN-HEAP: peek/remove gives smallest
        PriorityQueue<Long> levelSums = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            levelSums.add(sum);

            // Keep only K largest sums; remove smallest when size > K
            if (levelSums.size() > k) {
                levelSums.remove();
            }
        }

        if (levelSums.size() < k) {
            return -1;
        }

        // K largest are kept; smallest among them = K-th largest
        return levelSums.peek();
    }
}
