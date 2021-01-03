import java.util.*;

public class B
{
    public static void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int T = 0; T<n; T++){
            int r = in.nextInt();
            int rArr[] = new int[r];
            for(int i=0; i<r; i++) rArr[i] = in.nextInt();
            int b = in.nextInt();
            int bArr[] = new int[b];
            for(int i=0; i<b; i++) bArr[i] = in.nextInt();

            long bestr = 0, bestb = 0, curSum = 0;

            for(int i: rArr){
                curSum += i;
                bestr = Math.max(bestr, curSum);
            }
            curSum = 0;
            for(int i: bArr){
                curSum += i;
                bestb = Math.max(bestb, curSum);
            }

            System.out.println(bestb+bestr);
        }
    }
    public static void main(String[] args) {    
        solve();
    }
}