package Mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeMultiples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int k = scanner.nextInt();
        long[]primes = new long[k];
       // long min = (long) (1e18+1);
        for(int i = 0;i<k;i++){
            primes[i] = scanner.nextLong();
        }
        long[]cntDivisors = new long[k+1];
        for(int mask =1; mask<(1<<k);mask++){
            int numbersDivisor =0;
            long tmp = n;
            for(int i =0;i<k;i++){
                if(((1<<i)&mask)>0){
                    numbersDivisor++;
                    tmp/=primes[i];
                }
            }
            cntDivisors[numbersDivisor]+=tmp;
        }
        long ans = 0;
        for(int i = 1; i<=k;i++){
            if(i%2==0)
                ans-= cntDivisors[i];
            else ans+=cntDivisors[i];
        }

        System.out.println(ans);


    }
}
