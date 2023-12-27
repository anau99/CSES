package Introductory;

import java.util.Scanner;

public class TwoSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = (long) n*(n+1)/2;
        if(sum%2!=0)
            System.out.println("NO");
        else {
            long haft = sum/2;
            int[]a = new int[n+1];
            int cnt = 0;
            System.out.println("YES");
            if(n%2!=0){
                int l =1, r = n;
                long curr = 0;
                while (curr!=haft){
                    curr+=l;
                    curr+=r;
                    if(curr>haft){
                        curr-=l;
                        a[l]=0;
                        a[r]=1;
                        cnt++;
                        break;
                    }
                    a[l]=1;
                    a[r]=1;
                    cnt+=2;
                    l++;
                    r--;
                }

                System.out.println(cnt);
                for(int i = 1; i <=n;i++){
                    if(a[i]==1){
                        System.out.print(i+" ");
                    }
                }
                System.out.println();
                System.out.println(n-cnt);
                for(int i = 1;i <=n;i++){
                    if(a[i]==0){
                        System.out.print(i+" ");
                    }
                }
            }
            else {
                long curr = 0;
                int l = 1, r = n;
                while (curr!=haft){
                    curr+=l;
                    curr+=r;
                    a[l]=1;
                    a[r]=1;
                    l++;
                    r--;
                    cnt+=2;
                }
                System.out.println(cnt);
                for(int i = 1; i <=n;i++){
                    if(a[i]==1){
                        System.out.print(i+" ");
                    }
                }
                System.out.println();
                System.out.println(n-cnt);
                for(int i = 1;i <=n;i++){
                    if(a[i]==0){
                        System.out.print(i+" ");
                    }
                }

            }
        }

    }
}
