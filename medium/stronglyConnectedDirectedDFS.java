import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class stronglyConnectedDirectedDFS {
    public static void dfs(List<List<Integer>> graph, int key, boolean[] visited) {
        if (visited[key]) {
            return;
        }

        visited[key] = true;
        List<Integer> nextKeys = graph.get(key);
        for (int nextKey : nextKeys) {
            dfs(graph, nextKey, visited);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<List<Integer>> graph = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < k; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            graph.get(s - 1).add(t - 1);
        }

        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }

        }

        System.out.println(1);
    }

}
