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

    static void solve(Scanner scanner){
        long n = scanner.nextLong();
        List<Long> list = new ArrayList<>();
        for(int i=62; i>=0; i--){
            long x = (long)1 << i;
            if((n&x)==x && x!=n) list.add(n-x);
        }
        list.add(n);
        System.out.println(list.size());
        for(long x: list) System.out.print(x + " ");
        System.out.println();
    }
}