import java.util.*;

public final class a{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner){
        int n = scanner.nextInt();
        int arr[] = new int[n+1];
        for(int i=1; i<=n; i++){
            int x = scanner.nextInt();
            arr[x]++;
        }
        for(int i=n; i>=0; i--){
            if(arr[i] == 0)
                continue;
            if(arr[i]%2==1){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}