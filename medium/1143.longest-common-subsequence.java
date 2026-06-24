/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        int[][] dp = new int[char1.length + 1][char2.length + 1];
        for (int i = 0; i < char1.length + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < char2.length + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < char1.length + 1; i++) {
            for (int j = 1; j < char2.length + 1; j++) {
                if (char1[i - 1] == char2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                
            }
            
        }

        return dp[char1.length][char2.length];
        
    }
}
// @lc code=end

