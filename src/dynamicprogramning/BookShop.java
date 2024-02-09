package dynamicprogramning;

import java.util.Map;
import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[]prices = new int[n];
        int[]pages = new int[n];
        int[][]dp = new int[n+1][x+1];
        for(int i = 0; i < n;i++){
            prices[i] = scanner.nextInt();
        }
        for(int i = 0; i < n;i++){
            pages[i] = scanner.nextInt();
        }
        for(int i = 1; i <=n;i++){
            for(int j = 1 ; j <=x;j++){
                dp[i][j] = dp[i-1][j];
                if(j-prices[i-1]>=0)
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-prices[i-1]] + pages[i-1] );
            }
        }
        System.out.println(dp[n][x]);

    }
}
