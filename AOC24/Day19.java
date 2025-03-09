import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        var patterns = sc.nextLine().split(", ");
        sc.nextLine();
        Set<String> hs = new HashSet<>(Arrays.asList(patterns));
        long c = 0;
        while(sc.hasNext()){

            String s = sc.nextLine();
            Long dp[] = new Long[s.length()];
            c+= solve(s, 0, 1, hs, dp);
        //             for(var i: dp){
        //      System.out.print(i[0]+",");
        // }
        //     System.out.println();
        }
        System.out.println(c);
    }

    static long solve(String s, int i, int x,  Set<String> hs, Long[] dp){
        if(i >= s.length()) return 1;
        // if(j > s.length()) return 0;
        if(dp[i]!=null) return dp[i];
        dp[i] = 0l;
        for(int j=i+1; j<=s.length(); j++){
            if(hs.contains(s.substring(i,j)))
                dp[i]+=solve(s, j,0, hs, dp);
        }
        // if(hs.contains(s.substring(i,j))) dp[i][0] = solve(s, j, j+1, hs, dp);
        // else dp[i][0] = 0;
        // return dp[i][0] += solve(s, i, j+1, hs, dp);
        return dp[i];
    }
}