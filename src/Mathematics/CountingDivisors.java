package Mathematics;

import java.util.Scanner;

public class CountingDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            int x = scanner.nextInt();
            //System.out.println();
            int cnt = 2;
            for(int j = 2; j*j<=x;j++){
                if(x%j==0){
                    if(x/j == x/(x/j))
                        cnt++;
                    else cnt+=2;
                }
            }
            System.out.println(cnt);
        }
    }
}