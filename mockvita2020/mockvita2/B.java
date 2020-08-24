// Digit Pairs



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
        int[] even = new int[10];
        int[] odd = new int[10];
        // int[] pairs = new int[10];
        // Arrays.fill(pairs,2);
        for(int i=1; i<=n; i++){
            String s = in.next();
            int max = -1, min = 10;
            for(char c: s.toCharArray()){
                max = Math.max(c-'0', max);
                min = Math.min(c-'0', min);
            }
            int score = max*11+min*7;
            int sd = ((score/10)%10)==0?(score%10):((score/10)%10);
            if((i&1)==0){
                even[sd]++;
            }else{
                odd[sd]++;
            }
            // System.out.println(score+" "+sd);
        }
        int count = 0;
        // for(int i:even)
        // if(i==2) count++;
        // else if(i>2)
        // count+=2;
        // for(int i:odd)
        // if(i==2) count++;
        // else if(i>2)
        // count+=2;
        for(int i=0; i<10; i++){
            int pos = even[i]==2?1:even[i]>2?2:0;
            pos+=odd[i]==2?1:odd[i]>2?2:0;
            count += Math.min(2,pos);
        }
        // System.out.println(Arrays.toString(even));
        // System.out.println(Arrays.toString(odd));
        return count;
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        B ob = new B();
        System.out.print(ob.tc());
    } 
} 