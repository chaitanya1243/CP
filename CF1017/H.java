import java.util.*;
import java.io.*;

public final class H{
    public static void main(String args[]) throws FileNotFoundException{
        int t = in.nextInt();
        while(t-->0) solve();

    }

    static void solve()throws FileNotFoundException{
        int n = in.nextInt(), q = in.nextInt();
        Map<Integer, Integer> ptr = new HashMap<>();
        Map<Integer, List<Integer>> pos = new HashMap<>();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
            if(!pos.containsKey(arr[i])) pos.put(arr[i], new ArrayList<>());
            pos.get(arr[i]).add(i);
            ptr.put(arr[i],0);
        }
        long ans[] = new long[q];
        int[][] qs = new int[q][4];
        for(int i=0; i<q; i++){

            qs[i] = new int[]{in.nextInt(), in.nextInt()-1, in.nextInt()-1, i};
        }
        Arrays.sort(qs, (a, b) -> Integer.compare(a[1], b[1]));
        // System.out.println(Arrays.deepToString(qs));
        int prevL = 0;
        for(var cq: qs){
            int k = cq[0], l = cq[1], r = cq[2];
            for(int i = prevL; i<l; i++) ptr.put(arr[i], ptr.get(arr[i])+1);
            prevL = l;
            List<Integer> facts = new ArrayList<>();
            for(int i=1; i*i <= k; i++){
                if(k%i!=0) continue;
                for(var f1 :  new int[]{i, k/i})
                if(pos.containsKey(f1) && pos.get(f1).size() > ptr.get(f1) && pos.get(f1).get(ptr.get(f1)) <= r){
                    facts.add(pos.get(f1).get(ptr.get(f1)));
                }
            }
            Collections.sort(facts);
            long cans = 0;
            for(int f : facts){
                cans += (f-l)*(long)k;
                while(k%arr[f]==0) k /= arr[f];
                l = f;
            }
            cans += (r-l+1)*(long)k;
            ans[cq[3]] = cans;
        }
        for(long i: ans) System.out.println(i);
    }

    static FastScanner in = new FastScanner(System.in);

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