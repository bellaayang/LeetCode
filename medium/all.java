import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class all {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void dfs(List<LinkedList<Integer>> graph, int x, int n) {
        if (x == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i : graph.get(x)) {
            path.add(i);
            dfs(graph, i, n);
            path.remove(path.size() - 1);
        }

    }

    public static void main (String args[]) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<LinkedList<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new LinkedList<>());   
        }

        while (m > 0) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            graph.get(s).add(t);
            m--;
        }

        path.add(1);
        dfs(graph, 1, n);

        if (result.isEmpty()) {
            System.out.println(-1);
        }

        for (List<Integer> re : result) {
            for (int i = 0; i < re.size() - 1; i++) {
                System.out.print(re.get(i) + " ");
            }
            System.out.println(re.get(re.size() - 1));
        }
        
    }

    
}
