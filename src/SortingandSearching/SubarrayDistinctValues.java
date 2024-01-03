package SortingandSearching;

import java.util.HashMap;
import java.util.Scanner;

public class SubarrayDistinctValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[]a = new int[n];
        for(int i = 0; i <n;i++){
            a[i] = scanner.nextInt();
        }
        HashMap<Integer,Integer>hashMap = new HashMap<>();
        long cnt = 0;
        int i = 0, j = 0;
        while (i<n){
            while (j<n &&(hashMap.size()<k ||(hashMap.containsKey(a[j])&& hashMap.get(a[j])>0))) {
                if(hashMap.containsKey(a[j])){
                    hashMap.put(a[j],hashMap.get(a[j])+1);
                }
                else
                    hashMap.put(a[j],1);
                j++;
            }
            cnt +=j-i;
            hashMap.put(a[i],hashMap.get(a[i])-1);
            if(hashMap.get(a[i])==0)
                hashMap.remove(a[i]);
            i++;
        }
        System.out.println(cnt);
    }
}
