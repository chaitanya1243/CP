import java.util.*;

public final class e2008{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner){
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        int[][] right = new int[2][26];

        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i) - 'a';
            right[i%2][c]++;
        }
        if(n%2==0){
            int oddMax = 0, evenMax = 0;
            for(int i=0; i<26; i++){
                oddMax = Math.max(oddMax, right[1][i]);
                evenMax = Math.max(evenMax, right[0][i]);
            }
            System.out.println(n- oddMax - evenMax);
            return;
        }
        int[][] left = new int[2][26];
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int c = s.charAt(i) - 'a';
            right[i%2][c]--;

            int a = _max(left[0], right[1]);
            int b = _max(left[1], right[0]);

            ans = Math.min(ans, n-a-b);

            left[i%2][c]++;
        }
        System.out.println(ans);
    }

    static int _max(int[] a, int[] b){
        int max = 0;
        for(int i=0; i<26; i++){
            max = Math.max(max, a[i] + b[i]);
        }
        return max;
    }
}