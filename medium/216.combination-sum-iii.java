/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return result;
        
    }

    private void backtracking (int k, int n, int startIndex, int sum) {
        if (sum > n) {
            return;
        }

        if (path.size() == k) {
            if (sum == n) {
                result.add(new LinkedList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(k, n, i + 1, sum);
            sum -= i;
            path.removeLast();
            
        }

    }
}
// @lc code=end

