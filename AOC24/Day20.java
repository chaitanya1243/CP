import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        List<char[]> map = new ArrayList<>();
        while( sc.hasNext()){
            map.add(sc.nextLine().toCharArray());
        }
        int n = map.size(), m =  map.get(0).length;
        int sx =0, sy=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map.get(i)[j]=='S'){
                    sx=i;
                    sy=j;
                }
            }
        }
        boolean[][] v = new boolean[n][n];
        int[][] dist = new int[n][n];
        int l=0;
        List<List<Integer>> q = new ArrayList<>();
        q.add(List.of(sx,sy));
        while(q.size()>0){
            List<List<Integer>> nq = new ArrayList<>();
            for(var i:q){
                int a= i.get(0), b = i.get(1);
                if(v[a][b]) continue;
                v[a][b] = true;
                dist[a][b] = l;
                for(int[] d : dirs){
                    int x = a+d[0], y = b+d[1];
                    if(x>=0 && x<n && y>=0 && y<m && map.get(x)[y]!='#'){
                        nq.add(List.of(x,y));
                    }
                }

            }
            q = nq;  
            l++;
            // System.out.println(nq);
        }
        // dp = new int[n][m];

        // int v[][] = new int[n][m];
        int c=0;
        TreeMap<Integer, Integer> cMap = new TreeMap<>();
        q.add(List.of(sx,sy));
        v =  new boolean[n][m];
        while(q.size()>0){
            List<List<Integer>> nq = new ArrayList<>();
            for(var i:q){
                int a= i.get(0), b = i.get(1);
                if(v[a][b]) continue;
                v[a][b] = true;
                List<List<Integer>> cheatQ = new ArrayList<>();
                cheatQ.add(List.of(a,b));
                boolean cheated[][] = new boolean[n][m];

                for(int sec =0; sec<=20; sec++){
                    List<List<Integer>> nextCheatQ = new ArrayList<>();

                    for(var ci : cheatQ){
                        int cx= ci.get(0), cy = ci.get(1);
                        if(cheated[cx][cy]) continue;
                        cheated[cx][cy] = true;
                        if(map.get(cx)[cy]!='#'){
                            int by = dist[cx][cy]- dist[a][b]-sec;
                            if(by >= 100)
                            c++;
                            // cMap.put(by, cMap.getOrDefault(by, 0)+1);
                        }
                        for(int[] d : dirs){
                            int cnx = cx+d[0], cny = cy+d[1];
                            if(cnx>=0 && cnx<n && cny>=0 && cny<m){
                                nextCheatQ.add(List.of(cnx,cny));
                            }
                        }
                    }
                    cheatQ = nextCheatQ;
                }
                for(int[] d : dirs){
                    int x = a+d[0], y = b+d[1];
                    if(x>=0 && x<n && y>=0 && y<m && map.get(x)[y]!='#'){
                        nq.add(List.of(x,y));
                    }
                }
                // remove
                // for(int[] d : dirs){
                //     int x = a+d[0], y = b+d[1];
                //     if(x>=0 && x<n && y>=0 && y<m){
                //         if( map.get(x)[y]!='#'){

                //             nq.add(List.of(x,y));
                //         }else{
                //             x+=d[0];
                //             y+=d[1];
                //             if(x>=0 && x<n && y>=0 && y<m){
                //                 // if(a ==9 && b==7){
                //                 //     Sys
                //                 // }
                //                 if( dist[x][y]- dist[a][b] > 101 ){
                //                     int by = dist[x][y]- dist[a][b];
                //                     c++;
                //                     cMap.put(by, cMap.getOrDefault(by, 0)+1);
                //                 };
                //             }
                //         }
                //     }
                // }

            }
            q = nq;  
            l++;
            // System.out.println(nq);
        }


        // // steps(0,0, map, new boolean[n][m]);
        // System.out.println(dp[n-1][m-1]);
        // for(var i: dist){
        //     for(var j: i) System.out.print(j+",");
        //     System.out.println();
        // }
        System.out.println(cMap);
        System.out.println(c);
    }
    static int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
}