import java.util.*;
import java.io.*;

public final class D{
    public static void main(String args[]) throws FileNotFoundException{
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }

    static void solve(FastScanner sc) throws FileNotFoundException{
        int n = sc.nextInt();

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> sumMap = new HashMap<>();

        for(int i=0; i<n; i++){
            int x = sc.nextInt(), y = sc.nextInt();
            sumMap.put(x+y, sumMap.getOrDefault(x+y, 0)+1);
            xMap.put(x, xMap.getOrDefault(x, 0)+1);
        }

        int x = 0;
        for(var e: xMap.entrySet()){
            if(e.getValue()%2==1){
                x = e.getKey();
                break;
            }
        }
        int y =0;
        for(var e: sumMap.entrySet()){
            if(e.getValue()%2==1){
                y = e.getKey() - x;
                break;
            }
        }
        System.out.println(x+" "+ y);
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


