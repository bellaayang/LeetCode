import java.util.*;
public class bellmanFord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int val = sc.nextInt();
            edges.add(new Edge(from, to, val));
            
        }

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        for (int i = 1; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (minDist[edge.from] != Integer.MAX_VALUE && minDist[edge.from] + edge.val < minDist[edge.to]) {
                    minDist[edge.to] = minDist[edge.from] + edge.val;
                }
            }
            
        }

        if (minDist[n] == Integer.MAX_VALUE) {
            System.out.println("unconnected");
        } else {
            System.out.println(minDist[n]);
        }

        


    }
    
}

class Edge {
    public int from;
    public int to;
    public int val;
    public Edge (int from, int to, int val) {
        this.from = from;
        this.to = to;
        this.val = val;
    }
}
