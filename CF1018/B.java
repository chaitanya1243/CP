import java.util.*;
import java.io.*;

public final class B{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) solve(sc);
    }

    static void solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l[] = new int[n];
        int r[] = new int[n];
        for(int i=0; i<n; i++){
            l[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            r[i] = sc.nextInt();
        }
        List<Integer> rem = new ArrayList<>();
        long ans = 0;
        for(int i=0; i<n; i++){
            if(l[i] > r[i]){
                ans += l[i];
                rem.add(r[i]);
            }else{
                ans += r[i];
                rem.add(l[i]);
            }
        } 
        Collections.sort(rem, (a, b) -> Long.compare(b, a));

        for(int i=0; i<k-1; i++) ans+= rem.get(i);
        System.out.println(ans+1);
    }


}