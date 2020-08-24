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
        long n = in.nextLong(), k = in.nextLong();
        long arr[] = new long[(int)n];
        long max = Long.MIN_VALUE;
        for(int i=0; i<(int)n; i++){
            arr[i] = in.nextInt();
            max = Math.max(max, arr[i]);
        }
        for(int i=0; i<(int)n; i++)
        arr[i] = max-arr[i];
        max = Long.MIN_VALUE;
        for(long i:arr)
        max = Math.max(i,max);
        k--;
        if(k%2==1)
        {
            for(int i=0; i<(int)n; i++){
                arr[i] = max-arr[i];
            }
        }
        StringBuilder out = new StringBuilder();
        for(long i:arr)
        out.append(i+" ");
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