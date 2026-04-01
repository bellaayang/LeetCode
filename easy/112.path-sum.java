/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return backtracking(root, targetSum - root.val);
        
    }

    private boolean backtracking (TreeNode node, int targetSum) {
        // 1. terminate
        if (node.left == null && node.right == null && targetSum == 0) {
            return true;
        }

        if (node.left == null && node.right == null && targetSum != 0) {
            return false;
        }

        // 2. recursive
        if (node.left != null) {
            targetSum -= node.left.val;
            if (backtracking(node.left, targetSum)) {
                return true;
            }
            targetSum += node.left.val;
        }

        if (node.right != null) {
            targetSum -= node.right.val;
            if (backtracking(node.right, targetSum)) {
                return true;
            }
            targetSum += node.right.val;
        }

        return false;
    }
}
// @lc code=end

