
import java.util.Scanner;

public class islandNumberDFS {
    public static int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void dfs(int[][] graph, int x, int y, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];

            if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
                continue;
            }

            if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                dfs(graph, nextX, nextY, visited);
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

        boolean[][] visited = new boolean[n][m];
        int number = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    visited[i][j] = true;
                    number++;
                    dfs(graph, i, j, visited);
                }
            }
        }

        System.out.println(number);
        

    }
    
}
