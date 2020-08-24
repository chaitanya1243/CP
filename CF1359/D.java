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
    int tc(){
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = in.nextInt();

        int max = arr[0], prefix = 0, ans = 0;
        for(int i=1; i<n; i++){
            max = Math.max(max, arr[i]);
            if(arr[i-1]+arr[i]< prefix+max){
                prefix = arr[i-1];
                max = arr[i];
                System.out.println(i);
            }
            arr[i]+=arr[i-1];
            ans = Math.max(ans,arr[i]-(prefix+max));
        }
        System.out.println(Arrays.toString(arr));
        return ans;
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        D ob = new D();
        int t = 1;
        while(t-->0){
            out.append(ob.tc()+"\n");
        }
        System.out.print(out);
    } 
} 