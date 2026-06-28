/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int trap(int[] height) {
        // int leftIndex = 0;
        // int rightIndex = height.length - 1;

        // int leftMax = height[leftIndex];
        // int rightMax = height[rightIndex];

        // int result = 0;

        // while (leftIndex < rightIndex) {
        //     if (leftMax < rightMax) {
        //         result += Math.max(0, leftMax - height[leftIndex]);
        //         leftIndex++;
        //         leftMax = Math.max(leftMax, height[leftIndex]);
        //     } else {
        //         result += Math.max(0, rightMax - height[rightIndex]);
        //         rightIndex--;
        //         rightMax = Math.max(rightMax, height[rightIndex]);
        //     }
        // }

        // return result;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        int result = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[stack.peek()] > height[i]) {
                stack.push(i);
            } else if (height[stack.peek()] == height[i]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && (height[stack.peek()] < height[i]) ) {
                    int mid = stack.peek();
                    stack.pop();
                    if (!stack.isEmpty()) {
                    int left = stack.peek();
                    int right = i;
                    int h = Math.min(height[left], height[right]) - height[mid];
                    int w = right - left - 1;
                    int v = h * w;
                    result += v;
                    }

                    
                }
                stack.push(i);
            }
            
        }

        return result;
        
    }
}
// @lc code=end

