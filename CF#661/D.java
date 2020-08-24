import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
  
public class D 
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
        int n = in.nextInt();
        int x = 0, y= 0;
        char[] cs = in.next().toCharArray();
        ArrayList<Character> li = new ArrayList<>();
        int ans[] = new int[n];
        Stack<Integer> one = new Stack<>();
        Stack<Integer> zero = new Stack<>();
        for(int i=0; i<n; i++){
            int pos = one.size()+zero.size();
            if(cs[i]=='0'){
                if(!one.isEmpty())
                    pos = one.pop();
                zero.push(pos);
            }else{
                if(!zero.isEmpty())
                    pos = zero.pop();
                one.push(pos);
            }
            ans[i] = pos;
        }
        StringBuilder out = new StringBuilder();
        out.append(one.size()+zero.size()+"\n");
        for(int i:ans) out.append(i+1+" ");
        return out.toString();
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        D ob = new D();
        int t = in.nextInt();
        while(t-->0){
           out.append(ob.tc()+"\n");
        }
        System.out.print(out);
    } 
} 