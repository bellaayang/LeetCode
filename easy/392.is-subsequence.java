/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < t.length() + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s1[i - 1]== t1[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
                
            }
            
        }

        if (dp[s.length()][t.length()] == s.length()) {
            return true;
        } else {
            return false;
        }

        
        
    }
}
// @lc code=end

