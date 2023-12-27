package Introductory;

import java.util.Scanner;

public class TwoKnights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i<=n;i++){
            long ans =(long) i*i*(i*i-1)/2 -(long) 4*(i-2)*(i-1);
            System.out.println(ans);
        }
        scanner.close();

    }
}
