import java.util.Arrays;
import java.util.Scanner;

public class dijkstraSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE); 
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            grid[s][e] = v;
            
        }
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        boolean[] visited = new boolean[n + 1];
        
        minDist[1] = 0;

        for (int i = 1; i < n + 1; i++) {
            int minVal = Integer.MAX_VALUE;
            int cur = -1;
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    cur = j;
                } 
            }
            if (cur == -1) {
                break;
            }

            visited[cur] = true;
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j] && grid[cur][j] != Integer.MAX_VALUE && minDist[cur] + grid[cur][j] < minDist[j]) {
                    minDist[j] = minDist[cur] + grid[cur][j];
                }
                
            }
            
        }

        if (minDist[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDist[n]);
        }
    }
    
}
