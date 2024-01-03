package SortingandSearching;

import java.util.Scanner;

public class ArrayDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[]a = new int[n];
        int max = 0;
        for(int i = 0;i<n;i++){
            a[i] = scanner.nextInt();
            max = Math.max(a[i],max);
        }
        long l = max, r = (long) 1e18;
        long ans = (long) 1e18;
        while (l<=r){
            long mid = (l+r)/2;
            long sum = 1;
            int b = 1;
            for(int i = 0; i < n;i++){
                if(sum+a[i]>mid){
                    b++;
                    sum = 0;
                }
                sum+=a[i];
            }
            if(b>k){
                l = mid+1;
            }
            else {
                ans = Math.min(ans,mid);
                r = mid-1;
            }
        }
        System.out.println(ans);
    }
}
