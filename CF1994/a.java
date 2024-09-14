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
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++)
        for(int j=0; j<m; j++)
        arr[i][j] = scanner.nextInt();

        if(n == 1 && m==1){
            System.out.println(-1);
            return;
        }
        int mod = n*m;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j]%mod+1+" ");
            }
            System.out.println();
        }
        
    }
}