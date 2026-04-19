/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<String> path = new LinkedList<>();
    List<List<String>> result = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, new StringBuilder());
        return result;
        
    }

    private void backtracking (String s, int startIndex, StringBuilder sb) {
        if (startIndex >= s.length()) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isPalindrome(sb)) {
                path.add(sb.toString());
                backtracking(s, i + 1, new StringBuilder());
                path.removeLast();       
            }       
        }
    }

    private boolean isPalindrome(StringBuilder sb) {
       for (int i = 0; i < sb.length() / 2; i++) {
        if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
            return false;
        }  
       }
       return true;
    }

    
}
// @lc code=end

