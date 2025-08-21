import java.util.*;

public final class D{
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
        int n = in.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++) adjList.add(new ArrayList<>());
        for(int i=0; i<n-1; i++){
            int u = in.nextInt(), v = in.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int leafs = 0;
        for(int i=1; i<=n; i++){
            if(adjList.get(i).size() == 1){
                leafs++;
            }
        }
        int ops = n;
        for(int i=1; i<=n; i++){
            int ex = 0;
            for(int v : adjList.get(i)){
                if(adjList.get(v).size() == 1) ex++;
            }
            if(adjList.get(i).size() == 1) ex++;

            ops = Math.min(leafs-ex, ops);
        }
        
        System.out.println(ops);
    }
}