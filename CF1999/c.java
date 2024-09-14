import java.util.*;

public final class c{
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
        int n = scanner.nextInt(), s = scanner.nextInt(), m = scanner.nextInt();
        int arr[][] = new int[n+2][2];
        for(int i=1; i<=n; i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        arr[n+1][0] = m;
        for(int i=1; i<n+2; i++){
            if(arr[i][0]-arr[i-1][1] >= s){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}