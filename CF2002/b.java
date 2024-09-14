import java.util.*;

public final class b{
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
        int a[] = new int[n];
        int b[] = new int[n];

        for(int i=0; i<n; i++) a[i] = scanner.nextInt();
        for(int i=0; i<n; i++) b[i] = scanner.nextInt();
        int i=0, j =0;
        for(i=0; i<n; i++){
            if(a[i]!=b[i]) break;
        }
        for(j=0; j<n; j++){
            if(a[j]!=b[n-j-1]) break;
        }
        if(i==n|| j==n) System.out.println("Bob");
        else System.out.println("Alice");
    }
}