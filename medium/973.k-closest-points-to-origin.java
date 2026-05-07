/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pqueue = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for (int i = 0; i < points.length; i++) {
            int distance = squreDistance(points[i]);
            int[] entry = new int[] {distance, i};
            if (pqueue.size() < k) {
                pqueue.add(entry);
            } else {
                int[] maxDistance = pqueue.peek();
                if (maxDistance[0] > entry[0]) {
                    pqueue.poll();
                    pqueue.add(entry);
                } 
            }       
        }

       int[][] result = new int[k][2];
       int i = 0;
       while (!pqueue.isEmpty()) {
        int idx = pqueue.poll()[1];
        result[i] = points[idx];
        i++;

       }
       return result;

        
    }

    private static int squreDistance (int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
// @lc code=end

