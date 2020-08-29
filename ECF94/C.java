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
    String tc(){
        String s = in.next();
        int x = in.nextInt(), n = s.length();
        boolean[] arr = new boolean[n];
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='0'){
                if(i-x>=0)
                arr[i-x] = true;
                if(i+x<n)
                arr[i+x] = true;
            }
        }
        // System.out.println(Arrays.toString(arr));
        char cur = '0';
        for(int i=0; i<n; i++){
            cur = '0';
            if((i-x>=0 && !arr[i-x]) || (i+x<n && !arr[i+x]))
            cur = '1';
            if(cur != s.charAt(i))
            return "-1";
        }
        StringBuilder ans = new StringBuilder();
        for(boolean i: arr)
        ans.append(i?'0':'1');
        return ans.toString();
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