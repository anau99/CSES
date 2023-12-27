package Introductory;

import java.util.Scanner;

public class TowerOfHanoi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println((int)(Math.pow(2,(double) n)-1));
        solve(n,1,2,3);
    }
    public static void solve(int n, int a, int b, int c){
        if(n==0){
            return;
        }
        solve(n-1,a,c,b);
        System.out.println(a +" "+c);
        solve(n-1,b,a,c);
    }
}
