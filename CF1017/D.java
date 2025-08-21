import java.util.*;
import java.io.*;

public final class D{
    public static void main(String args[]) throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            solve(sc);
        }
    }

    static void solve(Scanner sc) throws FileNotFoundException{
        char[] a = sc.nextLine().toCharArray();
        char[] b = sc.nextLine().toCharArray();
        int i=0, j=0; 
        while(i<a.length && j < b.length){
            int ti = i+1, tj = j+1;
            while(ti < a.length && a[ti] == a[ti-1]) ti++;
            while(tj < b.length && b[tj] == b[tj-1]) tj++;
            
            int la = ti-i, lb = tj-j;
            if(!(la <= lb && lb <= 2*la && a[i]==b[j])) break;

            i = ti;
            j = tj;
        }
        System.out.println((i==a.length && j==b.length) ? "YES" : "NO");
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


