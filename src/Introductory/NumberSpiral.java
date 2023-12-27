package Introductory;

import java.util.Scanner;

public class NumberSpiral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t;i++){
            Long r = scanner.nextLong();
            Long c = scanner.nextLong();
            if(r>c){
                if(r%2==0)System.out.println(r*r-c+1);
                else System.out.println((r-1)*(r-1)+c);
            }
            else {
                if (c%2==0) System.out.println((c-1)*(c-1) +r);
                else System.out.println(c*c - r+1);
            }
        }
        scanner.close();

    }
}
