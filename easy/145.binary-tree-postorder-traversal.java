package easy;
/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
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
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     postorder(root, list);
    //     return list;
    // }

    // private void postorder (TreeNode node, List<Integer> list) {
    //     if (node == null) {
    //         return;
    //     }

    //     postorder(node.left, list);
    //     postorder(node.right, list);
    //     list.add(node.val);

    // }

    public List<Integer> postorderTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisit = null;

        while (cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.peek();
                if (top.right == null || lastVisit == top.right) {
                    list.add(top.val);
                    lastVisit = stack.pop();     
                } else {
                    cur = top.right;
                }
            }
        }
        return list;
    }
}
// @lc code=end
