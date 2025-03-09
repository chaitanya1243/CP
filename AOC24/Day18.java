import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = 71, m =  71;
        boolean map[][] = new boolean[n][m];
        int t = 1024;
        while( sc.hasNext()){
            var r = sc.nextLine().split(",");
            int bi=Integer.parseInt(r[1]), bj = Integer.parseInt(r[0]);
            map[Integer.parseInt(r[1])][Integer.parseInt(r[0])] = true;
            List<List<Integer>> q = new ArrayList<>();
            q.add(List.of(bi,bj));
            boolean v[][] = new boolean[n][m];
            boolean left = false, top = false, right = false, bottom = false;
            while(q.size()>0){
                List<List<Integer>> nq = new ArrayList<>();
                for(var i:q){
                    int a= i.get(0), b = i.get(1);
                    if(!v[a][b]){
                        v[a][b] = true;
                        if(a==0) top=true;
                        if(b==0) left = true;
                        if(a==n-1) bottom = true;
                        if(b==m-1) right = true;
                        for(int[] d : dirs){
                            int x = a+d[0], y = b+d[1];
                            if(x>=0 && x<n && y>=0 && y<m && map[x][y]){
                                nq.add(List.of(x,y));
                            }
                        }
                    }

                }
                q = nq;  
                // System.out.println(nq);
            }
            if((left && top) || (left && right) || (top && bottom) || (right && bottom)){
                System.out.println(r[0]+","+r[1]);
                return;
            }
        }
        // dp = new int[n][m];

        // int v[][] = new int[n][m];




        // // steps(0,0, map, new boolean[n][m]);
        // System.out.println(dp[n-1][m-1]);
        // for(var i: dp){
        //     for(var j: i) System.out.print(j+",");
        //     System.out.println();
        // }
    }
    static int[][] dirs = new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    static int[][] dp;
    static int steps(int i, int j, boolean[][] map, boolean[][] v){
        int n = map.length, m =  map[0].length;
        v[i][j] = true;
        if(i==n-1 && j==m-1) return dp[i][j] = 0;
        if(dp[i][j]!=0) return dp[i][j];
        int min = n*m+5;
        for(int[] d : dirs){
            int x = i+d[0], y = j+d[1];
            if(x>=0 && x<n && y>=0 && y<m && !v[x][y] && !map[x][y]){
                min = Math.min(min, steps(x, y, map, v));
            }
        }
        return dp[i][j] = 1+min;
    }
}