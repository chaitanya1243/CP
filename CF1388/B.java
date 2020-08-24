import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
  
public class B 
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
    String tc(){
        int n=in.nextInt();
        int ld = n/4+((n%4==0)?0:1);
        StringBuilder out = new StringBuilder();
        for(int i=0; i<n-ld; i++)
        out.append(9);
        for(int i=0; i<ld; i++)
        out.append(8);
        return out.toString();
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        B ob = new B();
        int t = in.nextInt();
        while(t-->0){
            out.append(ob.tc()+"\n");
        }
        System.out.print(out);
    } 
} 