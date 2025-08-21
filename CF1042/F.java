import java.util.*;

public final class F{
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
        in.nextLine();
        String a = in.nextLine();
        String b = in.nextLine();

        int dp[][][] = new int[n+1][n+1][3];
        // i1 first row, j1 firs col
        

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                Arrays.fill(dp[i][j], 2*n+2);
                int me = ((a.charAt(i-1)-'0') ^ (b.charAt(j-1)-'0'));
                int left = (j == 1) ? 0 : ((a.charAt(i-1)-'0') ^ (b.charAt(j-2)-'0'));
                int up = (i == 1) ? 0 : ((a.charAt(i-2)-'0') ^ (b.charAt(j-1)-'0'));

                int[] state = dp[i][j];
                if(me == 0){
                    state[0] = Math.min(state[0], (left==0) ? dp[i][j-1][0] : dp[i][j-1][col]);
                    state[0] = Math.min(state[0], (up==0) ? (i-1, j, 0) : (i, j-1, col));
                }

            }
        }
        if(me == 0){
            myValue = if(left == 0) ? ((i, j-1, 0)): (i, j-1, col);
            myValue = min(myValue, if(up == 0) ? (i-1, j, 0) : (i-1, j, row))
        }else{
            // if row switch
            if(left == 1)  (i, j-1, row) 
            if(left == 0) (i, j-1, col) + 1
            if(up == 0) (i-1, j, 0) + 1
            // col switch
            if(left = 0) (i, j-1, 0) + 1
            if(up == 1) (i-1, j, col)
            if(up == 0) (i-1, j, row) + 1
        }
        
        System.out.println(ops);
    }

    static int RF = 1, CF = 2;
}