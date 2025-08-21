import java.util.*;
public final class C1979{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }
    static final Random random=new Random();
    static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    static long lcm(long a, long b){
        return a/gcd(a,b) *b;
    }
    static long lcm(long arr[]){
        long p = arr[0];
        for(int i=1; i<arr.length; i++){
            p = lcm(arr[i], p);
        }
        return p;
    }
    static void solve(Scanner sc) throws Exception{
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = (long)sc.nextInt();
        }
        long p = 1;
        for(int i=0; i<n; i++) p = p*arr[i];

        // long nmrtr = 0;
        // for(long i: arr) nmrtr += p/i;
        if(p==0 && n < 18) {
            // for(long i: arr)
            // if(i==0 || i>21)
            System.out.print(100+" ");
        };
        // long fgf = nmrtr/1l;
        
        // if(nmrtr/p==1 || ((double)nmrtr)/p > 1){
        //     System.out.println(-1);
        //     return;
        // }
                    double sumReciprocal = 0.0;
            for (int i = 0; i < n; i++) {
                sumReciprocal += 1.0 / arr[i];
            }
            if (sumReciprocal >= 1 - 1e-9) {

                System.out.println(-1);
                return;
            }
        long lcm = lcm(arr);
        for(long i:arr)
        System.out.print(lcm/i+" ");
        System.out.println();
    }
}