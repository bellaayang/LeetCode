/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0]  = 0;
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;      
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j >= coins[i] && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
                
            }
            
        }

        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        } else {
            return -1;
        }
        
    }
}
// @lc code=end

