import java.util.*;

public final class c{
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
        int k = scanner.nextInt();

        for(int i =n; i>m; i--){
            System.out.print(i+" ");
        }
        for(int i =1; i<=m; i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}