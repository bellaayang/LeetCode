import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class maxIslandDFS {
    static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int count = 0;
    static int result = 0;
    public static void dfs (int[][] graph, int x, int y, int mark, boolean[][] visited) {
        graph[x][y] = mark;
        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
                continue;
            }
            if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                count++;
                dfs(graph, nextX, nextY, mark, visited);
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
        Map<Integer, Integer> map = new HashMap<>();
        int mark = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    visited[i][j] = true;
                    count = 1;
                    dfs(graph, i, j, mark, visited);
                    map.put(mark, count);
                    mark++;
                }
            }
        }

        boolean isAllLand = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    isAllLand = false;
                }
            }
        }

        if (isAllLand) {
            System.out.println(n * m);
            return;
        }


        Set<Integer> visitedGrid = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 0) continue; // 只处理水格子
                count = 1;
                visitedGrid.clear();
                for (int j2 = 0; j2 < 4; j2++) {
                    int nextX = i + direction[j2][0];
                    int nextY = j + direction[j2][1];

                    if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
                        continue;
                    }

                    if (visitedGrid.contains(graph[nextX][nextY])) {
                        continue;
                    }

                    count += map.getOrDefault(graph[nextX][nextY], 0);
                    visitedGrid.add(graph[nextX][nextY]);
                    
                }
                result = Math.max(result, count);
                
            }
            
        }

        System.out.println(result);
    }
    
}
