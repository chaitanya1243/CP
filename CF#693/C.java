import java.util.*;

public class C
{

    public static void solve(Scanner in) {
        int n = in.nextInt();

        int arr[] = new int[n];

        for(int i=0; i<n; i++) arr[i] = in.nextInt();

        long dp[] = new long[n];
        long ans = 0;

        for(int i=n-1; i>=0; i--){
            dp[i] = arr[i]+ (((i+arr[i])<n)?dp[i+arr[i]]:0);
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            solve(in);
        }
    }
}
