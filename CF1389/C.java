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
        String s = in.next();
        int count[] = new int[10];
        for(char c:s.toCharArray())
        count[c-'0']++;
        int ans = 0;
        for(int i:count) ans = Math.max(i, ans);
        for(int i=0; i<=9; i++){
            for(int j=0; j<=9; j++){
                if(i==j) continue;
                boolean f =true;
                int ct=0;
                for(char c: s.toCharArray())
                {
                    if(f){
                        if(i==c-'0'){
                            ct++;
                            f = false;
                        }
                    }else{
                        if(j==c-'0')
                        {
                            ct++;
                            f=true;
                        }
                    }
                }
                // System.out.println(""+i+j+" "+ct);
                ans = Math.max(ans,(ct/2)*2);
            }
        }
        return s.length()-ans;
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