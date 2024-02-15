package graph;

import java.util.Scanner;

public class CountingRooms {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] grid = new String[n];
        for(int i = 0; i  < n; i++){
            grid[i] = scanner.next();
        }
        int[][]visit = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m;j++){
                if(visit[i][j] == 0 && grid[i].charAt(j)!='#'){
                    dfs(i,j,visit,grid);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    static  void  dfs(int i, int j, int[][] visit,String[] grid ){
        visit[i][j] = 1;
        int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[]  di : dir){
            int r = di[0] + i;
            int c = di[1] + j;
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length() && visit[r][c]==0 && grid[r].charAt(c)!='#')
                dfs(r,c,visit,grid);

        }
    }
}
