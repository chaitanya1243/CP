import java.util.*;

public final class f2008{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }

    static long mod = 1000000007;

    static void solve(Scanner scanner){
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        
        }

        long x = 0, y = 0;
        for(int i: arr){
            x+=i;
            x%=mod;
            y += ((long)i*i)%mod;
            y%=mod;
        }
        x*=x;
        x%=mod;
        x = (x-y+mod)%mod;
        // System.out.println("Numerator: "+ x);
        y = pow(2, mod-2);
        x*=y;
        x%=mod;
        y = (long)n *(n-1);
        y%= mod;
        y*=pow(2,mod-2);
        y%=mod;
        x*=pow(y, mod-2);
        x%=mod;
        System.out.println(x);
    }

    static long pow(long a, long b){
        if(b==0) return 1;
        long x = pow(a, b/2);
        x*=x;
        x%=mod;
        if(b%2==1){
            x*=a;
            x%=mod;
        }
        return x;
    }
}