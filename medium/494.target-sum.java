/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }

        int backpack = (sum + target) / 2;
        int number = nums.length;

        int[][] dp = new int[number][backpack + 1];
        if (nums[0] <= backpack) {
            dp[0][nums[0]] = 1;
        }

        
        int countZero = 0;
        for (int i = 0; i < number; i++) {
            if (nums[i] == 0) {
                countZero++;
            }
            dp[i][0] = (int) Math.pow(2, countZero);
        }

        for (int i = 1; i < number; i++) {
            for (int j = 0; j < backpack + 1; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[number - 1][backpack];
        
    }
}
// @lc code=end

