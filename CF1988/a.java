import java.util.*;

public final class a{
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
        if(n==1){
            System.out.println(0);
            return;
        }
        int ans = 0;
        int t =n;
        while(true){
            if(n<=k){
                ans++;
                break;
            }
            int parts = (n+k-1)/k;
            if(parts <= k){
                ans += 1 + parts;
                if(t%k==1)ans--;
                break;
            }else{
                ans += k;
                n -= (k-1)*k;
            }
        }
        System.out.println(ans);

    }
}