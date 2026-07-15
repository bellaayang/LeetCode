/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class TimeMap {
    HashMap<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
       }

       List<Pair<String, Integer>> values = map.get(key);
       values.add(new Pair<>(value, timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> values = map.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = values.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = (left + right) / 2;
            if (values.get(mid).getValue() <= timestamp) {
                result = values.get(mid).getKey();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
        
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair (K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}



/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

