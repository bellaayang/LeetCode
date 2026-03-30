/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> result = new LinkedList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums, track, used);
        return result;

      
        
    }

    private void backtracking (int[] nums, List<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i] == true) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;
            backtracking(nums, track, used);
            track.removeLast();
            used[i] = false;
            
        }
    }

    
}
// @lc code=end

