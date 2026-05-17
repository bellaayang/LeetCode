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

    public Node connect(Node root) {
        // if (root == null) {
        //     return root;
        // }
        // Queue<Node> queue = new LinkedList<>();
        // queue.offer(root);
        
        // while (!queue.isEmpty()) {
        //     int size = queue.size();
        //     for(int i = 0; i < size; i++) {
        //         Node node = queue.poll();
        //         if (i < size - 1) {
        //             node.next = queue.peek();
        //         } else {
        //             node.next = null;
        //         }
        //         if (node.left != null) {
        //             queue.offer(node.left);
        //         }
        //         if (node.right != null) {
        //             queue.offer(node.right);
        //         }

        //     }

        // }
        // return root;

        if (root == null) {
            return null;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            Node cur = leftmost; // 每层的最左节点
            while (cur != null) {
                // 操作1：连接同一父节点下的左右孩子
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
// @lc code=end

