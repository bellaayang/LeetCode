/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int[] answer = new int[len];

        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int num = i - stack.peek();
                answer[stack.peek()] = num;
                stack.pop();
            }
            stack.push(i);

        }

        return answer;
        
    }
}
// @lc code=end

