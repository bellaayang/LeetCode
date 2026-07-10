import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class all {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            grid.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            grid.get(s).add(t);
        }

        path.add(1);

        dfs(grid, 1, n);
        if (result.isEmpty()) {
            System.out.println(-1);
            return;
        }
        
        for (List<Integer> res : result) {
            for (int i = 0; i < res.size() - 1; i++) {
                System.out.print(res.get(i) + " ");
                
            } 
            System.out.println(res.get(res.size() - 1));
            
        }

    }

    static void dfs(List<List<Integer>> grid, int x, int n) {
        if (x == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i : grid.get(x)) {
            path.add(i);
            dfs(grid, i, n);
            path.remove(path.size() - 1);
        }


    }
}