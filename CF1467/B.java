import java.util.*;

public class B
{
    public static int is(int[] arr, int i){
        if(i==0 || i==arr.length-1) return 0;
        if((arr[i-1] < arr[i] && arr[i+1] < arr[i]) || (arr[i-1] > arr[i] && arr[i+1] > arr[i]))
        return 1;
        return 0;
    }


    public static void solve(Scanner in) {
        int n = in.nextInt();

        int arr[] = new int[n];
        for(int i=0; i<n; i++) arr[i] = in.nextInt();

        int ans = 0;

        for(int i =1; i<n-1; i++){
            ans += is(arr, i);
        }
        int x = 0;
        for(int i = 1; i<n-1; i++){
            int t = arr[i];
            int def = is(arr, i-1) + is(arr, i) + is(arr, i+1);

            arr[i] = arr[i-1];
            int cur = is(arr, i-1) + is(arr, i) + is(arr, i+1);
            x = Math.max(def-cur, x);

            arr[i] = arr[i+1];
            cur = is(arr, i-1) + is(arr, i) + is(arr, i+1);
            x = Math.max(def-cur, x);
            
            

            arr[i] = t;
        }
        System.out.println((ans-x<0?0:(ans-x)));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            solve(in);
        }
    }
}