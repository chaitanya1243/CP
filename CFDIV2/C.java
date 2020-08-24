import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
  
public class C 
{ 
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    static final FastReader in = new FastReader();
    int x1, y1, x2, y2, memo[][];
    long tc(){
        x1 = in.nextInt();
        y1 = in.nextInt();
        x2 = in.nextInt();
        y2 = in.nextInt();
        // int n = x2-x1+1, m = y2-y1+1;
        // if (m == 0 || n == 0) {
        //     return 0;
        // }
        // if (m == 1 || n == 1) {
        //     return 1;
        // }
        
        // int[] dp = new int[n];
        // for (int i = 0; i < n; i++) {
        //     dp[i] = 1;
        // }
        // for (int i = 1; i < m; i++) {
        //     for (int j = 1; j < n; j++) {
        //         dp[j] += dp[j - 1];
        //     }
        // }
        // return dp[n - 1];
        // memo = new int[x2-x1+1][y2-y1+1];
        // System.out.println("d");
        return (long)(x2-x1)*(long)(y2-y1)+1;
    }
    int solve(int i, int j){
        if(i>x2 || j>y2) return 0;
        if(i==x2 && j==y2) return 1;
        if(memo[i-x1][j-y1]!=0) return memo[i-x1][j-y1];
        return memo[i-x1][j-y1]=solve(i+1,j)+solve(i,j+1);
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        int t = in.nextInt();
        C ob = new C();
        while(t-->0){
            out.append(ob.tc()+"\n");
        }
        System.out.println(out);
    } 
} 