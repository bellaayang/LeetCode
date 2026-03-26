/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.LinkedList;
import java.util.Queue;



class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return root;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Node node = null;
            Node preNode = null;
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    preNode = queue.poll();
                    node = preNode;
                } else {
                    node = queue.poll();
                    preNode.next = node;
                    preNode = preNode.next;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }       
            }
            preNode.next = null;
        }
        return root;
        
    }
}
// @lc code=end

