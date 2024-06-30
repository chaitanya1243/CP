import java.util.*;

//codeforces question basic template
 public final class c{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            int n = scanner.nextInt();
            int L =  scanner.nextInt();
            int[][] arr =  new int[n][2];
            for(int j=0; j<n; j++){
                arr[j][0] = scanner.nextInt();
                arr[j][1] = scanner.nextInt();
            }
            solve(arr, L);
        }

        
        scanner.close();
    }

    static void solve(int[][] arr, int L){
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        // System.out.println(Arrays.deepToString(arr));
        int ans = 0;
        int n =  arr.length;
        for(int i=0; i<n; i++){
             PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
             int sum = 0;
            for(int j=i; j<n; j++){
                int b = arr[j][1] - arr[i][1];
                sum += arr[j][0];
                pq.add(arr[j][0]);
                while(sum + b > L && pq.size() > 0){
                    int v = pq.remove();
                    sum -= v;
                }
                ans = Math.max(pq.size(), ans);
        // System.out.println(pq.size()+" "+sum);

            }
        }
        System.out.println(ans);
    }


}
// n = 5
// 0 0 1 1 3