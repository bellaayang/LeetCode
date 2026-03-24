/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     preorder(root, list);
    //     return list;
        
    // }

    // private void preorder (TreeNode node, List<Integer> list) {
    //     if (node == null) {
    //         return;
    //     }

    //     list.add(node.val);
    //     preorder(node.left, list);
    //     preorder(node.right, list);
    // }

    public List<Integer> preorderTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);
        while (!treeStack.isEmpty()) {
            TreeNode node = treeStack.pop();
            list.add(node.val);
            if (node.right != null) {
                treeStack.push(node.right);
            }
            if (node.left != null) {
                treeStack.push(node.left);
            }
        }

        return list;
        
    }


}
// @lc code=end

