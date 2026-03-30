/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> paths = new LinkedList<>();
        List<String> res = new LinkedList<>();
        backtracking(root, paths, res);
        return res;
        
    }

    private void backtracking (TreeNode root, List<Integer> paths, List<String> result) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
                
            }
            sb.append(paths.get(paths.size() - 1));
            result.add(sb.toString());
            return;
        }

        if (root.left != null) {
            backtracking(root.left, paths, result);
            paths.remove(paths.size() - 1);
        }

        if (root.right != null) {
            backtracking(root.right, paths, result);
            paths.remove(paths.size() - 1);
        }

    }
}
// @lc code=end

