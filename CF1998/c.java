import java.util.*;

public final class c{
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
        long k = scanner.nextLong();
        int arr[] = new int[n];
        int sorted[][] = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
            sorted[i][0] = arr[i];
        }
        for(int i=0; i<n; i++){
            sorted[i][1] = scanner.nextInt();
        }
        Arrays.sort(sorted, (a, b) -> a[0]-b[0]);
        int prefb[] = new int[n];
        int pref[] = new int[n];
        long ans = 0;
        prefb[0]=sorted[0][1];
        pref[0]= (sorted[0][1]==1) ? sorted[0][0]: 0;
        for(int i=1; i<n; i++){
            prefb[i] = prefb[i-1]+sorted[i][1];
            pref[i] = pref[i-1] + ((sorted[i][1]==1) ? sorted[i][0]: 0);
        }
        int m = n/2 - 1;
        for(int i=n-1; i>=0; i--){
            if(sorted[i][1]==1){
                ans = sorted[i][0]+k+sorted[(i>m)?m:m+1][0];
                break;
            }
        }
        if(sorted[n-1][1]==0){
            long l = sorted[m][0], r = k+1;
            int half = (n+1)/2;
            while(l<r){
                long x = (l+r)/2;
                int o=0, p=n-1;
                while(o<p){
                    int z = o+(p-o)/2;
                    if(sorted[z][0]>=x) p =z;
                    else o = z+1;
                }
                long need = half-n+x;
                if(need > 0 && prefb[o-1] >= need){
                    int h = 0, j = o-1;
                    long ttar = prefb[o-1] - need;
                    while(h<j){
                        int q = h+(j-h)/2 +1;
                        if(prefb[q] <= ttar) h=q;
                        else j=q-1;
                    }
                    long currentsum = pref[o-1]-pref[h];
                    if(need*x-currentsum <= k){
                        r = x;
                        continue;
                    }
                }
                l = x+1;
            }
            ans = Math.max(ans, sorted[n-1][0]+l);
        }
        System.out.println(ans);
    }
}