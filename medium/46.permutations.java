/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new LinkedList<>();
        boolean used[] = new boolean[nums.length];

        backtrack(nums, track, used);

        return res;
        
    }

    private void backtrack(int[] nums, List<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;

            backtrack(nums, track, used);

            track.removeLast();
            used[i] = false;      
        }
    }
}
// @lc code=end

