import java.util.*;

class Solution
{
    public static void main(String argas[]){
        Scanner in = new Scanner(System.in);
        int tt = in.nextInt();
        for(int ti =1; ti<=tt; ti++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++)
            arr[i] = in.nextInt();
            int dp[][] = new int[n][4];
            for(int i=1; i<n; i++){
                if(arr[i]==arr[i-1])
                {
                    dp[i] = dp[i-1];
                    continue;
                }
                if(arr[i]>arr[i-1]){
                    for(int j=0; j<4; j++){
                        dp[i][j]=n;
                        for(int t=0; t<j; t++){
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][t]);
                        }
                        for(int t=j; t<4; t++){
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][t]+1);
                        }
                    }
                }else{
                    for(int j=0; j<4; j++){
                        dp[i][j]=n;
                        for(int t=0; t<=j; t++){
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][t]+1);
                        }
                        for(int t=j+1; t<4; t++){
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][t]);
                        }
                    }
                }
            }
            int ans = n;
            for(int i: dp[n-1])
            ans = Math.min(i,ans);
            System.out.println("Case #"+ti+": "+ans);
        }
    }
}