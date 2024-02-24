package Mathematics;

import java.util.Scanner;

public class CountingCoprimePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]a = new int[n];
        int max = 0;
        for(int i =0; i < n;i++){
            a[i] = scanner.nextInt();
            max = Math.max(a[i],max);
        }
        int[]cnt = new int[max+1];
        for(int i =0;i<n;i++){
            cnt[a[i]]++;
        }
        int[]primeLeast = new int[max+1];
        int[]mobius = new int[max+1];
        lestPrime(primeLeast);
        mobius(mobius,primeLeast);
//        for(int i = 1; i <=max;i++){
//            System.out.println(i+ ": "+mobius[i]);
//        }
        System.out.println(solve(cnt,mobius));


    }

    static long solve(int[]cnt, int[]mobius){
        long ans= 0;
        for(int i =1; i<mobius.length;i++){
            if(mobius[i]==0) continue;
            long d = 0;
            for(int j=i;j<mobius.length;j+=i){
                d+=cnt[j];
            }
            ans +=d*(d-1)/2*mobius[i];
        }
        return ans;
    }

    //Finding min|xi of Xi ( 1<=xi<=n)
    static void lestPrime(int[]primeLeast){
        for(int i = 2;i<primeLeast.length;i++){
            if(primeLeast[i]==0){
                for(int j =i;j<primeLeast.length;j+=i){
                    if(primeLeast[j]==0){
                        primeLeast[j] = i;
                    }

                }
            }

        }
    }

    //Mobius
    static void mobius(int[]mobius, int[]primesLeast){
        for(int i = 1; i<mobius.length;i++){
            if(i==1){
                mobius[i] = 1;
            }
            else {
                if(primesLeast[i/primesLeast[i]]==primesLeast[i])
                    mobius[i]=0;
                else
                    mobius[i] = -1*mobius[i/primesLeast[i]];
            }
        }
    }
}
