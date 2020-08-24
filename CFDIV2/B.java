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
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i]=in.nextInt();
        int count = 1, tcount=0;
        Arrays.parallelSort(arr);
        for(int i=0; i<n; i++){
            if(arr[i]<=count+tcount){
                count+=tcount+1;
                tcount=0;
            }else
            tcount++;
        }
        return count;
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        int t = in.nextInt();
        B ob = new B();
        while(t-->0){
            out.append(ob.tc()+"\n");
        }
        System.out.println(out);
    } 
} 