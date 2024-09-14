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
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        for(int i=1; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[0]);
    }
}