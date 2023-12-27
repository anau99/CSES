package Introductory;

import jdk.jshell.Snippet;

import java.util.Scanner;

public class BitStrings {
  static long MOD = (long) 1e9+7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(solve(2,n)%MOD);

    }
    static long solve(long a,long n){
         long res = 1;
        while (n> 0) {
            if ((n & 1)==1)
                res = res * a%MOD;
            a = a * a%MOD;
            n >>= 1;
        }
        return res;
    }
}
