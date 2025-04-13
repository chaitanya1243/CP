import java.util.*;
import java.io.*;

public final class D{
    public static void main(String args[]) throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // fill(1, 1, N, N);
        while(t-->0){
            solve(sc);
        }
    }

    static void solve(Scanner sc) throws FileNotFoundException{
        int n = sc.nextInt();

        int q = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<q; i++){
            String l = sc.nextLine();
            if(l.charAt(0) == '<'){
                var split = l.split(" ");
                long t = Long.parseLong(split[1]);
                var x = find(1, 1, 1<<n, 1<<n, 1l, 1l<<(2*n), t );
                System.out.println(x[0]+" "+ x[1]);
            }else{
                var split = l.split(" ");
                int x = Integer.parseInt(split[1]);
                int y = Integer.parseInt(split[2]);
                System.out.println(findv(1,1,1<<n,1<<n, 1l, 1l<<(2*n), x, y));

            }
        }
    }

    static int[] find(int x1, int y1, int x2, int y2, long min, long max, long t){
        if(min == max) return new int[]{x1, y1};

        long size = (max-min+1)/4;
        long min2 = min+size, min3 = min+size*2, min4 = min+size*3;

        int i = (x2-x1+1)/2;

        if(min <= t && t < min2){
            return find(x1, y1, x2-i, y2-i, min, min2-1, t);
        }else  if(min2 <= t && t< min3){
            return find(x1+i, y1+i, x2, y2, min2, min3-1, t);
        }else if(min3 <= t && t < min4){
            return find(x1+i, y1, x2, y2-i, min3, min4-1, t);
        }else{
            return find(x1, y1+i, x2-i, y2, min4, max, t);
        }
    }

    static long findv(int x1, int y1, int x2, int y2, long min, long max, int tx, int ty){
        if(min == max) {
            return min;
        };

        long size = (max-min+1)/4;
        long min2 = min+size, min3 = min+size*2, min4 = min+size*3;

        int i = (x2-x1+1)/2;

        if( tx <= x2-i &&  ty <= y2-i){
            return findv(x1, y1, x2-i, y2-i, min, min2-1, tx, ty);
        }else if(x1+i <= tx && y1+i <= ty){
            return findv(x1+i, y1+i, x2, y2, min2, min3-1, tx, ty);
        }else if(x1+i <= tx && ty <= y2-i){
            return findv(x1+i, y1, x2, y2-i, min3, min4-1, tx, ty);
        }else{
            return findv(x1, y1+i, x2-i, y2, min4, max, tx, ty);
        }
    }

    // static int N = 1<<30;
    // static long ds[][] = new long[N][N];
    // static long fi = 1;


    // static void fill( int x1, int y1, int x2, int y2){
    //     if(x1==x2 && y1==y2){
    //         ds[x1][y1] = fi++;
    //         return;
    //     } 

    //     int half = (x2-x1+1)/2;

    //     fill( x1, y1, x2-half, y2-half);
    //     fill( x1+half, y1+half, x2, y2);
    //     fill( x1+half, y1, x2, y2 - half);
    //     fill( x1, y1+half, x2-half, y2);

    // }

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


