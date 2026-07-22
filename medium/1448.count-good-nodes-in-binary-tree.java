/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
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
    
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs (TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }

        int res = node.val >= maxVal ? 1 : 0;
        maxVal = Math.max(maxVal, node.val);

        res += dfs(node.left, maxVal);
        res += dfs(node.right, maxVal);

        return res;
    }
}
// @lc code=end

