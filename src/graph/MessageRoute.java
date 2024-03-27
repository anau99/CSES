package graph;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.*;

public class MessageRoute {
    static int[]prev;
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
        prev = new int[n+1];
        //bfs
        bfs(1,vis,graph);
        if(vis[n]){
            List<Integer>ans = new ArrayList<>();
            ans.add(n);
            int t = prev[n];
            while (t!=1){
                ans.add(t);
                t = prev[t];
            }
            ans.add(1);
            System.out.println(ans.size());
            for(int i = ans.size()-1;i>=0;i--){
                System.out.print(ans.get(i)+" ");
            }

        }
        else {
            System.out.print("IMPOSSIBLE");
        }

    }
    static void bfs(int src , boolean[]vis, List<List<Integer>> graph ){
        vis[src] = true;
        Queue<Integer>q = new ArrayDeque<>();
        q.add(src);
        while (!q.isEmpty()){
            int peek = q.poll();
            for(int child : graph.get(peek)){
                if(!vis[child]){
                    prev[child] = peek;
                    vis[child] = true;
                    q.add(child);
                }
            }
        }
    }
}
