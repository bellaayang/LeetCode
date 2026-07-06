import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class kruskalAlgroithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][3]; // e行，每行3个数：v1, v2, val
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt(); // v1
            edges[i][1] = sc.nextInt(); // v2
            edges[i][2] = sc.nextInt(); // val
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int result = 0;
        Joint joint = new Joint(v);
        for (int i = 0; i < edges.length; i++) {
            int point1 = edges[i][0];
            int point2 = edges[i][1];

            if (!joint.isConnected(point1, point2)) {
                result += edges[i][2];
                joint.union(point1, point2);

            }
            
        }

        System.out.println(result);

    }

}

class Joint {
    int[] parent;

    public Joint(int n) {
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY) {
            parent[parentX] = parentY;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
