/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len][amount + 1];

        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;   
        }

        for (int j = coins[0]; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = 1;
            }   
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
                
            }
        }
            
        

        return dp[len - 1][amount];
        
    }
}
// @lc code=end

