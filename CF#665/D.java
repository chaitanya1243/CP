import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
  
public class D 
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
    static long mod = (long)1e9+7;
    long tc(){
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++)
        adj.add(new ArrayList<>());

        for(int i=1; i<n; i++){
            int x = in.nextInt(), y = in.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int k = in.nextInt();
        long wts[] = new long[k];
        for(int i=0; i<k; i++)
        wts[i] = in.nextInt();

        ArrayList<Long> edges = new ArrayList<>();
        dfs(1, -1, adj, edges);
        Collections.sort(edges);
        Arrays.sort(wts);
        long ans = 0;
        if(k<=n-1){
            for(int i=n-2, j = k-1; i>=0; i--, j--){
                if(j<0){
                    ans += edges.get(i);
                    ans = ans%mod;
                }else{
                    ans += (edges.get(i)*wts[j])%mod;
                    ans = ans%mod;
                } 
            }
        }else{
            //
            for(int i = k-1; i>n-2; i--){
                wts[i-1] *= wts[i];
                wts[i-1] = wts[i-1]%mod;
            }
            for(int i=n-2; i>=0; i--){
                ans += (edges.get(i)*wts[i])%mod;
                ans = ans%mod;
            }
        }
        // System.out.println(edges);
        return ans;
    }
    int dfs(int n, int p, ArrayList<ArrayList<Integer>> adj, ArrayList<Long> edges){
        int count = 1;
        for(int i: adj.get(n)){
            if(i!=p){
                count += dfs(i, n, adj, edges);
            }
        }
        if(p!=-1)
        edges.add(((long)count*((long)(adj.size()-1-count))%mod));
        // System.out.println(p+" "+count);
        return count;
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        D ob = new D();
        int t = in.nextInt();
        while(t-->0){
           out.append(ob.tc()+"\n");
        }
        System.out.print(out);
    } 
} 