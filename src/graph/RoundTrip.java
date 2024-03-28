package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class RoundTrip {
    static List<Integer>ans;
    static boolean isOk = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Integer>> graph = new ArrayList<>(n+1);
        graph.add(new ArrayList<>());
        for(int i = 1; i <=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 1;i <=m;i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[]vis = new boolean[n+1];
        ans = new ArrayList<>();
        for(int i = 1; i <=n;i++){
            // HashSet<Integer>hashSet  = new HashSet<>();
            List<Integer>comp = new ArrayList<>();
            if(!vis[i]) {
                dfs(vis, i, graph, comp,0);
            }

        }
        if(!isOk){
            System.out.println("IMPOSSIBLE");
        }

    }

    static void dfs(boolean[]vis, int current,  List<List<Integer>> graph,List<Integer>comp, int parent){
        if(isOk)
            return;
        if(vis[current]){
            if(comp.size()>2){
                isOk = true;
                int cnt = 1;
                List<Integer>x = new ArrayList<>();
                x.add(current);
                for(int i = comp.size()-1;i>=0;i--){
                    x.add(comp.get(i));
                    cnt++;
                    if(comp.get(i)==current){
                        break;
                    }
                    //else x.add()append(" ");
                }
                System.out.println(x.size());
                for(int i: x){
                    System.out.print(i+" ");
                }
                return;
            }
        }
        vis[current] = true;
        comp.add(current);
        for(int child : graph.get(current)){
            if(child!=parent){
                dfs(vis,child,graph,comp,current);
            }
        }
      //  vis[parent] = false;
        comp.remove(comp.size()-1);

    }
}
