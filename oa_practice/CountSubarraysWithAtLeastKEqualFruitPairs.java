package oa_practice;

import java.util.HashMap;

public class CountSubarraysWithAtLeastKEqualFruitPairs {
    public long countFruitPairSubarrays(int[] fruits, int k) {
        // write your code here
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int r = 0;
        int pairs = 0;
        long res = 0;

        for (int l = 0; l < fruits.length; l++) {
            while (r < fruits.length && pairs < k) {
                cnt.put(fruits[r], cnt.getOrDefault(fruits[r], 0) + 1);
                if (cnt.get(fruits[r])  % 2 == 0) {
                    pairs++;
                }
                r++;
            }

            if (pairs >= k) {
                res += fruits.length - r + 1;
            }

            int x = fruits[l];
            int c = cnt.get(x);
            if (c % 2 == 0) {
                pairs--;
            }
            cnt.put(x, c - 1);
        }

        return res;
    }
    
}
