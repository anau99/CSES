package dynamicprogramning;

import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]dp = new int[n+1];
        Arrays.fill(dp,0x3f3f3f3f);
        dp[0] = 0;
        for(int i = 1; i<=n;i++){
            int d = i;
            while (d>0){
                if(d%10!=0){
                    dp[i] = Math.min(dp[i],dp[i-(d%10)]+1);
                }
                d/=10;
            }
        }

        System.out.println(dp[n]);
    }
    public static int greedy(int n){
        int cnt = 0;
        while (n>0){
            int max = -1;
            int k = n;
            while (k>0){
                max = Math.max(max,k%10);
                k/=10;
            }
            n-=max;
            cnt++;
        }
        return cnt;
    }
}
