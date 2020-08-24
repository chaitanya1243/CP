import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.*; 
  
class CROADS
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
    TreeMap<Integer, Long> tm = new TreeMap<>();
    long tc(){
        int n = in.nextInt();
        Map.Entry<Integer, Long> e = tm.floorEntry(n);
        if(e!=null && e.getKey()==n) return e.getValue();
        if((n&(n-1)) == 0) return -1;
        long ans = e==null?0:e.getValue();
        for(int i=(e==null?1:e.getKey())+1; i<=n; i++){
            ans+=1<<Integer.numberOfTrailingZeros(i);
        }
        tm.put(n,ans);
        return ans;
    }
    public static void main(String[] args) 
    { 
        int t = in.nextInt();
        StringBuilder out = new StringBuilder();
        CROADS ob = new CROADS();
        while(t-->0){
            out.append(ob.tc()+"\n");
        }
        System.out.println(out);
    } 
} 