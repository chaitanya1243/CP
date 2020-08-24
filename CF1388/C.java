import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
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
    boolean f = true;
    ArrayList<ArrayList<Integer>> adj;
    String tc(){
        int n = in.nextInt();
        int p[] = new int[n], h[] = new int[n];
        for(int i=0; i<n; i++)
        p[i]=in.nextInt();
        for(int i=0; i<n; i++)
        h[i]=in.nextInt();
        adj = new ArrayList<>();
        for(int i=0; i<=n; i++)
        adj.add(new ArrayList<>());
        for(int i=0; i<n-1; i++)
        {
            int a = in.nextInt(), b=in.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        f=true;
    }
    int[] dfs(int i, int p){
        
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        
        C ob = new C();
        int t = in.nextInt();
        while(t-->0){
            out.append(ob.tc()+"\n");
        }
        System.out.print(out);
    } 
} 