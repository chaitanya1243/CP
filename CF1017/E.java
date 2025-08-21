import java.util.*;
import java.io.*;

public final class E{
    public static void main(String args[]) throws FileNotFoundException{
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }

    static void solve(FastScanner sc) throws FileNotFoundException{
        int n = sc.nextInt();
        int arr[] = sc.nextIntArray(n);
        int[] ds = new int[31];
        for(int e: arr)
        for(int i=0; i<31; i++){
            ds[i] += (e>>i)&1;
        }
        // System.out.println(Arrays.toString(ds));
        long ans = -1;
        for(int e:arr){
            long sum = 0;
            for(int i=0; i<31; i++){
                if(((e>>i)&1)==0){
                    sum+=(1l<<i)*ds[i];
                }else{
                    sum+=(1l<<i)*(n-ds[i]);
                }
            }
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);
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


