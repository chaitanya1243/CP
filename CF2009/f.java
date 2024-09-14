import java.util.*;

public final class f{
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
        int n = scanner.nextInt(); // 3
        int q = scanner.nextInt(); // 3
        long arr[] = new long[2*n+1];
        for(int i=1; i<=n; i++){
            arr[i] = arr[i+n] = scanner.nextLong();
        }
        for(int i=1; i<=2*n; i++){
            arr[i] += arr[i-1];
        }
        // System.out.println(Arrays.toString(arr));
        while(q-- > 0){
            long ans = 0;

         

            long l = scanner.nextLong();
            long r = scanner.nextLong();



            int x = (int)((l+n-1)/n), y = (int)((r+n-1)/n); // 3, 3
            ans = (long)(y-x+1)*arr[n]; // 6
            // System.out.println(ans);
            // for suffix
            int rl = (int)(((r-1)%n) + 1); // 3
            ans -= arr[y+n-1]-arr[y+rl-1]; // 6
            // assert ans != 12;
            // System.out.println(ans);
            // for prefix
            int lp = (int)(((l-1)%n )+ 1); // 1
            ans -= arr[x+lp-2]-arr[x-1]; // 6
            // assert ans != 18;
            System.out.println(ans);
        }
    }

}
