/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] edge = new int[27];

        for (int i = 0; i < s.length(); i++) {
            edge[s.charAt(i) - 'a'] = i;     
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, edge[s.charAt(i) - 'a']);
            if (i == right) {
                result.add(right - left + 1);
                left = right + 1;
            }              
        }

        return result;

        
    }
}
// @lc code=end

