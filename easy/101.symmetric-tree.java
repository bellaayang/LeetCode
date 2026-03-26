/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return true;
        }

        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i+=2) {
                TreeNode nodeLeft = queue.poll();
                TreeNode nodeRight = queue.poll();

                if (nodeLeft == null && nodeRight == null) {
                    continue;
                } else if (nodeLeft == null && nodeRight != null) {
                    return false;
                } else if (nodeLeft != null && nodeRight == null) {
                    return false;
                } else if (nodeLeft.val != nodeRight.val) {
                    return false;
                }

                queue.offer(nodeLeft.left);
                queue.offer(nodeRight.right);

                queue.offer(nodeLeft.right);
                queue.offer(nodeRight.left);
                
            }

        }
        return true;
        
    }
}
// @lc code=end

