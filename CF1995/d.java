import java.util.*;

public final class d{
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
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        for(int i=1; i<n; i++){
            if(arr[i]==1 && arr[i-1]>1){
                System.out.println(-1);
                return;
            }
        }

        long op[] = new long[n];
        long ans = 0;
        for(int i=1; i<n; i++){
            long x =0, p = arr[i-1], c = arr[i];

            while(p!=1 && p*p <= c){
                p*=p;
                x--;
            }

            while(c < p){
                c*=c;
                x++;
            }
            op[i]= Math.max(0l, op[i-1]+x);
            ans+=op[i];
        }
        System.out.println(ans);
    }
}