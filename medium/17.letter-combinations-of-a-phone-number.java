/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder path = new StringBuilder();
    List<String> result = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        int index = 0;
        backtracking(digits, index, numString);
        return result;
        
    }

    private void backtracking (String digits, int index, String[] numString) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String str = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            backtracking(digits, index + 1, numString);
            path.deleteCharAt(path.length() - 1);
            
        }

    }
}
// @lc code=end

