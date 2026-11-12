/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMax++;
                leftMin++;
            } else if (c == ')') {
                leftMax--;
                leftMin--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMin < 0) {
                leftMin = 0;
            }

            if (leftMax < 0) {
                return false;
            }
        }

        return leftMin == 0;
        
    }
}
// @lc code=end

