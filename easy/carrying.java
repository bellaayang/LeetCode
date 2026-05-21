/*
Problem Description
Xiao Ming is a scientist who needs to attend an important international scientific conference to present his latest research results. He needs to bring some research materials, but his luggage space is limited. These materials include experimental equipment, literature, and experimental samples, each of which occupies a certain amount of space and has a specific value.
Xiao Ming's total luggage capacity is N. The goal is to help Xiao Ming decide which materials to bring to maximize the total value. Each type of research material can only be selected once (you either pick it or you don't; materials cannot be divided or cut).

Input Description
The first line contains two positive integers: M representing the number of types of research materials, and N representing Xiao Ming's total luggage capacity.
The second line contains M positive integers, representing the space occupied by each research material.
The third line contains M positive integers, representing the value of each research material.

Output Description
Output a single integer representing the maximum total value of the research materials that Xiao Ming can carry.

Sample Input
6 1
2 2 3 1 5 2
2 3 1 5 4 3
Sample Output
5

Hint
Xiao Ming has 6 types of research materials available, but the luggage capacity is only 1. Among the materials, the one that occupies exactly 1 unit of space has a value of 5. Therefore, the maximum value he can carry is 5.

Data Range
1 <= N <= 5000
1 <= M <= 5000
The space and value of each research material are less than or equal to 1000.
**/

import java.util.Scanner;

public class carrying {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // the number of types of research materials
        int N = sc.nextInt(); // Xiao Ming's total luggage capacity

        int[] weight = new int[M];
        int[] value = new int[M];

        for (int i = 0; i < M; i++) {
            weight[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            value[i] = sc.nextInt();
        }

        /*
        int[][] dp = new int[M][N + 1];
        for (int i = 0; i < M; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < N + 1; i++) {
            if (weight[0] <= i) {
                dp[0][i] = value[0];
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
                }
                
            }
            
        }

        System.out.println(dp[M - 1][N]); 
        */

        int[] dp = new int[N + 1];

        for (int i = 0; i < M; i++) {
            for (int j = N; j > 0; j--) {
                if (weight[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
                
            }
            
        }
        System.out.println(dp[N]);
        
    }
    
    
}
