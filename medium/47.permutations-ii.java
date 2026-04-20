/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums);
        return result;    
    }

    private void backtracking (int[] nums) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) {
                continue;
            }

           if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            used[i] = false; 
            path.removeLast();     
        }
    }

    
}
// @lc code=end

