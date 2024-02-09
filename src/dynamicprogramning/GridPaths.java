package dynamicprogramning;

import java.util.Arrays;
import java.util.Scanner;

public class GridPaths {
    static int mod = (int) 1e9+7;
   // static int[][] vis;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[]grid = new String[n];
        for(int i = 0; i< n;i++){
            grid[i] = scanner.next();
        }
        if(n==1 && grid[0].charAt(0)=='.'){
            System.out.println(1);
            return;
        }
        long[][]dp = new long[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }
        solve(dp,grid,0,0);
        if(dp[0][0] == -1)
            System.out.println(0);
       else System.out.println(dp[0][0]);
    }
    private static long solve(long[][]dp, String[]grid ,int i, int j){
        if(i< 0 || i >=grid.length || j< 0 || j>=grid.length || grid[i].charAt(j)=='*' )
            return 0;
        if(i==grid.length-1 && j == grid.length-1)
            return 1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        long ans = 0;
        ans+= solve(dp,grid,i+1,j) % mod;
        ans+= solve(dp,grid,i,j+1)%mod;
        dp[i][j] = ans%mod;
        return ans;
    }

}
