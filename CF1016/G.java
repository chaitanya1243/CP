import java.util.*;
import java.io.*;

public final class G{
    public static void main(String args[]) throws FileNotFoundException{
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }

    static void solve(FastReader sc) throws FileNotFoundException{
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = sc.nextIntArray(n);
        Node root = new Node();
        int ans = n+1;

        for(int i=0; i<n; i++){
            Node t = root;
            int c = 0;
            insert(root, arr[i], i);
            while(t!=null){
                int m = 1 << (29-c);
                int bit = ((arr[i] ^ k) & m) == m ? 1 : 0;
                if((k&m) ==0){
                    var other = bit==1?t.left:t.right;
                    if(other!=null){
                        ans = Math.min(ans, i-other.max+1);
                    }
                }
                t = bit==0?t.left:t.right;
                c++;
                if(c==30 && t!=null){
                    ans = Math.min(ans, i-t.max+1);
                }
            }
        }
        System.out.println(ans == n+1 ? -1 : ans);
    }


    static void insert(Node r, int i, int v){
        Node t = r;
        for(int mask = 1<<29; mask>0; mask >>= 1){
            int bit = (i & mask) == mask ? 1 : 0;
            if(bit == 0){
                if(t.left==null) t.left = new Node();
            }else{
                if(t.right==null) t.right = new Node();
            }
            t = bit==0? t.left : t.right;
            t.max = v;
        }
    }

    static class Node{
        Node left, right;
        int max = 0;
        Node(){}
    }

    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() throws FileNotFoundException
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
            // br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt")))); 
        }
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() { return Integer.parseInt(next()); } 
  
        long nextLong() { return Long.parseLong(next()); } 
  
        double nextDouble() { return Double.parseDouble(next()); } 
 
        int[] nextIntArray(int n)
        {
            int[] ans = new int[n];
            for(int i = 0; i < n; i++)
                ans[i] = nextInt();
            return ans;
        }
 
        Integer[] nextIntegerArray(int n)
        {
            Integer[] ans = new Integer[n];
            for(int i = 0; i < n; i++)
                ans[i] = nextInt();
            return ans;
        }
 
        long[] nextLongArray(int n)
        {
            long[] ans = new long[n];
            for(int i = 0; i < n; i++)
                ans[i] = nextLong();
            return ans;
        }
 
        String[] nextStringArray(int n)
        {
            String[] ans = new String[n];
            for(int i = 0; i < n; i++)
                ans[i] = next();
            return ans;
        }
 
        char[] nextCharArray()
        {
            return next().toCharArray();
        }
  
        String nextLine() 
        { 
            String str = ""; 
            try { 
                if(st.hasMoreTokens()){ 
                    str = st.nextToken("\n"); 
                } 
                else{ 
                    str = br.readLine(); 
                } 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
}


