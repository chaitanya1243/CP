import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
  
public class AGGRCOW 
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
        int n = in.nextInt(), k = in.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = in.nextInt();

        Arrays.parallelSort(arr);
        int lo=1, hi = arr[n-1]-1;
        while(lo<hi){
            int mid = lo+(hi-lo+1)/2;
            int ck=1, prev = arr[0];
            for(int i=1; i<n; i++){
                if(arr[i]-prev>=mid){
                    ck++;
                    prev = arr[i];
                }
            }
            // System.out.println(lo+" "+mid+" "+hi+" "+ck);
            if(ck<k) hi=mid-1;
            else lo=mid;
        }
        return lo;
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        AGGRCOW ob = new AGGRCOW();
        int t = in.nextInt();
        while(t-->0){
            out.append(ob.tc());
        }
        System.out.println(out);
    } 
} 