import java.util.Scanner;

public class redundantConnection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Joint joint = new Joint(n);
        int sResult = -1;
        int tResult = -1;
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            if (!joint.isConnected(s, t)) {
                joint.union(s, t);
            } else {
                sResult = s;
                tResult = t;

            }
        }

        System.out.println(sResult + " " + tResult);

        
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
        return find(x) == find (y);
    }
}
