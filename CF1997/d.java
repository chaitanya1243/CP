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

    static char free = '.';

    static void solve(Scanner scanner){
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0; i<n; i++){
            tree.add(new ArrayList<>());
        }
        for(int i=1; i<n; i++){
            int p = scanner.nextInt();
            tree.get(p-1).add(i);
        }
        long ans = Long.MAX_VALUE;
        for(int c: tree.get(0)){
            ans = Math.min(opt(tree, c, arr), ans);
        }
        System.out.println(ans+arr[0]);
    }

    static long opt(List<List<Integer>> tree, int v, int[] arr){
        if(tree.get(v).isEmpty()){
            return arr[v];
        }

        long min = Long.MAX_VALUE;
        for(int c: tree.get(v)){
            min = Math.min(min, opt(tree, c, arr));
        }
        return (min < (long)arr[v]) ? min : (arr[v] + (min-arr[v])/2);
    }
}