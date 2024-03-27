package graph;

import java.util.*;

public class BuildingTeams {
    static boolean[] vis;
    static int[] mark;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
       // HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        vis = new boolean[n+1];
        mark = new int[n+1];

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

        for(int i = 1; i<=n;i++){
            if(!vis[i]){

                DFS(i,graph);
            }
        }
        if(vis[n]){
            for(int i = 1;i <=n;i++){
                System.out.print(mark[i]+" ");
            }
        }
        else {
            System.out.println("IMPOSSIBLE");
        }
    }
//    static void dfs(  List<List<Integer>> graph , int parent){
//        vis[parent] = true;
//
//        for(int child : graph.get(parent)){
//            if(!vis[child]){
//                if(mark[child]==0){
//                    mark[child] = (mark[parent]==1) ? 2 : 1;
//                    dfs(graph,child);
//                }
//            }
//        }
//
//
//    }

    private static boolean DFS(int i, List<List<Integer>> graph ){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(i);
        vis[i] = true;
        mark[i] =1;
        while(stack.size()!=0){
            var node = stack.pop();
            vis[node] = true;
            for(int c : graph.get(node)){
                if(mark[c]== mark[node]) return false;
                if(!vis[c]){
                    if(mark[node]==1) mark[c] = 2;
                    else mark[c] =1;
                    stack.push(c);
                }
            }
        }
        return true;
    }
}
