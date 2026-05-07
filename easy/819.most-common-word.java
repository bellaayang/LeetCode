/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedWord = new HashSet<>();
        for (String word : banned) {
            bannedWord.add(word.toLowerCase());
        }

        StringBuilder sb = new StringBuilder();
        char[] wordChar = paragraph.toCharArray();
        int count = 0;
        String result = " ";

        for (int i = 0; i <= wordChar.length; i++) {
            if (i < wordChar.length && Character.isLetter(wordChar[i])) {
                sb.append(Character.toLowerCase(wordChar[i]));
            } else {
                 if (sb.length() > 0) {
                    if (!bannedWord.contains(sb.toString())) {
                     map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                     if (count < map.get(sb.toString())) {
                        count = map.get(sb.toString());
                        result = sb.toString();
                     }
                }
                sb.setLength(0);
                 }

                
            }
            
        }

        return result;





        
    }
}
// @lc code=end

