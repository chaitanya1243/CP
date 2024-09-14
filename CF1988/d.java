import java.util.*;

public final class d{
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
        long[] arr = new long[n];
        for(int i=0; i<n; i++) arr[i] = scanner.nextLong();

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) graph.add(new ArrayList<Integer>());

        for(int i=0; i<n-1; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a-1).add(b-1);
            graph.get(b-1).add(a-1);
        }
        long a=0,b=0;
        boolean flag = true;
        boolean[] v = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(q.size()>0){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                int node = q.poll();
                if(v[node]) continue;
                v[node] = true;
                if(flag) a+=arr[node];
                else b+=arr[node];
                for(int child: graph.get(node)){
                    q.add(child);
                }
            }
            flag = !flag;
        }
        System.out.println(a+b+Math.min(a,b));
    }
}