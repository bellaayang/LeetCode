import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class aStar {
    static int SIZE = 1000;
    static int[][] moves = new int[SIZE + 1][SIZE + 1];
    static int[][] dir = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
    static class Knight {
        int x, y;
        int g;
        int h;
        int f;
        Knight() {

        }
        Knight (int x, int y, int g, int h) {
            this.x = x;
            this.y = y;
            this.g  = g;
            this.h = h;
            this.f = g + h;
        }
    }

    static int b1, b2;

    static int heuristic(int x, int y) {
        return (x - b1) * (x - b1) + (y - b2) * (y - b2);
    }

    static void astar(Knight start) {
        PriorityQueue<Knight> que = new PriorityQueue<>((a, b) -> a.f - b.f);
        que.offer(start);
        while (!que.isEmpty()) {
            Knight cur = que.poll();
            if (cur.x == b1 && cur.y == b2) {
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nextX = cur.x + dir[i][0];
                int nextY = cur.y + dir[i][1];

                if (nextX < 1 || nextX > SIZE || nextY < 1 || nextY > SIZE) {
                    continue;
                }

                if (moves[nextX][nextY] == 0) {
                    moves[nextX][nextY] = moves[cur.x][cur.y] + 1;
                    int nextG = cur.g + 5;
                    int nextH = heuristic(nextX, nextY);
                    que.offer(new Knight(nextX, nextY, nextG, nextH));
                }
                
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int[] move : moves) {
                Arrays.fill(move, 0);
            }
            
            int x = sc.nextInt();
            int y = sc.nextInt();
            b1 = sc.nextInt();
            b2 = sc.nextInt();
            int g = 0;
            int h = heuristic(x, y);
            Knight knight = new Knight(x, y, g, h);

            astar(knight);
            System.out.println(moves[b1][b2]);

            
        }
    }
    
}
