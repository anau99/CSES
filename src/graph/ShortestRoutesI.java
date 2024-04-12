package graph;

import java.util.*;

import static java.util.Comparator.comparingInt;


public class ShortestRoutesI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 1 ; i <=m;i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int c = scanner.nextInt();
            graph.get(u).add(new int[]{v,c});
           // graph.get(v).add(new int[]{u,c});
        }
        long[]distance = new long[n+1];
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[1] = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        priorityQueue.add(new int[]{1,0});
        boolean[]vis = new boolean[n+1];
        while (!priorityQueue.isEmpty()){
            int[] peek = priorityQueue.poll();
            if(vis[peek[0]]) continue;
            vis[peek[0]] = true;
            for( int[]child : graph.get(peek[0])){
                if(distance[child[0]] >distance[peek[0]] + 1L*child[1]){
                    distance[child[0]]=distance[peek[0]] + 1L*child[1];
                    priorityQueue.add(child);

                }

            }
        }
        for(long d : distance){
            if(d!=Long.MAX_VALUE)
                System.out.print(d+" ");
        }


    }
}
