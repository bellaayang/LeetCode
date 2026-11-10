/*
 * @lc app=leetcode id=1899 lang=java
 *
 * [1899] Merge Triplets to Form Target Triplet
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> count = new HashSet<>();

        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1]|| t[2] > target[2]) {
                continue;
            }

            for (int i = 0; i < target.length; i++) {
                if (t[i] == target[i]) {
                    count.add(i);
                }
                
            }
        }

        return count.size() == 3;
        
    }
}
// @lc code=end

