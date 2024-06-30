import java.util.*;

//codeforces question basic template
 public final class d{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            int n = scanner.nextInt();
            long c =  scanner.nextLong();
            int[] arr =  new int[n];
            for(int j=0; j<n; j++){
                arr[j] = scanner.nextInt();
            }
            solve(arr, c);
        }

        
        scanner.close();
    }

    static void solve(int[]arr, long c){
        long z = c+1;
        long ans = (z*(z+1))/2;
        int odds = 0;
        int evens = 0;
        for(int i=0;i<arr.length; i++){
            int x = arr[i];
            if(x%2==0) evens++;
            else odds++;
            int a = (int)c-x+1;
            int b = (x/2)+1 - ((x%2==0) ? evens : odds);
        // System.out.println(a+" "+b);

            ans -= a+b;
        }
        System.out.println(ans);
    }


}
// n = 5
// 0 0 1 1 3