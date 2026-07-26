/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            int distance = squreDistance(points[i]);
            int[] entry = {distance, i};
            if (maxHeap.size() >= k) {
                if (maxHeap.peek()[0] > distance) {
                    maxHeap.poll();
                    maxHeap.offer(entry);
                }
            } else {
                maxHeap.offer(entry);
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int[] entry = maxHeap.poll();
            res[i] = points[entry[1]];
            i++;   
        }

        return res;
        

        
    }

    private static int squreDistance (int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
// @lc code=end

