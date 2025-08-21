import java.util.*;

class Solution{
        static int[][] numpad = new int[][]{
            {7,8,9},
            {4,5,6},
            {1,2,3},
            {-1,0,10},
        };
        static int[][] dirpad = new int[][]{
            {-1,0,4},
            {1,2,3},
        };
        
    static int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    static char[] moves = new char[]{'^','<','v','>'};



    static int tryMove(int mv, int me, int[][] pad){

        int n = pad.length, m = pad[0].length;
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(pad[r][c]==me){
                    var d = dirs[mv];
                    int x = r+d[0], y = c+d[1];
                    if(x>=0 && x<n && y>=0 && y<m && pad[x][y]!=-1){

                        
                        return pad[x][y];
                    }
                    else{
                        return -1;
                    }
                }
            }
        }
        return -1;
    }

    /// to print any key in current robot all the prev should point to a
    /// transition -  all the robots point at A in the begining and after moving current robot to desired target
    // it goes back to a
    // so dp[r][a][b] = dp[r-1][a][sth]+1+....dp[r-1][sth][a];
    static int M = 26;
    static long dp[][][] = new long[M+1][11][11];
    static void preprocess(){
        for(int z=1; z<=M; z++){
            int x = z==M?11:5;
            for(int from=0; from<x; from++){
                long dist[][] = new long[5][11];
                for(var i : dist) Arrays.fill(i, Long.MAX_VALUE);
                Set<List<Long>> q = new HashSet<>();
                q.add(List.of(0l, 4l, (long)from));
                dist[4][from] = 0;
                while(q.size()>0){
                    var c = q.iterator().next();
                    q.remove(c);
                    long d = c.get(0);
                    int prev = (int)((long)c.get(1));
                    int me = (int)((long)c.get(2));
                    for(int mv=0; mv<5; mv++){
                        long maybe = d+dp[z-1][prev][mv];
                        if(maybe < dist[mv][me]){
                            q.remove(List.of(dist[mv][me], (long)mv, (long)me));
                            q.add(List.of(maybe, (long)mv, (long)me));
                            dist[mv][me] = maybe;
                        }
                    }

                    if(prev!=4){
                        int newMe = tryMove(prev, me, z==M?numpad:dirpad);
                        if(newMe!=-1){
                            long maybe = d+1;
                            if(maybe < dist[prev][newMe]){
                                q.remove(List.of(dist[prev][newMe], (long)prev, (long)newMe));
                                q.add(List.of(maybe, (long)prev, (long)newMe));
                                dist[prev][newMe] = maybe;
                            }
                        }
                    }

                }
                for(int to=0; to<x; to++){
                    dp[z][from][to] = dist[4][to];
                }
            }
        }
    }

    static int getIntOf(char c){
        if(c=='A') return 10;
        return c-'0';
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String str = "980A";
        // System.out.println(solve(str));

        preprocess();
        // System.out.println(dp[3][10][8]);

                long ans=0;
        while( sc.hasNext()){
           var line = "A"+sc.nextLine();
           long x = 0;
           for(int i=1; i<line.length(); i++){
               x+= dp[M][getIntOf(line.charAt(i-1))][getIntOf(line.charAt(i))]+1;
           }
           int inp = Integer.parseInt(line.substring(1, 4));
            ans+=inp*x;
        // ans=x;
        }
        System.out.println(ans);

    }
}
