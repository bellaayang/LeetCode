/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // if (nums.length == 1) {
        //     return nums[0];
        // }
        // int maxResult = Integer.MIN_VALUE;
        // int sum = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     sum += nums[i];
        //     if (sum > maxResult) {
        //         maxResult = sum;
        //     }
        //     if (sum < 0) {
        //         sum = 0;
        //     }         
        // }  
        // return maxResult;   

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max (res, dp[i]);
            
        }

        return res;
    }
}
// @lc code=end

