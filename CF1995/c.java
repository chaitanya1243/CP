import java.util.*;

public final class c{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner){
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        long arr[][] = new long[n][2];
        for(int i=0; i<2*n; i++){
            arr[i%n][i/n] = scanner.nextLong();
        }
        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));

        long ans = 0;

        for(int i=0; i<n; i++){
            if(i==n-1 || arr[i+1][0]!= arr[i][0]+1){
                long c1 = Math.min(arr[i][1], m/arr[i][0]);
                ans = Math.max(ans, arr[i][0]*c1);
                continue;
            }
            long k = arr[i][0];
            long c1 = Math.min(arr[i][1], m/k);
            long c2 = Math.min(arr[i+1][1], (m-c1*k)/(k+1));
            long x = Math.min(arr[i+1][1]-c2, m-c1*k-c2*(k+1));
            x = Math.min(x, c1);
            ans = Math.max(ans, (c1-x)*k + (c2+x)*(k+1));
        }
        System.out.println(ans);
    }
}