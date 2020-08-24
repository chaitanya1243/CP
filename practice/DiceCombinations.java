import java.util.*;
import java.io.*;
  
class DiceCombinations 
{ 
    class FastReader 
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
  
    FastReader in  = new FastReader();

    int n = 0, mod = (int)1e9+7;
    int test_case(){
        n = in.nextInt();
        int dp[] = new int[n+1];
        dp[0]=1;
        for(int i=1; i<=n; i++){
            for(int k=1; k<=6; k++){
                if(i>=k){
                    dp[i]+=dp[i-k];
                    dp[i] = dp[i]%mod;
                }
            }
        }
        return dp[n];
    }

    // int solve(int n){
    //     // System.out.println("solve-"+n);
    //     if(n==0) return 1;
    //     if(memo[n]!=0) return memo[n];
    //     int ans = 0;
    //     for(int i=1; i<=6; i++){
    //         if(n>=i){
    //             ans += solve(n-i);
    //             ans = ans%mod;
    //         }
    //     }
    //     return memo[n]=ans;
    //     // return ans;
    // }

    public static void main(String[] args) 
    {
        DiceCombinations ob = new DiceCombinations();
        System.out.println(ob.test_case());
        // System.out.println(Arrays.toString(ob.memo));
    } 
} 