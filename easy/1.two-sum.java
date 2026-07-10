/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                int index = map.get(temp);
                result[0] = index;
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
            
        }
        return result;
    }
}
// @lc code=end

