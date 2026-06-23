/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2 * k + 1];
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];   
        }   
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j] - prices[i], dp[i - 1][j + 1]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 1] + prices[i], dp[i - 1][j + 2]);
                
            }
            
        }

        return dp[len - 1][2 * k];
    }
}
// @lc code=end

