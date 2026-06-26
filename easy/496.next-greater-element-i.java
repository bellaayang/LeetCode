/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        HashMap<Integer, Integer> map = new HashMap<>();

        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int num = stack.pop();
                map.put(nums2[num], nums2[i]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            map.put(nums2[num], -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
        
    }
}
// @lc code=end

