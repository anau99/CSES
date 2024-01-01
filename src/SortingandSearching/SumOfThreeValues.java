package SortingandSearching;

import java.util.*;

public class SumOfThreeValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //  long ans = n;
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[][]a = new int[n+1][2];
        for(int i = 1; i<=n;i++){
            a[i][0] = scanner.nextInt();
            a[i][1] = i;
        }
        Arrays.sort(a,(f,k)->f[0]-k[0]);
        List<Integer>ans = new ArrayList<>();
        for(int i = 1; i <=n;i++){
            boolean isok = false;
            for(int j = i+1;j<=n;j++){
                int l = 0, r=n;
                while (l<=r){
                    int mid = l+(r-l)/2;
                    if(a[mid][0]==x-a[i][0]-a[j][0]){
                        ans.add(a[i][1]);
                        ans.add(a[j][1]);
                        ans.add(a[mid][1]);
                      //  System.out.println(a[i][1]+" "+a[j][1]+" "+a[mid][1]);
                        isok = true;
                        break;
                    }
                    else if(a[mid][0]>x-a[i][0]-a[j][0])
                        l = mid+1;
                    else r= mid-1;
                }
                if(isok)break;
            }
            if (isok)break;
        }
        if(ans.isEmpty()||ans.size()==0)
            System.out.println("IMPOSSIBLE");
        else {
            for(int i : ans){
                System.out.print(i+" ");
            }
        }


    }
}
