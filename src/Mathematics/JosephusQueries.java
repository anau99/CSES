package Mathematics;

import java.util.Scanner;

public class JosephusQueries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        while (q>0){
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            System.out.println(solve((int) n,(int) k));
            q--;
        }
    }
    static int solve(int n, int k){
        if(n==1)
            return 1;
        if(k<=(n+1)/2){
            if(2*k>n) return (2*k)%n;
            else return 2*k;
        }
        int temp = solve(n/2,k-(n+1)/2);
        if(n%2==1){
            return 2*temp+1;
        }
        return 2*temp-1;

    }
}
