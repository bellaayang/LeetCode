/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int second = stack.pop();
                int first = stack.pop();
                int result = first + second;
                stack.push(result);
            } else if (token.equals("-")) {
               int second = stack.pop();
                int first = stack.pop();
                int result = first - second;
                stack.push(result);
            } else if (token.equals("*")) {
                int second = stack.pop();
                int first = stack.pop();
                int result = first * second;
                stack.push(result);
            } else if (token.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                int result = first / second;
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        int result = stack.pop();
        return result;
        
    }
}
// @lc code=end

