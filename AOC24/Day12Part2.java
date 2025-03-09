import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        List<char[]> map = new ArrayList<>();

        while(sc.hasNext()){
            String line = sc.nextLine();
            map.add((line.toCharArray()));
        }
        int n = map.size(), m = map.get(0).length;
        boolean[][] vis1 = new boolean[n][m];
        boolean[][] vis2 = new boolean[n][m];
        boolean[][] side = new boolean[n][m*4];
        int ans =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis1[i][j]){
                    int area = findAorP(map, i, j, true, vis1, side);
                    int per = findAorP(map, i, j, false, vis2, side);
                    System.out.println(area +" "+ per);
                    ans += area * per;

                }
            }
        }
        System.out.println(ans);
    }

    static int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static char[] arrows = new char[]{'^','>','v', '<'};

    static int findAorP(List<char[]> map, int i, int j, boolean forArea, boolean[][] vis, boolean[][] side){
        char me = map.get(i)[(j)];
        if(vis[i][j]) return 0;
        vis[i][j]=true;
        int v = forArea ? 1 : 0;
        for(int d =0; d<4; d++){
            var dir = dirs[d];
            int x = i+dir[0], y = j+dir[1];
            if(forArea && isIn(map, x, y) && me == map.get(x)[(y)])
            {
                v+=findAorP(map, x, y, forArea, vis, side);
            }
            if(!forArea){
                if(isIn(map, x, y) && me == map.get(x)[(y)]){
                    v+=findAorP(map, x, y, forArea, vis, side);
                }else{

                    if(!side[i][j*4+d]){
                        v++;
                        //expand
                        int a1=i; 
                        int b1=j;
                        // System.out.println();
                        // System.out.print(arrows[(d+1)%4]+" ("+i+", "+j+") ["+arrows[d]+"]---");
                        while(isIn(map, a1, b1) && me == map.get(a1)[b1] && (!isIn(map, a1+dir[0], b1+dir[1]) || me != map.get(a1+dir[0])[b1+dir[1]])){
                            side[a1][b1*4+d]=true;
                            a1+=dirs[(d+1)%4][0];
                            b1+=dirs[(d+1)%4][1];
                        // System.out.print(" ("+a1+", "+b1+"); ");
                        }
                        a1=i; b1=j;
                        while(isIn(map, a1, b1) && me == map.get(a1)[b1] && (!isIn(map, a1+dir[0], b1+dir[1]) || me != map.get(a1+dir[0])[b1+dir[1]])){
                            side[a1][b1*4+d]=true;
                            a1+=dirs[(d+3)%4][0];
                            b1+=dirs[(d+3)%4][1];
                        // System.out.print(" ("+a1+", "+b1+"); ");
                        }
                    }
                }
            }
        }
        return v;
    }

    static boolean isIn(List<char[]> map, int i, int j){
        int n = map.size(), m = map.get(0).length;
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}