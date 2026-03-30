/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);        
        }

       

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (pq.size() < k ) {
                pq.add(new int[] {entry.getKey(), entry.getValue()});
            } else if (pq.size() >= k && pq.peek()[1] < entry.getValue()) {
                pq.poll();
                pq.add(new int[] {entry.getKey(), entry.getValue()});
            }      
        }

        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll()[0];     
        }
        return res;


        

    }
}
// @lc code=end
