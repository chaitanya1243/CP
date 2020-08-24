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
        int n = in.nextInt(), m = in.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[m];
        for(int i=0; i<n; i++)
        arr1[i]=in.nextInt();
        for(int i=0; i<m; i++)
        arr2[i]=in.nextInt();
        List<Set<Integer>> li= new ArrayList<>(n);
        for(int i =0; i<n; i++){
            li.add(new HashSet<>());
            for(int j=0; j<m; j++){
                li.get(i).add(arr1[i]&arr2[j]);
            }
        }
        // System.out.println(li);
        for(int ans=0; ans<=512; ans++){
            int i = 0;
            for(; i<n; i++){
                boolean f = false;
                for(int j:li.get(i)){
                    if(ans == (ans|j))
                    {
                        f=true;
                        break;
                    }
                }
                if(!f)
                break;
            }
            if(i==n)
            return ans;
        }
        return 0;
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        C ob = new C();
        int t = 1;
        while(t-->0){
           out.append(ob.tc()+"\n");
        }
        System.out.print(out);
    } 
} 