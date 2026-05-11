/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();

        for (String log: logs) {
            int idx = log.indexOf(' ');
            char x = log.charAt(idx + 1);
            if (Character.isDigit(x)) {
                digit.add(log);
            } else {
                letter.add(log);
            }
        }

        letter.sort((a, b) -> {
            int aIdx = a.indexOf(' ');
            int bIdx = b.indexOf(' ');

            String aFirst = a.substring(0, aIdx);
            String aLast = a.substring(aIdx + 1);

            String bFirst = b.substring(0, bIdx);
            String bLast = b.substring(bIdx + 1);

            int cmp = aLast.compareTo(bLast);
            if (cmp != 0) {
                return cmp;
            }
            return aFirst.compareTo(bFirst);

        });

       letter.addAll(digit);
       return letter.toArray(new String[0]);
        
    }
}
// @lc code=end

