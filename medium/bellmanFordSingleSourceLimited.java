import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class bellmanFordSingleSourceLimited {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge> grid = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int v = sc.nextInt();

            grid.add(new Edge(s, t, v));
        }

        int src = sc.nextInt();
        int dst = sc.nextInt();
        int k = sc.nextInt();

        int[] minDist = new int[n + 1];
        int[] minDistCopy = new int[n + 1];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            minDistCopy = Arrays.copyOf(minDist, n + 1);
            for(Edge edge : grid) {
                int from = edge.from;
                int to = edge.to;
                int val = edge.val;
                if (minDistCopy[from] != Integer.MAX_VALUE && minDistCopy[from] + edge.val < minDist[to]) {
                    minDist[to] = minDistCopy[from] + val;
                }

            }
            
        }

        if (minDist[dst] == Integer.MAX_VALUE) {
            System.out.println("unreachable");
        } else {
            System.out.println(minDist[dst]);
        }
    }
    
}

class Edge {
    public int from;
    public int to;
    public int val;
    public Edge(int from, int to, int val) {
        this.from = from;
        this.to =to;
        this.val = val;
    }
}
