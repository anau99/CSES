package graph;

import java.util.*;

class Point {
    public int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Labyrinth {
   static int dir[][] = new int[][]{ {1,0},{-1,0},{0,1}, {0,-1}};
   static int[][]prev;
   static char[]f = new char[]{'D','U','R','L'};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] grid = new String[n];
        for(int i = 0; i < n;i++){
            grid[i] = scanner.next();
        }
        boolean[][] vis =new boolean[n][m];
        char[]f = new char[]{'D','U','R','L'};
        Point A = new Point(-1,-1);
        Point B = new Point(-1,-1);
        prev = new int[n][m];
        for(int i = 0; i< n;i++){
            for(int j = 0; j < m;j++){
                if(grid[i].charAt(j)=='A'){
                    A.x = i;
                    A.y = j;
                }
               else if(grid[i].charAt(j)=='B'){
                    B.x = i;
                    B.y = j;
                }
            }
        }

        //BFS
        bfs(prev,grid,A,vis);
        if(vis[B.x][B.y]){
            System.out.println("YES");
            StringBuilder sb = new StringBuilder();
            while (A.x!=B.x||A.y!=B.y){
                int prefDir = prev[B.x][B.y];
                sb.append(f[prefDir]);
                B.x = B.x - dir[prefDir][0];
                B.y = B.y - dir[prefDir][1];
            }
            sb.reverse();
            System.out.println(sb.length());
            System.out.println(sb.toString());
        }
        else
            System.out.println("NO");



    }
    static void bfs(int[][]pev,String[]grid, Point A, boolean[][]vis ){
        Queue<Point>queue = new ArrayDeque<>();
     //   vis[A.x][A.y] = true;
        queue.add(A);
        while (!queue.isEmpty()){
            Point peek = queue.poll();
            for(int i = 0; i < 4;i++){
                Point pointNext = new Point(peek.x + dir[i][0], peek.y + dir[i][1]);
                if(pointNext.x >= 0 && pointNext.x<grid.length && pointNext.y>=0 && pointNext.y<grid[0].length()
                    && !vis[pointNext.x][pointNext.y] && grid[pointNext.x].charAt(pointNext.y)!='#'){
                    vis[pointNext.x][pointNext.y] = true;
                    prev[pointNext.x][pointNext.y] = i;
                    queue.add(pointNext);
                }
            }
        }

    }
}
