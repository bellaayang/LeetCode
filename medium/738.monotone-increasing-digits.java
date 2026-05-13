/*
 * @lc app=leetcode id=738 lang=java
 *
 * [738] Monotone Increasing Digits
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        String[] str = (n + "").split("");
        int start = str.length;
        for (int i = str.length - 1; i > 0; i--) {
            if (Integer.parseInt(str[i - 1]) > Integer.parseInt(str[i])) {
                str[i - 1] = (Integer.parseInt(str[i - 1]) - 1) + "";
                start = i;
            }     
        }

        for (int i = start; i < str.length; i++) {
            str[i] = "9";     
        }

        return Integer.parseInt(String.join("", str));
        
    }
}
// @lc code=end

