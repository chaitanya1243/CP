import java.util.*;
import java.io.*;

public final class C{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) solve(sc);
    }

    static void solve(Scanner sc){
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int costA[] = new int[n];
        int costB[] = new int[n];
        for(int i=0; i<n; i++) costA[i] = sc.nextInt();
        for(int i=0; i<n; i++) costB[i] = sc.nextInt();


        long ca = cost(grid, costA);
        transpose(grid);
        long cb = cost(grid, costB);
        if(ca == Long.MAX_VALUE || cb == Long.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(ca+cb);
    }

    static long cost(int[][] arr, int c[]){
        int n = c.length;
        long dp[][] = new long[n][2];
        for(var i: dp ) {
            i[0] = Long.MAX_VALUE;
            i[1] = Long.MAX_VALUE;
        }
        dp[0][0] = 0;
        dp[0][1] = c[0];
        for(int i=1; i<n; i++){
            for(int x = 0; x<2; x++){
                for(int y=0; y<2; y++){
                    boolean ok = true;
                    for(int t=0; t<n; t++){
                        ok &= (arr[i-1][t]+y != arr[i][t]+x);
                    }
                    if(ok && dp[i-1][y]!=Long.MAX_VALUE){
                        if(x==0){
                            dp[i][x] = Math.min(dp[i][x], dp[i-1][y]);
                        }else{
                            dp[i][x] = Math.min(dp[i][x], dp[i-1][y]+c[i]);
                        }
                    }
                }
            }
        }
        return Math.min(dp[n-1][0], dp[n-1][1]);
    }

    static void transpose(int arr[][]){
        int n  =arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int t = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = t;
            }
        }
    }
}