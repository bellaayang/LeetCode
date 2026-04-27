/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int start = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (start >= 0 && s[start] >= g[i]) {
                start--;
                count++;
            }
            
        }
        return count;
        
    }
}
// @lc code=end

