/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {
    PrefixTree root;

    public Trie() {
        root = new PrefixTree();
    }
    
    public void insert(String word) {
        PrefixTree cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new PrefixTree();
            }
            cur = cur.children[i];
        }
        cur.isLast = true;
    }
    
    public boolean search(String word) {
        PrefixTree cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }

        return cur.isLast;
        
    }
    
    public boolean startsWith(String prefix) {
        PrefixTree cur = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }

        return true;
        
    }
}

class PrefixTree {
    PrefixTree[] children = new PrefixTree[26];
    boolean isLast = false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

