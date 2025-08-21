import java.util.*;
import java.io.*;

public final class E2002{
    public static void main(String args[]) throws FileNotFoundException{
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }

    static void solve(FastScanner sc) throws FileNotFoundException{
        int n = sc.nextInt();
        long[][] arr = new long[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] =sc.nextInt();
            arr[i][1] =sc.nextInt();
        }
        Deque<long[]> ds =  new LinkedList<>();
        for(int i = 0; i<n; i++){
            // process
            long id = arr[i][1], value = arr[i][0];
            var last = ds.peekLast();
            while(!ds.isEmpty() && (ds.peekLast()[0] <= value || ds.peekLast()[1] == id)){
                if(ds.peekLast()[1] == id){
                    value = ds.peekLast()[0] + value - last[0];
                }
                last = ds.pollLast();
            }
            ds.offerLast(new long[]{value, id});
            
            System.out.print(ds.peekFirst()[0]+" ");
        }
        System.out.println();
    }

    static public class FastScanner {
        public BufferedReader br;
        public StringTokenizer st;
 
        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }
 
        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public boolean hasMoreTokens() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    return false;
                }
                if (line == null) {
                    return false;
                }
                st = new StringTokenizer(line);
            }
            return true;
        }
 
        public String next() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public double nextDouble() {
            return Double.parseDouble(next());
        }
 
        public int[] nextIntArray(int n) {
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nextInt();
            }
            return ret;
        }
 
        public long[] nextLongArray(int n) {
            long[] ret = new long[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nextLong();
            }
            return ret;
        }
    }
}


