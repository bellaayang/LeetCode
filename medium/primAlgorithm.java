import java.util.Arrays;
import java.util.Scanner;

public class primAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        int[][] graph = new int[v + 1][v + 1];
        for (int i = 0; i < v + 1; i++) {
            Arrays.fill(graph[i], 10001);
            
        }
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int val = sc.nextInt();
            graph[v1][v2] = val;
            graph[v2][v1] =val;
        }

        int[] minDist = new int[v + 1];
        boolean[] included = new boolean[v + 1];

        Arrays.fill(minDist, 10001);

        for (int i = 1; i < v; i++) {
            int minVal = Integer.MAX_VALUE;
            int addIndex = -1;
            for (int j = 1; j < v + 1; j++) {
                if (!included[j] && minDist[j] < minVal) {
                    addIndex = j;
                    minVal = minDist[j];
                }
            }
            included[addIndex] = true;

            for (int j = 1; j < v + 1; j++) {
                if (!included[j] && graph[addIndex][j] < minDist[j]) {
                    minDist[j] = graph[addIndex][j];
                }
            }
            
        }

        int result = 0;
        for (int i = 2; i < v + 1; i++) {
            result += minDist[i];
            
        }

        System.out.println(result);
    }
    
}
