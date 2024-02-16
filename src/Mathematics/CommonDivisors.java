package Mathematics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class CommonDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]a = new int[n];
        for(int i = 0; i< n; i++){
            int x = scanner.nextInt();
            a[i] = x;
        }
        int[]cnt = new int[(int) 1e6+1];
     //   solveMethodOne(n,a,cnt);
        solveMethodTwo(n,a,cnt);

    }
    public static void solveMethodOne(int n, int[]a ,int[]cnt){
        for(int i = 0; i <n;i++){
            for(int j = 1; j*j<a[i];j++){
                if(a[i]%j==0){
                    cnt[j]++;
                    if(j!=a[i]/j){
                        cnt[a[i]/j]++;
                    }
                }
            }
        }
        for(int i =(int) 1e6 ;i>=1;i--){
            if(cnt[i]>=2){
                System.out.println(i);
                break;
            }
        }
    }

    public static void solveMethodTwo(int n, int[]a ,int[]cnt){
        for(int i  : a) cnt[i]++;
        for(int i = (int) 1e6;i>=1;i--){
            int x = 0;
            //xet cac boi so cua x
            for(int j =i; j<=(int) 1e6;j+=i){
                x+=cnt[j];
            }
            if(x>=2){
                System.out.println(i);
                break;
            }
        }
    }
}
