/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return result;
        
    }

    private void backtracking (int[] candidates, int target, int sum, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];  
            path.removeLast();   
        }

    }
}
// @lc code=end

