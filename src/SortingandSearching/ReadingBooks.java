package SortingandSearching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ReadingBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      //  long ans = n;
        int n = scanner.nextInt();
        long ans = 0, max = -1;
        for(int i = 0;i <n;i++){
            int time = scanner.nextInt();
            ans+=time;
            max = Math.max(time,max);

        }
        System.out.println(Math.max(2*max,ans));

    }
}
