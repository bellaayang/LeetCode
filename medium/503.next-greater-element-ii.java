/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                result[stack.peek()] = nums[i % nums.length];
                stack.pop();
            }
            if (i < nums.length) {
                stack.push(i);
            }
            
        }

        return result;
        
    }
}
// @lc code=end

