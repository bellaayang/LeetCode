import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dijkstraHeap {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Edge>> grid = new LinkedList<>();
        for (int i = 0; i < n + 1; i++) {
            grid.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            grid.get(s).add(new Edge(e, v));
        }

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.second - b.second);
        queue.add(new Pair(1, 0));

        boolean[] visited = new boolean[n + 1];
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cur = queue.poll();
            if (visited[cur.first]) {
                continue;
            }

            visited[cur.first] = true;

            for (Edge edge : grid.get(cur.first)) {
                if (!visited[edge.to] && minDist[cur.first] + edge.val < minDist[edge.to]) {
                    minDist[edge.to] = minDist[cur.first] + edge.val;
                    queue.add(new Pair<>(edge.to, minDist[edge.to]));
                }
            }


        }

        if (minDist[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        } else {
            System.out.println(minDist[n]);
            return;
        }





    }
    
}

class Edge {
    public int to;
    public int val;
    public Edge (int to, int val) {
        this.to = to;
        this.val = val;
    }
}

class Pair <U, V> {
    public U first;
    public V second;
    public Pair (U first, V second) {
        this.first = first;
        this.second = second;
    }
}
