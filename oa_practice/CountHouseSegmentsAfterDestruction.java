package oa_practice;

import java.util.HashSet;
import java.util.Set;

public class CountHouseSegmentsAfterDestruction {
    public int[] countHouseSegmentsAfterDestruction(int[] houses, int[] queries) {
        // Write your code here.
        Set<Integer> set = new HashSet<>();
        int[] result = new int[queries.length];
        int idx = 0;
        for (int h : houses) {
            set.add(h);
        }

        int segments = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                segments++;
            }
        }

        for (int q : queries) {
            set.remove(q);
            if (set.contains(q - 1) && set.contains(q + 1)) {
                segments++;
            } else if (!set.contains(q- 1) && !set.contains(q + 1)) {
                segments--;
            }
            result[idx++] = segments;
        }

        return result;
        
            
            
        
    }

    
}
