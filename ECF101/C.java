import java.util.*;

public class C
{
    public static void solve() {
        Scanner in = new Scanner(System.in);
        int tt = in.nextInt();
        mm:for(int T = 0; T<tt; T++){
            int n = in.nextInt(), k = in.nextInt();
            int hs[] = new int[n];
            for(int i=0; i<n; i++){
                hs[i] = in.nextInt();
            }
            long max = hs[0], min = hs[0];
            for(int i=1; i<n; i++){
                max = Math.min((i==n-1)?hs[i]:(hs[i]+k-1), (max+k-1));
                min = Math.max(hs[i], (min-k+1));
                if(max<min){
                    System.out.println("no");
                    continue mm;
                }
            }
            // if(hs[n-1]+k <= min || hs[n-1]>=max+k)
            // System.out.println("no");
            // else
            System.out.println("yes");

        }
    }
    public static void main(String[] args) {    
        solve();
    }
}