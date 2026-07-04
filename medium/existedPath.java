import java.util.Scanner;

public class existedPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Joint joint = new Joint(n + 1);
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            joint.union(s, t);
            
        }

        int source = sc.nextInt();
        int destination = sc.nextInt();

        if (joint.isConnected(source, destination)) {
            System.out.println(1);
            return;
        } else {
            System.out.println(0);
            return;
        }





    }

    
}

class Joint {
        int[] parent;
        public Joint(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
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

       
        public void union (int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);

        }

    }
    
