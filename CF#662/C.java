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
    int tc(){
        int n =  in.nextInt();
        Integer count[] = new Integer[n+1];
        for(int i=0; i<=n; i++)
        count[i]= 0;
        for(int i=0; i<n; i++)
        count[in.nextInt()]++;
        Arrays.sort(count, (a,b)->b-a);
        int lo=0, hi=n-1;
        int arr[];
        while(lo<hi){
            int mid = lo+(hi-lo+1)/2;
            arr = new int[n];
            int i=0, j=0;
            boolean f = true;
            b:for(int idx=0; idx<n; idx++){
                if(count[idx]==0) break;
                while(arr[i]!=0)
                i++;
                j=i;
                int c = count[idx];
                while(c-->0){
                    if(j>=n){
                        f = false;
                        break b;
                    }
                    arr[j]=idx+1;
                    j+=mid+1;
                }
            }
            System.out.println(mid+" "+f+Arrays.toString(arr));
            if(f) lo = mid;
            else hi = mid-1;
        }
        return lo;
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        C ob = new C();
        int t = in.nextInt();
        while(t-->0){
           out.append(ob.tc()+"\n");
        }
        System.out.print(out);
    } 
} 