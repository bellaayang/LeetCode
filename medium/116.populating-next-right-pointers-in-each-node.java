/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
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
            Node pre = null;
            while (len > 0) {
                Node cur = queue.poll();
                len--;
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                
            }
        }
        return root;
        
    }
}
// @lc code=end

