import java.io.*;
import java.util.*;
  
class  Friendship
{ 
    class FastReader 
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
    FastReader in  = new FastReader();
    String s;
    int test_case(){
        s = in.next();
        String str = s;
        int n = s.length();
        int count = 0;
        for(int len=1; len<=(n-2)/2; len++){
            if(eq(0,len-1,len,2*len-1)){
                int a = 2*len;
                int b = (n+a)/2;
                if(eq(a,b-1,b,n-1)) count++;
            }
        }
        return count;
        // for (int len = 1; len <= str.length() / 2 - 1; len++) {
        //     // 0 len  len 2len
        //     if (equal(str,0,len-1,len,2*len-1)) {
        //         int a = 2 * len;
        //         int b = (a + str.length()) / 2;
        //         Pair p = new Pair(a, b);
        //         if (map.containsKey(p)) {
        //             if (map.get(p))
        //                 count++;
        //         } else {

        //             // a b b str.length()
        //             if (equal(str,a,b-1,b,str.length()-1)) {
        //                 map.put(p, true);
        //                 count++;
        //             } else {
        //                 map.put(p, false);
        //             }
        //         }

        //     }
        // }
    }

    boolean eq(int i1, int j1, int i2, int j2){
        while(i1<=j1){
            if(s.charAt(i1)!=s.charAt(i2)) return false;
            i1++;
            i2++;
        }
        return true;
    }

    public static void main(String[] args) 
    { 
        Friendship ob = new Friendship();
        int t = ob.in.nextInt();
        StringBuilder out = new StringBuilder();
        while(t-->0){
            out.append(ob.test_case()+"\n");
        }
        System.out.println(out);
    } 
} 