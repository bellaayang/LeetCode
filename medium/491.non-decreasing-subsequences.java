/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Non-decreasing Subsequences
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
        
    }

    private void backtracking (int[] nums, int startIndex) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (path.size() >= 2) {
            result.add(new LinkedList<>(path));
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }
            if (map.getOrDefault(nums[i], 0) >= 1) {
                continue;
            }
            path.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            backtracking(nums, i + 1);
            path.removeLast();
            
        }
    }
}
// @lc code=end

