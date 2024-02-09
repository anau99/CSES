package dynamicprogramning;

import java.util.Scanner;

public class CoinCombinationsII {
   static int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) { coins[i] = sc.nextInt(); }

        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int w = 0; w <= x; w++) {
                if (w - coins[i] >= 0) {
                    dp[w] = (dp[w] + dp[w - coins[i]]) % MOD;
                }
            }
        }
        System.out.println(dp[x]);


    }
}
