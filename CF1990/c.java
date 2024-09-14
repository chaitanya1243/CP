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
    static long sum =0;

    static void solve(Scanner scanner){
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        sum = 0;



        madify(arr);
        madify(arr);
        sum += arr[n-1];
        for(int i=1; i<n-1; i++){
            sum += (long)arr[i]*(n-i);
        }
        System.out.println(sum);
    }

    static void madify(int[] arr){
        int n = arr.length;
        int count[] = new int[n+1];
        int mad = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            count[arr[i]]++;
            if(count[arr[i]] > 1){
                mad = Math.max(mad, arr[i]);
            }
            arr[i] = mad;
        }
    }
}