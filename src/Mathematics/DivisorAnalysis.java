package Mathematics;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DivisorAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long numberOfDivisor = 1;
        long sumOfDivisors = 1;
        long productOfDivisors=1;
        long cnt2 = 1;
        final long mod =(long) (1e9)+7;
        for(int i =0; i < n;i++){
            long x = scanner.nextInt();
            long pow = scanner.nextLong();
            numberOfDivisor =  multipleModule(numberOfDivisor,pow+1,mod);
            numberOfDivisor%=mod;
            long temp = pW(x,pow+1,mod)-1;
            temp%=mod;
            long k = pW(x-1,mod-2,mod);
            temp = multipleModule(temp,k,mod);
            temp%=mod;
            sumOfDivisors = multipleModule(sumOfDivisors,temp,mod);
            sumOfDivisors%=mod;
            productOfDivisors = pW2(productOfDivisors,pow+1,mod)*
                    pW2(pW2(x,(pow*((pow+1)/2)),mod),cnt2,mod)%mod;
            productOfDivisors %=mod;
            cnt2 = cnt2*(pow+1)%(mod-1)%mod;
            cnt2%=mod;


        }


        System.out.println(numberOfDivisor +" "+ sumOfDivisors +" " + productOfDivisors);
    }


    private static long multipleModule(long a, long b, long mod){
        long res = 0;
        a%=mod;
        while (b>0){
            if((b&1)>0){
                res = (res + a)%mod;
            }
            // Here we assume that doing 2*a
            // doesn't cause overflow
            a = (2 * a) % mod;

            b >>= 1; // b = b / 2
        }
        return res;
    }

    static long pW(long a, long b, long mod){
        if(b==0)
            return 1;
        long res = pW(a,b/2,mod)%mod;
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
    static long pW2(long base, long pow, long MOD){
        long ans = 1;
        while (pow>0) {
            if ((pow & 1)>0) ans = ans * base % MOD;
            base = base * base % MOD;
            pow >>= 1;
        }
        return ans;
    }
}
