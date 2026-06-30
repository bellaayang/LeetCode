import java.util.Scanner;

public class islandPerimeter {
    static int[][] direction = {{1, 0}, {0 , 1}, {-1 , 0}, {0, -1}};
    static int perimeter = 0;
    public static void helper (int[][] graph, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];

            if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length || graph[nextX][nextY] == 0) {
                perimeter++;
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
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    helper(graph, i, j);
                }
                
            }
            
        }

        System.out.println(perimeter);
    }
    
}
