package Mathematics;

import java.util.Scanner;

public class ExponentiationII {
    //static int mod = (int) 1e9+7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mod = (int) 1e9+7;
        while (n-->0){
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            long x = solve(b,c,mod-1);
            System.out.println(solve(a,x,mod));

        }
    }

    static long solve(long a, long b, int mod){
        if(b==0)
            return 1;
        long res = solve(a,b/2,mod)%mod;
        if(b%2==1){
            res = res*res %mod;
            res = res*a%mod;
        }
        else{
            res= res * res %mod;
            res%=mod;
        }
        return res%mod;

    }
}
