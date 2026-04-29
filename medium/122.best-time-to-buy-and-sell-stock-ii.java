/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxResult = 0;
        int count = 0;

        if (prices.length == 1) {
            maxResult = 0;
            return maxResult;
        }

        for (int i = 1; i < prices.length; i++) {
            count = prices[i] - prices[i - 1];
            if (count > 0) {
                maxResult += count;
            }
            count = 0;
            
        }
        return maxResult;
        
    }
}
// @lc code=end

