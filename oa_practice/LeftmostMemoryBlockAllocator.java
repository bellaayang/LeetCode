package oa_practice;

import java.util.HashMap;

public class LeftmostMemoryBlockAllocator {
    public int[] processMemoryQueries(int[] memory, int[][] queries) {
        int[] result = new int[queries.length];
        HashMap<Integer, int[]> allocation = new HashMap<>();
        int nextId = 1;

        for (int i = 0; i < queries.length; i++) {
            int form = queries[i][0];
            int v = queries[i][1];
            if (form == 0) {
                int start = -1;
                int len = 0;
                for (int j = 0; j < memory.length; j++) {
                    if (memory[j] == 0) {
                        len++;
                        if (len == v) {
                            start = j - v + 1;
                            break;
                        }
                    } else {
                        len = 0;
                    } 
                }

                if (start != -1) {
                    for (int j = start; j < start + v; j++) {
                        memory[j] = 1;
                    }
                    allocation.put(nextId, new int[]{start, v});
                    nextId++;
                }

                result[i] = start;
            } else if (form == 1) {
               if (!allocation.containsKey(v)) {
                result[i] = -1;
               } else {
                int[] erase = allocation.get(v);
                for (int j = erase[0]; j < erase[0] + erase[1]; j++) {
                    memory[j] = 0;
                }
                allocation.remove(v);
                result[i] = erase[1];

               }
            }
            
        }

        return result;
    
    }

    
}
