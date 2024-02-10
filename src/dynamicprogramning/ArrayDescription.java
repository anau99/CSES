package dynamicprogramning;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDescription {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[]a = new int[n];
        for(int i = 0; i< n;i++){
            a[i] = scanner.nextInt();
        }
        long[][]dp = new long[n][m+1];
        int mod=1000000007;
        if(a[0]==0)
            Arrays.fill(dp[0],1);
        else dp[0][a[0]]=1;
        for(int i =1; i < n;i++){
            if(a[i]==0){
                for(int j = 1; j<=m;j++){
                    int[]neighbor = new int[]{j-1,j,j+1};
                    for(int k : neighbor){
                        if(k>=1 && k<=m){
                            dp[i][j] +=dp[i-1][k];
                            dp[i][j]%=mod;
                        }
                    }
                }
            }
            else {
                int[]neighbor = new int[]{a[i]-1,a[i],a[i]+1};
                for(int k : neighbor){
                    if(k>=1 && k<=m){
                        dp[i][a[i]] +=dp[i-1][k];
                        dp[i][a[i]]%=mod;
                    }
                }
            }
        }
        long ans = 0;
        for(int j= 1; j <=m;j++){
            ans +=dp[n-1][j];
            ans%=mod;
        }
        System.out.println(ans);


    }

}
