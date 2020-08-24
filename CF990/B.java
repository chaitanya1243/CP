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
        int n = in.nextInt(), k= in.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i]=in.nextInt();
        int c =0;
        Arrays.parallelSort(arr);
        for(int i=0; i<n; i++){
            int u = i+1;
            while(u<n && arr[u]==arr[i])
            u++;
            if(u>=n || arr[u]-arr[i]>k)
            c+=u-i;
            i = u-1;
        }
        return c;
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        B ob = new B();
        int t = 1;
        while(t-->0){
            out.append(ob.tc());
        }
        System.out.print(out);
    } 
} 