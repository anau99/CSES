package graph;

import java.util.Arrays;
import java.util.Scanner;

public class ShortestRoutesII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        long[][]dist = new long[n+1][n+1];
        for(int i = 0; i <n+1;i++){
            Arrays.fill(dist[i],Long.MAX_VALUE);
        }
        for(int i = 1 ; i<=m;i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            long w = scanner.nextLong();
            if(w< dist[u][v]){
                dist[u][v] = w;
                dist[v][u] = w;
            }

        }
        //FloydWarshall
        floydWarshall(dist,n);
        for(int i = 1; i <=q;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(a==b){
                System.out.println(0);
            }
            else if(dist[a][b]==Long.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(dist[a][b]);
        }

    }
    static void floydWarshall( long[][]dist, int n){
        for(int k = 1; k <=n;k++){
            for(int i = 1; i <=n;i++){
                for(int j = 1; j<=n;j++){
                    if(dist[i][k] < Long.MAX_VALUE && dist[k][j]<Long.MAX_VALUE ) {
                        dist[i][j] =Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                       // dist[j][i] = dist[i][j];
                    }
                }
            }
        }
    }
}
