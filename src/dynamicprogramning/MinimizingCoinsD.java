package dynamicprogramning;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoinsD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[]a = new int[n+1];
        for(int i = 1 ; i <=n;i++){
            a[i] = scanner.nextInt();
        }
        int[]dp = new int[x+1];
        Arrays.fill(dp,-1);
        solve(dp,x,a,n);
        if(dp[x] == Integer.MAX_VALUE)
            System.out.println(-1);

       else System.out.println(dp[x]);
    }
    private static int solve(int[]dp,int x, int[]a,int n){

        if(x==0)
            return 0;
        if(dp[x]!=-1)
            return dp[x];
        int min =Integer.MAX_VALUE;

        for(int i = 1; i <=n;i++){
            if(a[i]<=x){
                int sub= solve(dp,x-a[i],a,n);
                if(sub!=Integer.MAX_VALUE && sub+1<min)
                    min = sub+1;
            }

        }

        dp[x] = min;
        return min;


    }
}
