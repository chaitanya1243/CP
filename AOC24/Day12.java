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
        int ans =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis1[i][j]){
                    int area = findAorP(map, i, j, true, vis1);
                    int per = findAorP(map, i, j, false, vis2);
                    System.out.println(area +" "+ per);
                    ans += area * per;

                }
            }
        }
        System.out.println(ans);
    }

    static int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    static int findAorP(List<char[]> map, int i, int j, boolean forArea, boolean[][] vis){
        char me = map.get(i)[(j)];
        if(vis[i][j]) return 0;
        vis[i][j]=true;
        int v = forArea ? 1 : 0;
        for(var dir: dirs){
            int x = i+dir[0], y = j+dir[1];
            if(forArea && isIn(map, x, y) && me == map.get(x)[(y)])
            {
                v+=findAorP(map, x, y, forArea, vis);
            }
            if(!forArea){
                if(isIn(map, x, y) && me == map.get(x)[(y)]){
                    v+=findAorP(map, x, y, forArea, vis);
                }else{
                    v++;
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