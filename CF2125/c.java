import java.util.*;

public final class c{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            solve(scanner);
            // solve2(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner){
        long l = scanner.nextLong(), r = scanner.nextLong();
        long ans = r - fun(r) - (l-1 - fun(l-1));
        // long ans = r - fun(r);
        
        System.out.println(ans);
        // solve2(l, r);
    }    
    static void solve2(long l, long r){
        long ans = 0;
        for(long i = l; i<=r; i++){
            if(i%2!=0 && i%3!=0 && i%5!=0 && i%7!=0){
                ans++;
            }
        }
        System.out.println(ans);
    }

    static long fun(long n){
        long a= 2, b=3, c=5, d=7;
        long ans = 0;
        ans+=n/2;
        ans+=n/3;
        ans+=n/5;
        ans+=n/7;
        // System.out.println(ans);


        ans-=n/6;
        ans-=n/10;
        ans-=n/14;
        ans-=n/15;
        ans-=n/21;
        ans-=n/35;

        ans+=n/(a*b*c);
        ans+=n/(a*b*d);
        ans+=n/(a*c*d);
        ans+=n/(d*b*c);

        ans-=n/(a*d*b*c);
        return ans+1;
    }
}