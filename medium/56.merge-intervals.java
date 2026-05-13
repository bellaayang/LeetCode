/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int right = intervals[0][1];
        int left = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                result.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];

            }
            
        }
        result.add(new int[]{left, right});

        return result.toArray(new int[result.size()][2]);
        
    }
}
// @lc code=end

