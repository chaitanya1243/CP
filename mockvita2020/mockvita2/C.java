// Dole Out Cadbury



import java.io.*;
import java.util.*; 
  
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
    int memo[][];
    int tc(){
        int p = in.nextInt(), q = in.nextInt();
        int r = in.nextInt(), s = in.nextInt();
        memo  = new int[Math.max(q,s)+1][Math.max(q,s)+1];
        int ans=0;
        for(int i=p; i<=q; i++){
            for(int j=r; j<=s; j++){
                ans+=solve(i,j);
            }
        }
        return ans;
    }
    int solve(int x, int y){
        if(x==y) return 1;
        int max = Math.max(x,y), min = Math.min(x,y);
        if(min==1) return max;
        if(memo[max][min]!=0) return memo[max][min];
        return memo[max][min]=1+solve(max-min, min);
    }
    public static void main(String[] args) throws IOException
    { 
        StringBuilder out = new StringBuilder();
        C ob = new C();
        System.out.println(ob.tc());
    } 
} 