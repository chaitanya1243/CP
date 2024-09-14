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
        long n = scanner.nextInt();
        long m = scanner.nextLong();
        Map<Long, Long> map = new HashMap<>();
        long ans = 0;
        for(long i=0; i<n; i++){
            long x = scanner.nextLong();
            map.put(x, map.getOrDefault(x, 0l)+1);
        }
    for (Map.Entry<Long,Long> entry : map.entrySet()) {
        long k = entry.getKey();
        long c1 = entry.getValue();
        long c2 = map.getOrDefault(k+1, 0l);
        for(long i=1; i<=c1; i++){
            if(k*i>m) break;
            long j =( m - k*i)/(k+1);
            
            j = Math.min(j, c2);
            ans = Math.max(ans, (i*k)+(j*(k+1)));
        }
        
    }
    System.out.println(ans);
    }
}