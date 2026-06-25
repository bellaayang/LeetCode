/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        for (int i = 0; i < s1.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < t1.length + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < s1.length + 1; i++) {
            for (int j = 1; j < t1.length + 1; j++) {
                if (s1[i - 1] == t1[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                
            }
            
        }

        return dp[s.length()][t.length()];
        
    }
}
// @lc code=end

