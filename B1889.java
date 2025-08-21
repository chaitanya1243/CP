import java.util.*;

public final class B1889{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }

    static void solve(Scanner sc){
        int n = sc.nextInt();
        long c = sc.nextLong();
        long a1 = sc.nextLong();
        long B = a1;
        long arr[][] = new long[n-1][2];
        for(int i=2; i<=n; i++){
            arr[i-2][0] = i;
            arr[i-2][1] = sc.nextLong();
        }
        Arrays.sort(arr, (a, b) ->Long.compare ((a[0]*c-a[1]), (b[0]*c-b[1])));
        for(long[] i: arr){
            B+=i[1];
            // System.out.println(B);
            if(B<i[0]*c){
                System.out.println("NO");
                return;
            }
        }
                System.out.println("YES");
    }
}