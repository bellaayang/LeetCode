/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start

import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == true && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
                
            }
            
        }

        return dp[s.length()];
        
        
    }
}
// @lc code=end

