/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        int sum = 0;
        int startIndex = 0;
        Arrays.fill(used, false);
        Arrays.sort(candidates);

        backtracking(candidates, target, startIndex, sum);
        return result;
        
        
    }

    private void backtracking (int[] candidates, int target, int startIndex, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        } 

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backtracking(candidates, target, i + 1, sum);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();   
        }

    }

    

    
}
// @lc code=end

