import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        List<String> map = new ArrayList<>();
        while(sc.hasNext()){
            map.add(sc.nextLine());
        }
        int n = map.size(), m = map.get(0).length();
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j]=-1;
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map.get(i).charAt(j)=='0'){
                    ans+=find(map, '0', i, j, new boolean[n][m]);
                    // System.out.println(ans);
                }
            }
        }
        System.out.println(ans);
        // System.out.println(Arrays.deepToString(dp));
        // print();
    }
    static int[][] dirs = new int[][]{{0,1},{0, -1}, {1, 0}, {-1, 0}};
static int find(List<String> map, char h, int i, int j, boolean[][] v){
        int n = map.size(), m = map.get(0).length();
        // System.out.println(h);
        // System.out.println("I "+i+" j "+j);
        if(i<0||i>=n||j<0||j>=m) return 0;
        if(map.get(i).charAt(j)!=h) return 0;
        // if(v[i][j]) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(h=='9'){
            // v[i][j] = true;
            return dp[i][j]=1;
        }
        int paths = 0;
        for(int[] dir: dirs){
            paths += find(map, (char)(h+1), dir[0]+i, dir[1]+j, v);
        }
        return dp[i][j]=paths;
    }

    static void print(){
        int n = dp.length, m = dp[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] dp = null;
}