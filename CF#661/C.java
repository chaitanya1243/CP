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
    int tc(){
        int n = in.nextInt();
        int count[] = new int[n+1];
        for(int i=0; i<n; i++)
        count[in.nextInt()]++;
        int ans = 0, c = 0;
        for(int i=1; i<=n; i++){
                int x =i, y=i;
                while(x>0 && y<=n){
                    if(x==y)
                    c += count[x]/2;
                    else
                    c += Math.min(count[x],count[y]);
                    x--;
                    y++;
                }
                ans = Math.max(ans, c);
                c=0;
                x = i; y=i+1;
                while(x>0 && y<=n){
                    if(x==y)
                    c += count[x]/2;
                    else
                    c += Math.min(count[x],count[y]);
                    x--;
                    y++;
                }
                ans = Math.max(ans, c);
                c=0;
        }
        return ans;
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