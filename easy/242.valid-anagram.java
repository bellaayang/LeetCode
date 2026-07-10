/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < sChar.length; i++) {
            sMap.put(sChar[i], sMap.getOrDefault(sChar[i], 0) + 1); 
        }

        for (int i = 0; i < tChar.length; i++) {
            if (sMap.containsKey(tChar[i]) && sMap.get(tChar[i]) > 0) {
                sMap.put(tChar[i], sMap.get(tChar[i]) - 1);
            } else if ((sMap.containsKey(tChar[i]) && sMap.get(tChar[i]) == 0) || !sMap.containsKey(tChar[i])) {
                return false;
            }
            
        }

        return true;
        
        // if (s.length() != t.length()) {
        //     return false;
        // }

        // char[] sChar = s.toCharArray();
        // char[] tChar = t.toCharArray();
        // Arrays.sort(sChar);
        // Arrays.sort(tChar);
        
        // return Arrays.equals(sChar, tChar);
    }
}
// @lc code=end

