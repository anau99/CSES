package SortingandSearching;

import java.util.Scanner;

public class SubarraySumsI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x= scanner.nextInt();
        int[]a = new int[n];
        long ans = 0;
        long currentSum = 0;
        for(int i = 0; i < n;i++){
            a[i] = scanner.nextInt();
        }
        int i = 0, j = 0;
        while (i<n){
            while (currentSum<x && j<n){
                currentSum+= a[j];
                j++;
            }
            if(currentSum==x){
                ans++;
            }
            currentSum-=a[i];
            i++;
        }
        System.out.println(ans);
    }
}
