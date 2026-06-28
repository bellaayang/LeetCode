/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        int index = 0;
        for (int i = 1; i < newHeights.length - 1; i++) {
            newHeights[i] = heights[index];
            index++;
        }

        int result = 0;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < newHeights.length; i++) {
            if (newHeights[stack.peek()] < newHeights[i]) {
                stack.push(i);
            } else if (newHeights[stack.peek()] == newHeights[i]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && (newHeights[stack.peek()] > newHeights[i])) {
                    int mid = stack.peek();
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int right = i;
                        int left = stack.peek();
                        int h = newHeights[mid];
                        int w = right - left - 1;
                        int v = h * w;
                        result = Math.max(result, v);
                    }
                }
                stack.push(i);
            }
            
        }

        return result;
        
    }
}
// @lc code=end

