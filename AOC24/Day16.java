import java.util.*;

class Solution{
    static int[][] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<char[]> map = new ArrayList<>();
        while(sc.hasNext()){
            map.add(sc.nextLine().toCharArray());
        }
        int n = map.size(), m = map.get(0).length;
        int dist[][] = new int[n][m*4];
        for(var i:dist) Arrays.fill(i, Integer.MAX_VALUE);
        dist[n-2][1] = 0;
        PriorityQueue<Node> s = new PriorityQueue<>();
        Set<List<Integer>> good = new HashSet<>();
        s.add(new Node(n-2, 1, 0, 0, null));
        int goodScore = Integer.MAX_VALUE;
        while(!s.isEmpty()){
            var f = s.poll();

            // System.out.println(f.x+" "+f.y+" "+f.eDist);
            // System.out.println(s);
            // s.remove(f);
            if(f.x==1 && f.y==m-2 && f.eDist <= goodScore){
                if(f.eDist < goodScore) good.clear();
                goodScore = f.eDist;

                var t = f;
                while(t !=null){
                    good.add(List.of(t.x, t.y));
                    t = t.p;
                }
            }
            Node adj= null;
            for(int i=0; i<3; i++){
                if(i==0){
                    adj = new Node(f.x+dirs[f.dir][0], f.y+dirs[f.dir][1], f.dir, f.eDist+1, f);
                }else if(i==1){
                    adj = new Node(f.x+dirs[(f.dir+1)%4][0], f.y+dirs[(f.dir+1)%4][1], (f.dir+1)%4, f.eDist+1001, f);
                }else{
                    adj = new Node(f.x+dirs[(f.dir+3)%4][0], f.y+dirs[(f.dir+3)%4][1], (f.dir+3)%4, f.eDist+1001, f);
                }
                if(map.get(adj.x)[adj.y] == '#') continue;
                if(dist[adj.x][adj.y*4+adj.dir] >= adj.eDist){
                // if(adj.x==1 && adj.y==m-2) System.out.println(adj.eDist);

                    dist[adj.x][adj.y*4+adj.dir] = adj.eDist;
            //         if(adj.x==4 && adj.y==5){
            // System.out.println(s);
                        
            //         }
                    // s.remove(adj);
                    s.add(adj);
            //                            if(adj.x==4 && adj.y==5){
            // System.out.println(s);
                        
            //         }
                }
            }

        }

        // System.out.println(good);
        System.out.println(good.size());
        // for(var i: dist) System.out.println(Arrays.toString(i));
    }
    static final class Node implements Comparable<Node> {

         final int x;
         final int y;
         final int dir;
         final int eDist;
         final Node p;

        Node(int x, int y, int dir, int eDist, Node p) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.eDist = eDist;
            this.p = p;
        }

        @Override public int compareTo(Node other) {
            // As of Java 7, this can be replaced with
            // return x != other.x ? Integer.compare(x, other.x) 
            //     : Integer.compare(y, other.y);

            return Integer.compare(eDist, other.eDist);
        }

        public String toString(){
            return x+" "+y;
        }
    }
    
    static int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    static int score(int i, int j, List<char[]> map, int d, Set<List<Integer>> v){
        int n = map.size(), m = map.get(0).length;
        System.out.println(i+" "+j);
        if(map.get(i)[j] == 'E') return 0;
        if(dp[i][j*4+d]!=-1) return dp[i][j*4+d];
        v.add(List.of(i, j));
        int ans = Integer.MAX_VALUE;
        for(int l=0; l<4; l++){
            if((d+2)%4!=l){
                int x = i+dirs[l][0], y = j+dirs[l][1];
                if(x > 0 && x < n && y> 0 && y<m && map.get(x)[y]!='#' && !v.contains(List.of(x, y))){
                    int h = score(x, y, map, l, v);
                    if(h != Integer.MAX_VALUE){
                        ans = Math.min(ans, h+ (d==l?1:1001));
                    }
                }
            }
        }
        v.remove(List.of(i, j));
        return dp[i][j*4+d]=ans;
    }
}