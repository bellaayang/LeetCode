/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        int res = 0;
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return res;
                }

                int length = word.length();
                for (int j = 0; j < length; j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(j)) {
                            continue;
                        }
                        String newWord = word.substring(0, j) + c + word.substring(j + 1);
                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    
                }
                
            }
        }

        return 0;
    }
}
// @lc code=end

