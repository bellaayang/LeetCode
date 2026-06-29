import java.util.*;

public class sinkIsletDFS {
    static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void dfs(int[][] graph, int x, int y) {
        graph[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];

            if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
                continue;
            }

            if (graph[nextX][nextY] == 1) {
                dfs(graph, nextX, nextY);
            }
            
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            if (graph[i][0] == 1) {
                dfs(graph, i, 0);
            }
            if (graph[i][m - 1] == 1) {
                dfs(graph, i, m - 1);
            }
            
        }

        for (int i = 0; i < m; i++) {
            if (graph[0][i] == 1) {
                dfs(graph, 0, i);
            }
            if (graph[n - 1][i] == 1) {
                dfs(graph, n - 1, i);
            }
            
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    graph[i][j] = 0;
                }
                
            }
            
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 2) {
                    graph[i][j] = 1;
                }
                
            }
            
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
}
