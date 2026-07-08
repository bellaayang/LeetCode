import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bellmanFordNegativeLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> grid = new LinkedList<>();
        for (int i = 0; i < n + 1; i++) {
            grid.add(new LinkedList<>());

        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int v = sc.nextInt();

            grid.get(s).add(new Edge(t, v));
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] inQueue = new boolean[n + 1];
        int[] count = new int[n + 1];
        int[] minDist = new int[n + 1];
        boolean hasLoop = false;

        queue.offer(1);
        inQueue[1] = true;
        count[1]++;
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        while (!queue.isEmpty() && !hasLoop) {
            int cur = queue.poll();
            inQueue[cur] = false;
            for (Edge edge : grid.get(cur)) {
                if (minDist[cur] + edge.val < minDist[edge.to]) {
                    minDist[edge.to] = minDist[cur] + edge.val;
                    if (!inQueue[edge.to]) {
                        queue.offer(edge.to);
                        inQueue[edge.to] = true;
                        count[edge.to]++;

                        if (count[edge.to] == n) {
                            hasLoop = true;
                            break;
                        }
                    }

                }

                
            }

        }

        if (hasLoop) {
            System.out.println("circle");
        } else if (minDist[n] == Integer.MAX_VALUE) {
            System.out.println("unconnected");
        } else {
            System.out.println(minDist[n]);
        }

    }

}

class Edge {
    public int to;
    public int val;

    public Edge(int to, int val) {
        this.to = to;
        this.val = val;
    }
}
