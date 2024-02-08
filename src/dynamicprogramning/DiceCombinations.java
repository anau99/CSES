package dynamicprogramning;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DiceCombinations {
   static   int mod =(int) 1e9+7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[]dp = new long[n+1];
        int[]vis = new int[n+1];
       // Arrays.fill(dp,-1);

        solve(dp,n, vis);
       System.out.println(dp[n]);
    }
    private static long solve(long[]dp, int n,int[]vis){
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        if(vis[n]==1)
            return dp[n];
        long cnt = 0;
        vis[n]=1;
        for(int i  = 1; i <=6;i++){
            cnt =(cnt+ solve(dp,n-i,vis))%mod;
        }
        dp[n] = cnt%mod;
        return cnt%mod;
    }
}
