import java.util.*;
import java.io.*;

public final class D22002{
    public static void main(String args[]) throws FileNotFoundException{
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }

    static int[] f = null;
    static List<List<Integer>> adj;
    static int tin[];
    static int tout[];
    static int T=0;
    static void dfs(int u){
        tin[u] = ++T;
        for(int v: adj.get(u)){
            dfs(v);
        }
        tout[u] = T;
    }

    static boolean ok(int[] p, int i){
        if(i==1){
            if(p[i] == 1){
                return true;
            }else{
                return false;
            }
        }
        int prev = p[i-1], father = f[p[i]];
        return tin[prev] >= tin[father] && tout[prev] <= tout[father];
    }

    static void solve(FastScanner sc) throws FileNotFoundException{
        int n = sc.nextInt(), q = sc.nextInt();
        adj = new ArrayList<>();
        f = new int[n+1];
        tin = new int[n+1];
        tout = new int[n+1];
        T=0;
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=2; i<=n; i++){
            int v = sc.nextInt();
            adj.get(v).add(i);
            f[i] = v;
        }
        dfs(1);
        int p[] = new int[n+1];
        for(int i=0; i<n; i++){
            p[i+1] = sc.nextInt();
        }

        int c = 0;
        for(int i=1; i<=n; i++){
            if(!ok(p, i)) c++;
        }

        for(int i=0; i<q; i++){
            int x = sc.nextInt(), y = sc.nextInt();

           Set<Integer> set = new HashSet<>();
           set.add(x);
           if(x>1) set.add(x-1);
           if(x<n) set.add(x+1);
           set.add(y);
           if(y>1) set.add(y-1);
           if(y<n)  set.add(y+1);
           int before = 0;
           for(var k : set){
                if(!ok(p, k)) before++;
           }
           int temp = p[x];
           p[x] = p[y];
           p[y] = temp;

           int after = 0;
            for(var k : set){
                if(!ok(p, k)) after++;
           }
        // System.out.println(c+" "+before+" "+after);
           c -= before;
           c += after;
           if(c==0){
            System.out.println("YES");
           }else{
            System.out.println("NO");
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


