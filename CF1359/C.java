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
        int h = in.nextInt(), c = in.nextInt(), t = in.nextInt();

        int ans = 2;
        double prev = Math.abs((h+c)/2 - t);
        int lo=1, hi=1000000;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if((mid&1)==0)
            mid+=1;
            // System.out.println(mid);
            double k = (double)(mid/2*(h+c)+h)/(double)mid;
            // double k = (((double)mid)/2)/mid * (2*h+c);
            if(Double.compare(Math.abs(k-t), prev)<0){
                ans = mid;
                System.out.print(prev+" - ");
                prev = Math.abs(k-t);
                System.out.println(prev);
            }

            if(Double.compare(k,t)>0)
            lo = mid+2;
            else
            hi = mid-2;
        }
        // System.out.println(prev);
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