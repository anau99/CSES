package SortingandSearching;

import java.util.HashMap;
import java.util.Scanner;

public class SubarrayDivisibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]a = new int[n+1];
        HashMap<Long,Integer>hashMap = new HashMap<>();
        long cnt = 0;
        long[]prefix = new long[n+1];
        for(int i = 1; i <= n;i++){
            int x = scanner.nextInt();
            a[i] = x;

        }
        for(int i = 1; i<=n;i++){
            prefix[i] = prefix[i-1] + a[i]%n;
            prefix[i]= (prefix[i]+n)%n;

        }

        hashMap.put(0L,1);
        for(int i = 1; i<=n;i++){
            if(hashMap.containsKey(prefix[i])){
                cnt+=hashMap.get(prefix[i]);
                hashMap.put(prefix[i],hashMap.get(prefix[i])+1);
            }
            else hashMap.put(prefix[i],1);
        }
        System.out.println(cnt);


    }
}
