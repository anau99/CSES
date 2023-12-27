package Introductory;

import java.util.Map;
import java.util.Scanner;

public class CoinPiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();

        for(long i = 0; i <t;i++){

            long a = scanner.nextLong();
            long b = scanner.nextLong();
            if(b>a){
                long temp = b;
                b = a;
                a = temp;
            }
            if(a>2*b  || (a+b)%3!=0){
                System.out.println("NO");
            }
            else System.out.println("YES");
         //   System.out.println(sb.toString());

        }
    }
}
