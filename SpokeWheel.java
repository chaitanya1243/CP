import java.util.*;

public final class SpokeWheel{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }
    static void solve(Scanner sc){
        int n = sc.nextInt(), m = sc.nextInt();
        boolean[] ds = new boolean[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            ds[b] = true;
        }
        int r =0;
        for(int i=1; i<=n; i++){
            if(!ds[i]){
                r=i;
                break;
            }
        }
        for(int i=1; i<=n; i++){
            if(i==r) continue;
            System.out.println(r+" "+i);
        }
    }
}