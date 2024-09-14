import java.util.*;

public final class f{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        fact[0] = 1;
        for(int i=1; i<=N; i++){
            fact[i] = (int)(((long)fact[i-1]*i)%mod);
        }
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }

    static long ans = 0;
    static int N = (int)2e5 + 5;
    static long mod = (long)1e9 + 7;
    static long fact[] = new long[N+1];

    static long pw(long a, long b){
        long ans = 1;
        while(b>0){
            if(b%2==1){
                ans = (((long)ans*a)%mod);
            }
            a = (((long)a*a)%mod);
            b/=2;
        }
        return ans;
    }

    static long c(int n, int k){
        if(k>n) return 0;
        return (fact[n]* pw((fact[k]*fact[n-k])%mod, mod-2))%mod;
    }

    static void solve(Scanner scanner){
        ans =0;
        int n = scanner.nextInt(), k = scanner.nextInt();
        int arr[] = new int[n];
        int ones = 0;
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
            if(arr[i]==1) ones++;
        }
        int t = (k+1)/2;
        for(int i = t; i<=Math.min(ones, k); i++){
            ans += c(ones, i)*c(n-ones, k-i);
            ans %= mod;
        }
        System.out.println(ans);
    }

    // static void dfs(int arr[],int med, int i, int x, int l){
    //     if(x==med){
    //             ans += c(arr.length-i, l);
    //             ans %= mod;
    //         return;
    //     }
    //     if(l==0) return;
    //     if(i>=arr.length || l > arr.length-i) return;
    //     dfs(arr, med, i+1, x, l);
    //     dfs(arr, med, i+1, x + arr[i], l-1);
    // }

}