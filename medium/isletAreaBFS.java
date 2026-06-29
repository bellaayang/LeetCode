import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class isletAreaBFS {
    static int area = 0;
    static int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void bfs(int[][] graph, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        graph[x][y] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + directions[i][0];
                int nextY = curY + directions[i][1];
                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
                    continue;
                }
                if (graph[nextX][nextY] == 1) {
                    queue.add(new int[] { nextX, nextY });
                    graph[nextX][nextY] = 0;
                }

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
                bfs(graph, i, 0);
            }
            if (graph[i][m - 1] == 1) {
                bfs(graph, i, m - 1);
            }

        }

        for (int i = 0; i < m; i++) {
            if (graph[0][i] == 1) {
                bfs(graph, 0, i);
            }
            if (graph[n - 1][i] == 1) {
                bfs(graph, n - 1, i);
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    area++;
                }

            }

        }

        System.out.println(area);

    }

}
