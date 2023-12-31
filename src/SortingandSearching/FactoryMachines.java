package SortingandSearching;

import java.util.Scanner;

public class FactoryMachines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        long l = 1, r=1;
        long min = (long) (1e9);
        int[]time = new int[n];
        for(int i =0; i < n;i++){
            time[i]= scanner.nextInt();
          //  r = Math.min(time[i]*t,r);
            min = Math.min(min,time[i]);
        }
        r = min*t;
        while (l<=r){
            long mid = l +(r-l)/2;
            long cnt = 0;
            for(int i : time){
                cnt+= mid/i;
            }
            if(cnt>=t){
                r = mid-1;
            }
            else l = mid+1;
        }
        System.out.println(l);

    }
}
