import java.util.*;
import java.io.*;

public final class F{
    public static void main(String args[]) throws FileNotFoundException{
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }

    static void solve(FastScanner sc) throws FileNotFoundException{
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        if((m%k) == 0){
            for(int i=0; i<n; i++){
                for(int j=0, x=((i%2)==0?0:1); j<m; j++, x++){
                    System.out.print((x%k)+1+" ");
                }
                System.out.println();
            }
        }else{
            for(int i=0, x=0; i<n; i++){
                for(int j=0; j<m; j++,x++){
                    System.out.print((x%k)+1+" ");
                }
                System.out.println();
            }
        }
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


