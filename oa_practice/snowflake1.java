package oa_practice;

public class snowflake1 {
    static final int MOD = 1_000_000_007;
    public int countPrimeSplits (String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = Math.max(0, i - 8); j < i; j++) {
                if (s.charAt(j) == '0') {
                    continue;
                }

                int val = Integer.parseInt(s.substring(j, i));
                if (isPrime(val)) {
                    dp[i] = (dp[i] + dp[j]) % MOD;
                }

            }
            
        }

        return (int) dp[s.length()];
    }

    private boolean isPrime(int x){
        if (x < 2) {
            return false;
        }

        for (int i = 2; (long) i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
            
        }

        return true;
    }
    
}
