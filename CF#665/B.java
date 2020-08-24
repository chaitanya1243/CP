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
    long tc(){
        long x1 = in.nextLong(), y1 = in.nextLong(), z1 = in.nextLong();
        long x2 = in.nextLong(), y2 = in.nextLong(), z2 = in.nextLong();
        long ans = 0;
        ans += Math.min(z1, y2)*2;
        // 2 > 1
        long min = Math.min(z1, y2);
        z1 -= min;
        y2 -= min;
        // 0 < 2
        min = Math.min(z2, x1);
        x1 -= min;
        z2 -= min;
        // 2 = 2
        min = Math.min(z1, z2);
        z1 -= min;
        z2 -= min;
        // // 0 < 1
        // x1 -= Math.min(x1, y2);
        // y2 -= Math.min(x1, y2);
        // // 0 = 0
        // x1 -= Math.min(x1, x2);
        // x2 -= Math.min(x1, x2);
        // // 1 = 1
        // y1 -= Math.min(y1, y2);
        // y2 -= Math.min(y1, y2);
        // // 2 > 0
        // z1 -= Math.min(z1, x2);
        // x2 -= Math.min(z1, x2);
        // // 1 > 0
        // y1 -= Math.min(y1, x2);
        // x2 -= Math.min(y1, x2);

        ans -= Math.min(y1, z2)*2;
        // 1 < 2
        return ans;
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