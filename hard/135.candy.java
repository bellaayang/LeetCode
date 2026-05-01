/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        int result = 0;

        for (int i = 1; i < candy.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }  else {
                candy[i] = 1;
            }    
        }

        for (int i = candy.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        for (int i = 0; i < candy.length; i++) {
            result += candy[i];     
        }

        return result;



        
    }
}
// @lc code=end

