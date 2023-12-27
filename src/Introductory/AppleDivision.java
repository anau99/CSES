package Introductory;

import java.util.Scanner;

public class AppleDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]a = new int[n];
        long total = 0;
        for(int i = 0; i <n;i++){
            a[i] = scanner.nextInt();
            total+=a[i];
        }
        long ans =Integer.MAX_VALUE;
        for(int i = 0; i < 1<<n;i++){
            long sum = 0;
            for(int j = 0; j < n;j++){
                if((i & (1 << j)) > 0){
                  //  System.out.print(a[j]+" ");
                    sum+=a[j];
                }
            }
           // System.out.println();

            ans = Math.min(Math.abs((total-sum)-sum),ans);
        }
        System.out.println(ans);

    }



}
