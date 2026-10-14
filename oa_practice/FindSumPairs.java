package oa_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSumPairs {
    public int[] solution(int[] a, int[] b, int[][] queries) {
        HashMap<Integer, Integer> bMap = new HashMap<>(); // b[i], frequency
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            bMap.put(b[i], bMap.getOrDefault(b[i], 0) + 1);
        }

        for (int i = 0; i < queries.length; i++) {
            int form = queries[i][0];
            if (form == 0) {
                a[queries[i][1]] = queries[i][2];
            } else if (form == 1) {
                int count = 0;
                for (int j = 0; j < a.length; j++) {
                    int target = queries[i][1] - a[j];
                    if (bMap.containsKey(target)) {
                        count += bMap.get(target);
                    }
                }
                result.add(count);
                
            }
            
        }

        int[] res = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;

        
  
    }
    
}
