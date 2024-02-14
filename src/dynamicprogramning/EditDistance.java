package dynamicprogramning;

import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
//        s =' '+s;
//        t=' '+t;
        int m = s.length();
        int n = t.length();
        int[][]dp = new int[m+1][n+1];
        for(int i =1;i<=m;i++){
            dp[i][0] = i;
        }
        for(int i =1;i<=n;i++){
            dp[0][i] = i;
        }

        for(int i = 1 ; i<=m;i++){
            for(int j = 1; j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    if(i!=0 && j!=0){
                        int min = Math.min(dp[i-1][j-1],dp[i][j-1]);
                        dp[i][j] = Math.min(min,dp[i-1][j])+1;
                    }

                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
