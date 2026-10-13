package oa_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortMatrixBorders {

    public int[][] sortMatrixBorderLayers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            List<int[]> path = new ArrayList<>();
            // top
            for (int c = left; c <= right; c++) {
                path.add(new int[]{top, c});
            }

            // right
            for (int r = top + 1; r <= bottom; r++) {
                path.add(new int[]{r, right});
            }

            // bottom
            if (bottom > top) {
                for (int b = right - 1; b >= left; b--) {
                    path.add(new int[]{bottom, b});
                }
            }

            // left
            if (left < right) {
                for (int l = bottom - 1; l > top; l--) {
                    path.add(new int[]{l, left});
                }
            }

            int k = path.size();
            int[] vals = new int[k];
            for (int i = 0; i < k; i++) {
                vals[i] = matrix[path.get(i)[0]][path.get(i)[1]];
            }

            Arrays.sort(vals);

            for (int i = 0; i < k; i++) {
                matrix[path.get(i)[0]][path.get(i)[1]] = vals[i];
            }

            top++;
            bottom--;
            left++;
            right--;

        }

        return matrix;
    
}

}
