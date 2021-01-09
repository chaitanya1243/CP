import java.util.*;

public class A
{

    public static void solve(Scanner in) {
        int w = in.nextInt(), h = in.nextInt(), n = in.nextInt();

        int ans = 1;

        while(w%2==0 || h%2==0){
            if(w%2==0)
            w = w/2;
            else
            h = h/2;
            ans *= 2;
        }

        System.out.println(((ans>=n)?"YES":"NO"));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            solve(in);
        }
    }
}