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
    long tc(){
        int n = in.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        for(int i=0; i<n; i++)
        arr1[i] = in.nextInt();
        for(int i=0; i<n; i++)
        arr2[i] = in.nextInt();
        int min1 = arr1[0], min2 = arr2[0];
        for(int i=0; i<n; i++){
            min1 = Math.min(min1, arr1[i]);
            min2 = Math.min(min2, arr2[i]);
        }
        long ans = 0;
        for(int i=0; i<n; i++){
            int x = arr1[i]-min1;
            int y = arr2[i]-min2;
            ans += x+y-Math.min(x,y);
        }
        return ans;
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