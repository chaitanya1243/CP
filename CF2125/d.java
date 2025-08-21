import java.util.*;
import java.io.*;

public final class d{
    public static void main(String[] args) throws Exception{
        FastReader scanner = new FastReader();
        // int t = scanner.nextInt();
        // for(int i=0; i<t; i++){
            solve(scanner);
            // solve2(scanner);
        // }
        // scanner.close();
    }

    static void solve(FastReader sc) throws Exception{
        int n = sc.nextInt(), m = sc.nextInt();
        int l[] = new int[n];
        int r[] = new int[n];
        int p[] = new int[n];
        int q[] = new int[n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
            p[i] = sc.nextInt();
            q[i] = sc.nextInt();
            if(!map.containsKey(r[i])) map.put(r[i], new ArrayList<>());
            map.get(r[i]).add(i);
        }


        long dp[] = new long[m+1];
        dp[0] = 1;
        for(int i=0; i<n; i++){
            dp[0] = mul(dp[0], divide(q[i] - p[i], q[i]));
        }
        for(int i=1; i<=m; i++){
            if(map.get(i)==null) continue;
            for(int e : map.get(i)){
                long x = mul(dp[l[e]-1], divide(p[e], q[e]));
                x = divide(x , divide(q[e]-p[e], q[e]));
                dp[i] += x;
                dp[i]%=MOD;
            }
        }
        System.out.println(dp[m]);
        // System.out.println(Arrays.toString(dp));
    } 

    static long binpow(long b, long e) {
        long ans = 1;
        while (e > 0) {
            if ((e & 1) == 1) ans = (ans * b) % MOD;
            b = (b * b) % MOD;
            e >>= 1;
        }
        return ans;
    }
    
    static long divide(long x, long y) {
        return mul(x, binpow(y, MOD - 2));
    }

    static long mul(long x, long y) {
        return (x * y) % MOD;
    }
 
    static int MOD = 998244353;

        static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() throws IOException {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
 
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
        String nextLine() throws IOException { return br.readLine(); }
    }
}