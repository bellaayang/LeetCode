/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;
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
    List<List<Integer>> resList = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun(root);
        return resList;  
    }

    private void checkFun (TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (node == null) {
            return;
        }

        int count = 0;
        queue.offer(node);

        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            count = queue.size();
            while (count > 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                count--;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            resList.add(list);
        }
        
        
    }
}
// @lc code=end

