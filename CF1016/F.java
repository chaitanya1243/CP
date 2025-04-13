import java.util.*;
import java.io.*;

public final class F{
    public static void main(String args[]) throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }

    static void solve(Scanner sc) throws FileNotFoundException{
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        String me[] = sc.nextLine().split(" ");
        String arr[][] = new String[m][n];
        for(int i=0; i<m; i++) arr[i] = sc.nextLine().split(" ");
        boolean all[] = new boolean[n];
        int max = 0;
        for(int i=0; i<m; i++){
            int c =0;
            for(int j=0; j<n; j++){
                if(arr[i][j].equals(me[j])){
                    all[j] = true;
                    c++;
                }
            }
            max = Math.max(max, c);
        }
        boolean allOk = true;
        for(var i: all) allOk = i&&allOk;
        if(!allOk){
            System.out.println(-1);
            return;
            
        }
        System.out.println(3*n - 2*max);
    }

    static boolean check(int arr[], int k, int t){
        if(t==0) return true;
        int subs = 0;
        boolean v[] = new boolean[t];
        int c = 0; 
        for(int i =0 ; i<arr.length; i++){
            if(arr[i] < t && !v[arr[i]]) {
                v[arr[i]] = true;
                c++;
            }
            if(c==t){
        // System.out.println("dsfd");
                subs++;
                v = new boolean[t];
                c =0;
            }
        }
        return subs >= k;
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


