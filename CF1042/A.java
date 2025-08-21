import java.util.*;

public final class A{
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
        int a[] = new int[n];
        int b[] = new int[n];

        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i] = in.nextInt();
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            if(a[i] > b[i]){

            ans += a[i] - b[i];
            }
        }
        System.out.println(ans+1);
    }

}