import java.util.Scanner;

public class floyd {
    public static int MAX_VAL = 10005;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][][] grid = new int[n + 1][n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    grid[i][j][k] = grid[j][i][k] = MAX_VAL;
                    
                }
                
            }
            
        }

        while(m > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            grid[u][v][0] = grid[v][u][0] = weight;
            m--;
        }

        for(int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    grid[i][j][k] = Math.min(grid[i][j][k - 1], grid[i][k][k - 1] + grid[k][j][k - 1]);

                    
                }
                
            }
        }

        int x = sc.nextInt();
        while (x > 0) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            if (grid[src][dst][n] == MAX_VAL) {
                System.out.println(-1);
            } else {
                System.out.println(grid[src][dst][n]);
            }
            x--;
        }
    }
    
}
