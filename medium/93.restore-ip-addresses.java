/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<String> result = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return result;
        
    }

    private void backtracking (String s, int startIndex, int dotNum) {
        if (dotNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                dotNum++;
                backtracking(s, i + 2, dotNum);
                dotNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
                  
        }
        
    }

    private boolean isValid(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return false;
        }
        if (s.charAt(startIndex) == '0' && startIndex != endIndex) {
            return false;
        }
        int num = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255 || num < 0) {
                return false;
            }
            
        }
        return true;
        
    }



}
// @lc code=end

