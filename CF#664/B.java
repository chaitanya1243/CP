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
        int n = in.nextInt(), m = in.nextInt();
        int x = in.nextInt(), y = in.nextInt();
        StringBuilder out = new StringBuilder();
        out.append(x+" "+y+"\n");
        out.append(1+" "+y+"\n");
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i%2==1){
                if(j==y && (i==x || i==1))
                continue;
                    out.append(i+" "+j+"\n");
                }else{
                if(m+1-j==y && (i==x || i==1))
                continue;
                    out.append(i+" "+(m+1-j)+"\n");
                }
            }
        }
        return out.toString();
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        B ob = new B();
        int t = 1;
        while(t-->0){
           out.append(ob.tc()+"\n");
        }
        System.out.print(out);
    } 
} 