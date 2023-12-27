package Introductory;

import java.util.Scanner;

public class ChessboardAndQueens {
    static boolean[]cols = new boolean[8];
    static boolean[]diag1 = new boolean[16];
    static boolean[]getDiag2 = new boolean[16];
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]grid = new String[8];
        for(int i = 0; i <8;i++){
            grid[i] = scanner.next();
        }
        solve(0,grid);
        System.out.println(ans);

    }

    static void  solve(int r, String[]grid){
        if(r==8){
            ans++;
            return;
        }
        for(int c = 0; c <8;c++){
            if(grid[r].charAt(c)=='.'){
                if(!cols[c] && !diag1[r-c+7] && !getDiag2[r+c]){
                    cols[c] = diag1[r-c+7] = getDiag2[r+c] = true;
                    solve(r+1,grid);
                    cols[c] = diag1[r-c+7] = getDiag2[r+c] = false;
                }
            }
        }
    }
}
