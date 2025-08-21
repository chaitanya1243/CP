import java.util.*;

public final class C{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            solve(scanner);
            // solve2(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner in){
        int n = in.nextInt(), k = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int x = in.nextInt();
            map.put(x%k, map.getOrDefault(x%k, 0)+1);
        }
        boolean ok = true;
        for(int i=0; i<n; i++){
            int x = in.nextInt();
            int a = x%k;
            int b = Math.abs(a-k);
            if(map.getOrDefault(a, 0) > 0){
                map.put(a, map.get(a)-1);
            }else if(map.getOrDefault(b, 0) > 0){
                map.put(b, map.get(b)-1);
            }else{
                ok = false;
            }
        }
        
        System.out.println(ok ? "YES" : "NO");
    }

}