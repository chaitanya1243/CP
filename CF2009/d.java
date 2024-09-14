import java.util.*;

public final class d{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner){
        int n = scanner.nextInt();
        boolean a[][] = new boolean[2][n+1];
        for(int i=0; i<n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            a[y][x] = true;
        }
        long ans = 0;
        for(int i=0; i<=n; i++){
            if(a[0][i] && a[1][i]){
                ans += n-2;
            }
            if(i > 0 && i <n){
                if(a[0][i] && a[1][i-1] && a[1][i+1]){
                    ans += 1;
                }
                if(a[1][i] && a[0][i-1] && a[0][i+1]){
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }

}