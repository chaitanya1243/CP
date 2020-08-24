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
    int arr[];
    int tc(){
        int n = in.nextInt(), k = in.nextInt(), z= in.nextInt();
        arr = new int[n];
        int pref[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=in.nextInt();
        }
        for(int i=1; i<n; i++){
            if(i!=0)
            pref[i]=pref[i-1]+arr[i];
        }
        for(int i=1; i<k; i++){
            
        }
    }
    // int solve(int i, int k, int z, boolean f){
    //     if(k==0) return arr[i];
    //     if(f && z>0){
    //         return Math.max(solve(i-1, k-1, z-1, false),solve(i+1, k-1, z, true))+arr[i];
    //     }else{
    //         return solve(i+1, k-1, z, true)+arr[i];
    //     }
    // }
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