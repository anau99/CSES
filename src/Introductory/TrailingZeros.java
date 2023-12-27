package Introductory;

import java.util.Scanner;

public class TrailingZeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n<5)
            System.out.println(0);
        else {
            int cnt = 0;
            for(int i =5; n/i>=1; i*=5){
                cnt= cnt +n/i;
            }
            System.out.println(cnt);
        }
    }
}
