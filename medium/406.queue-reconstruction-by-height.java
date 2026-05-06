/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[0] - b[0];
            }
            return b[0] - a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();
        for (int[] person: people) {
            que.add(person[1], person);
        }

        return que.toArray(new int[people.length][]);
        
    }
}
// @lc code=end

