/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;

        
    }

    private void backtracking (int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }

    }
}
// @lc code=end

