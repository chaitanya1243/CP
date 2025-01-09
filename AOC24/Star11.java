import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        // 0 - empty, 1 - particle,
        List<List<Integer>> map = new ArrayList<>();
        int pos[] = new int[2];
        while(sc.hasNext()){
            String line = sc.nextLine();
            List<Integer> row = new ArrayList<>();
            for(char c: line.toCharArray()){
                switch(c){
                    case '^':
                        pos[0] = map.size();
                        pos[1] = row.size();
                        row.add(0);
                        break;
                    case '#':
                        row.add(1);
                        break;
                    default:
                        row.add(0);
                }
            }
            map.add(row);
        }
        int n = map.size(), m = map.get(0).size();
        int count = 0;
        // int[][] dirs = new int[][]{{-1,0}, {0,1}, {1, 0}, {0, -1}};
        // int dir=0;
        // int x = pos[0], y =pos[1];
        // while(true){
        //     // System.out.println(i+" "+j);
        //     // if(map.get(pos[0]).get(pos[1]) >=0)
        //     //     count++;
        //     // int i=pos[0], j = pos[1];   
        //     // map.get(pos[0]).set(pos[1],-1-dir);
        //     System.out.println("before out "+pos[0]+" "+pos[1]);
        //     plus(pos, dirs[(dir)%4]);
        //     if(isIn(pos, n, m) && map.get(pos[0]).get(pos[1]) != 1 && !(x==pos[0] && y==pos[1])){
        //         boolean v[] = new boolean[n*m*4];
        //         map.get(pos[0]).set(pos[1], 1);
        //         plus(pos, dirs[(dir+2)%4]);
        //         int[] pivot = new int[]{pos[0], pos[1]};
        //         int sdir = dir;
        //         while(true){
        //             // map.get(pivot[0]).set(pivot[1],-1-sdir);
        //             int hash = (pivot[0]*m+pivot[1])*4+sdir;
        //             if(v[hash]){
        //             System.out.println(pivot[0]+" "+pivot[1]);
        //                 count++;
        //                 break;
        //             }
        //             v[hash] = true;
        //             plus(pivot, dirs[sdir]);
        //             if(!isIn(pivot, n, m)) break;
        //             // if(map.get(pivot[0]).get(pivot[1]) < 0 && sdir == Math.abs(map.get(pivot[0]).get(pivot[1])+1)){
        //             // System.out.println(pivot[0]+" "+pivot[1]);
        //             //     count++;
        //             //     break;
        //             // }
        //             if(map.get(pivot[0]).get(pivot[1])==1){
        //                 plus(pivot, dirs[(sdir+2)%4]);
        //                 sdir = (sdir+1)%4;
        //             }
        //         }
        //             // System.out.println("-------");

                
        //     //     if(map.get(pos[0]).get(pos[1]) < 0 && (dir+1)%4 == Math.abs(map.get(pos[0]).get(pos[1])+1)){
        //     // System.out.println(pos[0]+" "+pos[1]);

        //     //         count++;
        //     //     }
        //         map.get(pos[0]+dirs[dir][0]).set(pos[1]+dirs[dir][1], 0);
        //     }else{
        //         plus(pos, dirs[(dir+2)%4]);
        //     }
        //     // System.out.println(" after out "+pos[0]+" "+pos[1]);

        //     ////
        //     plus(pos, dirs[dir]);
        //     if(!isIn(pos, n, m)) break;
            
        //     if(map.get(pos[0]).get(pos[1])==1){
        //         plus(pos, dirs[(dir+2)%4]);
        //         dir = (dir+1)%4;
        //     }
        //     // System.out.println(i+" "+j);
        // }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i!=pos[0] || j!=pos[1]) && map.get(i).get(j)!=1){
                    map.get(i).set(j, 1);
                    if(checkLoop(map, new int[]{pos[0], pos[1]})) count++;
                    map.get(i).set(j, 0);
                }
            }
        }
        System.out.println(count);
    }
       static int[][] dirs = new int[][]{{-1,0}, {0,1}, {1, 0}, {0, -1}};
    static boolean checkLoop(List<List<Integer>> map, int[] pivot){
        int n = map.size(), m = map.get(0).size();
        boolean v[] = new boolean[n*m*4];
        int sdir=0;
        while(true){
            // map.get(pivot[0]).set(pivot[1],-1-sdir);
            int hash = (pivot[0]*m+pivot[1])*4+sdir;
                    // System.out.println(pivot[0]+" "+pivot[1]);
            if(v[hash]){
                return true; 
            }
            v[hash] = true;
            plus(pivot, dirs[sdir]);
            if(!isIn(pivot, n, m)) return false;

            if(map.get(pivot[0]).get(pivot[1])==1){
                plus(pivot, dirs[(sdir+2)%4]);
                sdir = (sdir+1)%4;
            }
        }
    }
    static void plus(int[] x, int[] y){
        x[0]+=y[0];
        x[1]+=y[1];
    }
    static boolean isIn(int[] pos, int n, int m){
        int x = pos[0], y = pos[1];
        return  x >= 0 && x < n && y >= 0 && y < m;
    }
}