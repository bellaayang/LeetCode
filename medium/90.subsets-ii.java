/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            used[i] = false;        
        }
        backtracking(nums, used, 0);
        return result;
        
        
    }

    private void backtracking (int[] nums, boolean[] used, int startIndex) {
        result.add(new LinkedList<>(path));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < used.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
                
            }   
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, i + 1);
            used[i] = false;
            path.removeLast();  
        }

    }
}
// @lc code=end

