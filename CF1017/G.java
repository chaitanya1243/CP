import java.util.*;
import java.io.*;

public final class G{
    public static void main(String args[]) throws FileNotFoundException{
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }

    static void solve(FastScanner sc) throws FileNotFoundException{
        int n = sc.nextInt();
        long riz = 0;
        long rriz = 0;
        long sum = 0;
        boolean flag = false;
        Deque<Integer> q = new LinkedList<>();
        for(int qi=0; qi<n; qi++){
            int s = sc.nextInt();
            if(s==3){
                int i = sc.nextInt();
                if(flag){
                    q.offerFirst(i);
                    riz += i+sum;
                    rriz += (long)i*q.size();
                }else{
                    q.offerLast(i);
                    riz += (long)i*q.size();
                    rriz += i+sum;
                }
                sum+=i;
            }else if(s==2){
                flag = !flag;
            }else{
                if(!flag){
                    int i = q.pollLast();
                    q.offerFirst(i);
                    riz -= ((long)q.size())*i;
                    riz += sum;
                    rriz += ((long)(q.size()))*i;
                    rriz -= sum;
                }else{
                    int i = q.pollFirst();
                    q.offerLast(i);
                    rriz -= ((long)q.size())*i;
                    rriz += sum;
                    riz += ((long)(q.size()))*i;
                    riz -= sum;
                }
            }
            System.out.println(flag?rriz:riz);
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


