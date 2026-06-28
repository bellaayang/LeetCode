/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph, 0, graph.length - 1);
        return result;
    }

    public static void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i : graph[x]) {
            path.add(i);
            dfs(graph, i, n);
            path.removeLast();
        }
    }
}
// @lc code=end

