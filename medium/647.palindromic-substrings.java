/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int result = 0;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        result++;
                    } else {
                        if (dp[i + 1][j - 1] == true) {
                            dp[i][j] = true;
                            result++;
                        }
                    }
                }
                
            }
            
        }

        return result;
        
    }
}
// @lc code=end

