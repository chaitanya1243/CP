import java.util.*;

public final class E{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            solve(scanner);
            // solve2(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner in){
        int n = in.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];

        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i] = in.nextInt();
        }

        for(int i = 0; i<n-1; i++){
            if(a[i] != b[i] && b[i] == (a[i]^a[i+1])){
                a[i] = b[i];
            }
        }

        for(int i = n-2; i>=0; i--){
            if(a[i] != b[i] && b[i] == (a[i]^a[i+1])){
                a[i] = b[i];
            }
        }

        boolean ok = true;
        for(int i=0; i<n; i++){
            if(a[i] != b[i]){
                ok = false;
                break;
            }
        }
        System.out.println(ok ? "YES" : "NO");
    }

}