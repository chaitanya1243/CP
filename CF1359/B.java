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
    int tc(){
        int n = in.nextInt(), m = in.nextInt(),
        x = in.nextInt(), y = in.nextInt();
        if(x < ((double)y)/2){
            int count = 0;
            for(int i=0; i<n; i++){
                for(char c: in.next().toCharArray())
                if(c=='.')
                count++;
            }
            return count*x;
        }else{
            int ans = 0;
            for(int i=0; i<n; i++){
                char[] c = in.next().toCharArray();
                for(int j=0; j<m; j++){
                    if(c[j]=='.'){
                        if(j+1<m && c[j+1]=='.'){
                            ans+=y;
                            ++j;
                        }
                        else
                        ans+=x;
                    }
                }
            }
            return ans;
        }
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