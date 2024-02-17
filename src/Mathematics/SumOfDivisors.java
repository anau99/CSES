package Mathematics;

import java.util.Scanner;

public class SumOfDivisors {
    static final  int MOD = (int) 1e9+7;
    static final int TWO_MOD_INV = 500000004;
    static long  ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        for(long i = 1, j ;i<=n;i=j){
            long q = n/i;
            j = n/q+1;
            long rangeSumUpToJMinusOne = ((((j%MOD)*((j-1)%MOD)%MOD))%MOD)*expo(2,MOD-2)%MOD;
            long rangeSumUpToIMinusOne=  ((((i%MOD)*((i-1)%MOD)%MOD))%MOD)*expo(2,MOD-2)%MOD;
            long sumQ = (rangeSumUpToJMinusOne - rangeSumUpToIMinusOne+MOD)%MOD;
            ans =( ans + (q%MOD)*sumQ)%MOD;
        }
        System.out.println(ans);

    }
    static long expo(long a, long b){
        if(b==0)
            return 1;
        long res = expo(a,b/2)%MOD;
        if(b%2==1){
            res = res*res %MOD;
            res = res*a%MOD;
        }
        else{
            res= res * res %MOD;
            res%=MOD;
        }
        return res%MOD;
    }
    static long total(long start, long end){
        return ((((end - start + 1) % MOD) * ((start + end) % MOD) % MOD) *
                TWO_MOD_INV % MOD);
    }


    static long inverse(long i){
        if(i==1) return 1;
        return (MOD - ((MOD/i)*inverse(MOD%i))%MOD+MOD)%MOD;
    }

    static void cal(long n){
        for(int i =1; i*i<=n;i++){
            ans = (ans + n/i)%MOD;
            ans%=MOD;
        }
    }
}
