// Swayamvar



import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
  
public class A 
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
        int n = in.nextInt();
        String bride = in.next(), groom = in.next();
        int m=0,r=0;
        for(char c: groom.toCharArray()){
            if(c=='m')
            m++;
            else
            r++;
        }
        int i=0;
        for(; i<n; i++){
            char c = bride.charAt(i);
            if(c=='m'){
                if(--m==-1)
                break;
            }else{
                if(--r==-1)
                break;
            }
        }
        return n-i;
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        A ob = new A();
        System.out.print(ob.tc());
    } 
} 