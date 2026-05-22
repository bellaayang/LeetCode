/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][m + 1][n + 1];
        int zeroNum = 0;
        int oneNum = 0;
        for (char c : strs[0].toCharArray()) {
            if (c == '0') {
                zeroNum++;
            } else {
                oneNum++;
            }
        }

        for (int i = zeroNum; i < m + 1; i++) {
            for (int j = oneNum; j < n + 1; j++) {
                dp[0][i][j] = 1;
            }
        }

        for (int i = 1; i < len; i++) {
            zeroNum = 0;
            oneNum = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (zeroNum <= j && oneNum <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeroNum][k - oneNum] + 1);

                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }

                }
            }

        }
        return dp[len - 1][m][n];

    }
}
// @lc code=end
