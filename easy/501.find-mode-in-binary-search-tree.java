/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 */

// @lc code=start

import java.util.ArrayList;

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
    ArrayList<Integer> arrayList = new ArrayList<>();
    TreeNode prev = null;
    int maxCount = 0;
    int count = 0;
    public int[] findMode(TreeNode root) {
       inorder(root);
       int[] result = new int[arrayList.size()];
       for (int i = 0; i < result.length; i++) {
        result[i] = arrayList.get(i); 
       }
       return result;
        
    }

    private void inorder (TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (prev == null || root.val != prev.val) {
            count = 1;
        } else if (prev.val == root.val) {
            count++;
        }
        prev = root;
        if (count > maxCount) {
            arrayList.clear();
            arrayList.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            arrayList.add(root.val);
        }
        inorder(root.right);

    }
}
// @lc code=end

