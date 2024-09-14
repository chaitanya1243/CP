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
        int k = scanner.nextInt();
        int[] arr = new int[k];
        int maxIdx = 0;
        
        for(int i=0; i<k; i++){
            arr[i] = scanner.nextInt();
            if(arr[i] > arr[maxIdx]){
                maxIdx = i;
            }
        }
        long ans = 0;
        for(int i=0; i<k; i++){
            if(i == maxIdx){
                continue;
            }
            ans += ((arr[i]-1)*2)+1;
        }
        System.out.println(ans);
    }
}