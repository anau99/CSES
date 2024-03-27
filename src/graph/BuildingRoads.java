package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BuildingRoads {
    static List<List<Integer>> list;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        list = new ArrayList<>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for(int i =1;i<=n;i++){
            hashMap.put(i,new ArrayList<>());
        }
        for(int i = 1 ; i<=m;i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            hashMap.get(u).add(v);
            hashMap.get(v).add(u);
        }
        boolean[]vis = new boolean[n+1];
        int cnt = 0;
        for(int i =1; i<=n;i++){
            if(!vis[i]){
                List<Integer>component = new ArrayList<>();
                dfs(hashMap,vis,i,component);
                cnt++;
                list.add(component);
            }
        }
        System.out.println(cnt-1);
        for(int i = 1; i <list.size() ; i++) {
            int x = list.get(i-1).get(0);
            int y = list.get(i).get(0);
            System.out.println(x +" "+y);
        }



    }
    static void dfs(HashMap<Integer,List<Integer>> hashMap , boolean[]vis, int parent,List<Integer>componet){
        vis[parent]= true;
        componet.add(parent);
        for(int child : hashMap.get(parent)){
            if(!vis[child])
                dfs(hashMap,vis,child,componet);

        }
    }
}
