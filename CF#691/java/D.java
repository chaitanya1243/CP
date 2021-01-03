import java.util.*;

class D
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[][] = new int[n][2];
        int totalCapacity = 0, totalWater = 0;
        for(int i=0; i<n; i++){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            totalCapacity += arr[i][0];
            totalWater += arr[i][1];
        }
        int dp[][][] = new int[n+1][n+1][totalCapacity+1];

        for(int[][] j: dp)
        for(int[] i: j) 
        Arrays.fill(i, -1);


        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                for(int a=1; a<=totalCapacity; a++){
                    dp[i][k][a] = dp[i-1][k][a];
                    if(arr[i-1][0]<=a){
                        if(arr[i-1][0]==a)
                        dp[i][k][a] = Math.max(arr[i-1][1], dp[i][k][a]);

                        if(dp[i-1][k-1][a-arr[i-1][0]] != -1)
                        dp[i][k][a] = Math.max(dp[i-1][k-1][a-arr[i-1][0]]+arr[i-1][1], dp[i][k][a]);
                    }
                }
            }
            // System.out.println("i: "+i);
            // for(int[] x: dp[i]) 
            // System.out.println(Arrays.toString(x));
        }
        for(int idx=1; idx<=n; idx++){
            int[] i = dp[n][idx];
            double max = 0d;
            for(int a=1; a<=totalCapacity; a++){
                if(i[a]!=-1)
                max = Math.max(max, Math.min(((double)i[a])/(double)2 + ((double)totalWater)/(double)2, a));
            }
            System.out.print(max+" ");
        }
        // for(int[][] j: dp)
        // for(int[] i: j) 
        // System.out.println(Arrays.toString(i));

        // int add = 1;
        // int adda = 5;
        // System.out.print(((double)add)/(double)2 + ((double)adda)/(double)2);
    }
}