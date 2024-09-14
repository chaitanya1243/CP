import java.util.*;
 
//codeforces question basic template
 public final class b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }
 
    static void solve(Scanner scanner){
 
        int n = scanner.nextInt();
        int[] arr = new int[n];;
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        int[] c = new int[n];
 
        int req = arr[0];
        for(int i=0; i<n; i++){
            req = Math.max(req, arr[i]);
            c[i] = req - arr[i];
        }
        Arrays.sort(c);
 
        long ans = (long)c[0]*(n+1);
        for(int i=1; i<n; i++){
            ans += (long)(c[i] - c[i-1]) * (n-i+1);
        }
        System.out.println(ans);
    }
 
}
// n = 5
// 0 0 1 1 3
 
// 1 1
