import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;



public class waterFlowDFS {
    public static void dfs (int[][] graph, int x, int y, boolean[][] visited, int preH) {
        if (x < 0 || x >= graph.length || y < 0 || y >= graph[0].length || visited[x][y]) {
            return;
        }
        
        if (!visited[x][y] && graph[x][y] >= preH) {
            visited[x][y] = true;
            dfs(graph, x + 1, y, visited, graph[x][y]);
            dfs(graph, x - 1, y, visited, graph[x][y]);
            dfs(graph, x, y + 1, visited, graph[x][y]);
            dfs(graph, x, y - 1, visited, graph[x][y]);
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

        boolean[][] oneArray = new boolean[n][m];
        boolean[][] twoArray = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(graph, i, 0, oneArray, Integer.MIN_VALUE);
            dfs(graph, i, m - 1, twoArray, Integer.MIN_VALUE);
            
        }

        for (int i = 0; i < m; i++) {
            dfs(graph, 0, i, oneArray, Integer.MIN_VALUE);
            dfs(graph, n - 1, i, twoArray, Integer.MIN_VALUE);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (oneArray[i][j] && twoArray[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        for (List<Integer> res : result) {
            for (int i = 0; i < res.size(); i++) {
                if (i == 0) {
                    System.out.print(res.get(0) + " ");
                } else {
                    System.out.println(res.get(i));
                }
                
            }
        }

        


    }
    
}
