/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = 0;
            
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1Array[i - 1] == word2Array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                
            }
            
        }

        return word1.length() + word2.length() - dp[word1.length()][word2.length()] * 2;
        
    }
}
// @lc code=end

