//完全背包

import java.util.Scanner;

public class complete {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bagWeight = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < weight.length; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[][] dp = new int[n][bagWeight + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int j = weight[0]; j < bagWeight + 1; j++) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < bagWeight + 1; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
            }

                }
                
        }

        System.out.println(dp[n - 1][bagWeight]); 

     
        
    }
    
}
