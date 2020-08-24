import java.util.*;

class Solution
{
    public static void main(String argas[]){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int ti=1; ti<=T; ti++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = in.nextInt();
            }
            int ans = 2;
            int prev = arr[0]-arr[1];
            for(int i=0, j=2; j<n; j++){
                int cur = arr[j-1]-arr[j];
                if(prev!=cur){
                    prev = cur;
                    i = j-1;
                    // ans = Math.max(ans, j-i);
                }
                ans = Math.max(ans, j-i+1);
                // System.out.println(i+" "+j);
            }
            System.out.println("Case #"+ti+": "+ans);
        }
    }
}