import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bellmanFordQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> edges = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>()); // 先把每个节点对应的空列表建好
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int val = sc.nextInt();
            edges.get(from).add(new Edge(from, to, val));
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] inQueue = new boolean[n + 1];

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        queue.offer(1);
        inQueue[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            inQueue[cur] = false;

            for (Edge edge : edges.get(cur)) {
                if (minDist[edge.from] + edge.val < minDist[edge.to]) {
                    minDist[edge.to] = minDist[edge.from] + edge.val;
                    if (!inQueue[edge.to]) {
                        queue.offer(edge.to);
                        inQueue[edge.to] = true;
                    }

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

    public Edge(int from, int to, int val) {
        this.from = from;
        this.to = to;
        this.val = val;
    }
}
