package Mathematics;

import java.util.Scanner;
public class Exponentiation {
    static int mod = (int) 1e9+7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            System.out.println(solve(a,b));

        }
    }
    static long solve(long a, long b){
        if(b==0)
            return 1;
        long res = solve(a,b/2)%mod;
        if(b%2==1){
            res = res*res %mod;
            res = res*a%mod;
        }
        else res= res * res %mod;
        return res;

    }
}
