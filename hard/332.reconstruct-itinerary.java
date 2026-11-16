/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> t : tickets) {
            String src = t.get(0);
            String dst = t.get(1);

            if (!adj.containsKey(src)) {
                adj.put(src, new PriorityQueue<>());
            }
            adj.get(src).offer(dst);
        }

        dfs(adj, "JFK", res);
        Collections.reverse(res);
        return res;
        
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, String src, List<String> res) {
        PriorityQueue<String> queue = adj.get(src);
        while (queue != null && !queue.isEmpty()) {
            String dst = queue.poll();
            dfs(adj, dst, res);
        }

        res.add(src);

    }
}
// @lc code=end

