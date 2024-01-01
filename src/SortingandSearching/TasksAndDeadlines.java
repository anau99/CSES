package SortingandSearching;

import java.util.Arrays;
import java.util.Scanner;

public class TasksAndDeadlines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][]a = new int[n][2];
        for(int i = 0; i < n;i++){
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        Arrays.sort(a,(x,y)->x[0]-y[0]);
        long ans = a[0][1] - a[0][0];
        long timeFinish = a[0][0];
        for(int i = 1; i < n;i++){
            timeFinish+= a[i][0];
           // System.out.println(timeFinish);
            ans+=(long) a[i][1]- timeFinish;
        }
        System.out.println(ans);

    }
}
