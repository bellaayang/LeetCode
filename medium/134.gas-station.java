/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalRest = 0;
        int restSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            restSum += gas[i] - cost[i];
            totalRest += gas[i] - cost[i];
            if (restSum < 0) {
                restSum = 0;
                start = (i + 1) % gas.length;
            }     
        }

        if (totalRest < 0) {
            return -1;
        } 

        return start;
        
    }
}
// @lc code=end

