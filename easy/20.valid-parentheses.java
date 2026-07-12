/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;


class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] s1 = s.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] == '(' || s1[i] == '{' || s1[i] == '[') {
                stack.push(s1[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char cur = stack.pop();
                if ((s1[i] == ')' && cur != '(') || (s1[i] == '}' && cur != '{') || (s1[i] == ']' && cur != '[')) {
                    return false;
                }
            }
            
        }

        return stack.isEmpty();
        
    }
}
// @lc code=end

