/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i * i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j >= i * i && dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                }   
            }
            
        }

        return dp[n];
        
    }
}
// @lc code=end

