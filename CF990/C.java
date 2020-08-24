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
    long tc(){
        int n = in.nextInt();
        TreeMap<Integer, Long> hm = new TreeMap<>();
        for(int i=0; i<n; i++){
            String s = in.next();
            int o=0, c=0;
            for(char b: s.toCharArray()){
                if(b=='(')
                o++;
                else{
                    if(o>0)
                    o--;
                    else
                    c++;
                }
            }
            if(o==0 && c>0){
                hm.put(-c, hm.getOrDefault(-c,0l)+1);
            }else if(c==0 && o>0)
                hm.put(o, hm.getOrDefault(o,0l)+1);
            else if(o==0 && c==0)
                hm.put(0, hm.getOrDefault(0,0l)+1);
        }
        // System.out.println(hm);
        long ans=0;
        for(Map.Entry<Integer, Long> e :hm.entrySet())
        {
            if(e.getKey()>0) break;
            if(e.getKey()==0){
                ans += e.getValue()*(e.getValue()-1) + e.getValue();
                break;
            }
            ans += e.getValue()*hm.getOrDefault(-e.getKey(),0l);
        }
        return ans;
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        C ob = new C();
        // int t = in.nextInt();
        // while(t-->0){

        // }
        System.out.print(ob.tc());
    } 
} 