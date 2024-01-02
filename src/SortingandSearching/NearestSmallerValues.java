package SortingandSearching;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class NearestSmallerValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //  long ans = n;
        int n = scanner.nextInt();
        int[]ans = new int[n+1];
        int[]a = new int[n+1];
        Stack<int[]>stack = new Stack<>();
        for(int i = 1; i <= n;i++){
            int x = scanner.nextInt();
            a[i] = x;
        }
        for(int i = 1;i<=n;i++){
            while (!stack.empty() && stack.peek()[0]>=a[i]){
                stack.pop();
            }
            if(!stack.empty())
                ans[i] = stack.peek()[1];
            stack.push(new int[]{a[i],i});
        }
        for(int i = 1; i <=n;i++){
            System.out.print(ans[i]+" ");
        }


    }
}
