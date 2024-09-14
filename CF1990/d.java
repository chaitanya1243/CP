import java.util.*;

public final class d{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }
    static long sum =0;

    static void solve(Scanner scanner){
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        int dp[][] = new int[n+1][4];
        int inf = Integer.MAX_VALUE-1;
        for(int[] a: dp){
            Arrays.fill(a, inf);
        }
        Arrays.fill(dp[0], 0);

        for(int i=1; i<=n; i++){
            dp[i][0] = dp[i-1][0]+((arr[i-1] > 0)? 1:0);
            if(arr[i-1] >= 5 || arr[i-1]==0) continue;

            if(arr[i-1] <= 2){
                if(i!=1)
                dp[i][0] = Math.min(dp[i-1][1], dp[i][0]);  
                dp[i][1] = dp[i-1][0]+1;

                continue;
            }

            dp[i][0] = Math.min(Math.min(dp[i-1][2], dp[i-1][1])+1, dp[i][0]);
            if(i!=1 && dp[i-1][2] != inf)
                dp[i][1] =  dp[i-1][2]+1;
            if(i!=1 && dp[i-1][1] != inf)
                dp[i][2] = dp[i-1][1]+1;
        }
        System.out.println(dp[n][0]);
    }


}