import java.util.*;

public final class b{
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
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int arr[] = new int[n];
        arr[x-1] = 1;
        arr[y-1] = 1;

        for(int i=x; i<n; i++){
            arr[i] = arr[i-1]*-1;
        }
        for(int i=y-2; i>=0; i--){
            arr[i] = arr[i+1]*-1;
        }
        for(int i=y; i<x; i++){
            arr[i] = 1;
        }
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}