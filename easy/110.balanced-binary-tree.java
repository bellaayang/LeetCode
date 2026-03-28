/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
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
    public boolean isBalanced(TreeNode root) {
        int height = height(root);
        return height != -1;
        
        
        
    }

    private int height (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int heightLeft = height(root.left);
        if (heightLeft == -1) {
            return -1;
        }

        int heightRight = height(root.right);
        if (heightRight == -1) {
            return -1;
        }

        if (Math.abs(heightLeft - heightRight) > 1) {
            return -1;
        }

        return Math.max(heightLeft, heightRight) + 1;
    }

    
}
// @lc code=end

