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
    String tc(){
        int n = in.nextInt(), m = in.nextInt();
        Set<Integer> hs1 = new HashSet<>();
        int arr[] = new int[m];

        for(int i=0; i<n; i++)
        hs1.add(in.nextInt());

        // System.out.println(hs1);

        for(int i=0; i<m; i++)
        arr[i]=in.nextInt();

        for(int i: arr){
            if(hs1.contains(i)){
                return "YES\n1 "+i;
            }
        }
        return "NO";
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        A ob = new A();
        int t = in.nextInt();
        while(t-->0){
            out.append(ob.tc()+"\n");
        }
        System.out.print(out);
    } 
} 