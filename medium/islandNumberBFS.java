
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class islandNumberBFS {
    public static int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

    public static void bfs (int[][] graph, int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + directions[i][0];
                int nextY = curY + directions[i][1];

                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
                    continue;
                }

                if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
                
            }
        }
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int number = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }    
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    number++;
                    bfs(graph, i, j, visited);
                }
                
            }
            
        }

        System.out.println(number);


    }
    
}
