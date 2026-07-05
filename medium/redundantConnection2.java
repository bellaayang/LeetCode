import java.util.Scanner;

public class redundantConnection2 {
    public static boolean hasCycle (int n, int[][] graph, int skipIndex) {
        Joint joint = new Joint(n);
        for (int i = 0; i < graph.length; i++) {
            if (i == skipIndex) {
                continue;
            }
            int s = graph[i][0];
            int t = graph[i][1];
            if (joint.isConnected(s, t)) {
                return true;
            }
            joint.union(s, t);
            
            
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][2];
        int[] inDegree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            graph[i][0] = s;
            graph[i][1] = t;
            inDegree[t]++;
            
        }

        int conflictNode = -1;
        for (int i = 1; i < n + 1; i++) {
            if (inDegree[i] == 2) {
                conflictNode = i;
            }
        }

        if (conflictNode == -1) {
            Joint joint = new Joint(n);
            for (int[] g : graph) {
                if (joint.isConnected(g[0], g[1])) {
                    System.out.println(g[0] + " " + g[1]);
                    return;
                } else {
                    joint.union(g[0], g[1]);

                }
            }

        } else {
            int edgeIndex1 = -1;
            int edgeIndex2 = -1;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (graph[i][1] == conflictNode) {
                    count++;
                    if (count == 1) {
                        edgeIndex1 = i;
                    } else {
                        edgeIndex2 = i;
                    }

                }
                
            }

            if (hasCycle(n, graph, edgeIndex2)) {
                System.out.println(graph[edgeIndex1][0] + " " + graph[edgeIndex1][1]);
            } else {
                System.out.println(graph[edgeIndex2][0] + " " + graph[edgeIndex2][1]);
            }

        }




    }
    
}

class Joint {
    int[] parent;

    public Joint (int n) {
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            
        }
    }

    public int find (int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union (int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY) {
            parent[parentX] = parentY;
        } 
    }

    public boolean isConnected (int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) {
            return true;

        } else {
            return false;
        }
    }
}
