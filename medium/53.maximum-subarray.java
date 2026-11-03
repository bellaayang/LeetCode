/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;

        for (int num : nums) {
            if (sum < 0) {
                sum = 0;
            }

            sum += num;
            max = Math.max(max, sum);
        }

        return max;
        
    }
}
// @lc code=end

