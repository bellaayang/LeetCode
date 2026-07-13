/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new ArrayDeque<>();
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < cars.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        for (int[] car : cars) {
            if (!stack.isEmpty()) {
                if (stack.peek() < (double)(target - car[0]) / car[1]) {
                    stack.push((double)(target - car[0]) / car[1]);
                }
            } else {
                stack.push((double)(target - car[0]) / car[1]);
            }
        }

        return stack.size();
        
    }
}
// @lc code=end

