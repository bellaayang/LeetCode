import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class topologicalSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> edges = new LinkedList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            edges.add(new LinkedList<>()); // 先给每个节点建一个空列表
        }

        
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            edges.get(s).add(t); // s 的邻居里加入 t（s能到达t）
            inDegree[t]++;
        }
        

        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int start = queue.poll();
            result.add(start);
            for (int point : edges.get(start)) {
                inDegree[point]--;
                if (inDegree[point] == 0) {
                    queue.add(point);
                }
            }

        }

        if (result.size() == n) {
            for (int i = 0; i < result.size() - 1; i++) {
                System.out.println(result.get(i) + " ");

            }
            System.out.println(result.get(n - 1));
        } else {
            System.out.println(-1);
        }

    }

}
