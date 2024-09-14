import java.util.*;

public final class e{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner){
        int n = scanner.nextInt();
        long k = scanner.nextLong();

        int l = 0, r = n-1;
        while(l < r){
            int m = (l+(r-l)/2) +1;
            if(calx(n, k, m) <= 0){
                l = m;
            }else{
                r = m-1;
            }
        }
        System.out.println(Math.min(Math.abs(calx(n, k, l)), Math.abs(calx(n, k, l+1))));
    }

    static long calx(int n, long k, int m){
        if(m==n) return Long.MAX_VALUE;
        long x = k*m + sumofn(m-1);
        long y = k*(n-m) + sumofn(n-1) - sumofn(m-1);
        return x-y;
    }

    static long sumofn(long n){
        return (n*(n+1))/2;
    }
}