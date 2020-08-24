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
    String tc(){
        int n = in.nextInt();
        boolean arr1[] = new boolean[n],
        arr2[] = new boolean[n];
        int i=0;
        StringBuilder out = new StringBuilder();
        for(char c : in.next().toCharArray()){
            arr1[i++]= c=='1';
        }
        i=0;
        for(char c : in.next().toCharArray()){
            arr2[i++]= c=='1';
        }
        int c=0;
        for(i=n-1; i>0; i--){
            if(arr1[i]!=arr2[i]){
                if(arr1[0]==arr2[i]){
                    c+=2;
                    arr1[0] = !arr2[i];
                    out.append(1+" ");
                    pf(arr1, i);
                    out.append(i+1+" ");
                }else{
                    c++;
                    pf(arr1, i);
                    out.append(i+1+" ");
                }
            }
        }
        if(arr1[0]!=arr2[0]){
            c++;
            arr1[0]=arr2[0];
            out.append(1);
        }
        // System.out.println(Arrays.toString(arr1)+"\n"+Arrays.toString(arr2));
        return c+" "+out.toString();
    }
    void pf(boolean arr[], int n){
        // for(int i=0; i<=n; i++)
        // arr[i] = !arr[i];
        for(int i=0; i<(n+1)/2; i++){
            boolean t = arr[n-i];
            arr[n-i] = !arr[i];
            arr[i] = !t;
        }
        if((n&1)==0) arr[n/2] = !arr[n/2];
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