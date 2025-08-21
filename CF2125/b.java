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
        long x = scanner.nextLong(), y = scanner.nextLong(), k = scanner.nextLong();

        long g = gcd(x, y);
        if(Math.max(x/g, y/g) > k){
            System.out.println(2);
        }else{
            System.out.println(1);
        }
    }

    static long gcd(long a, long b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
}