import java.util.*;

public class B
{

    public static void solve(Scanner in) {
        int n = in.nextInt();
        int c = 0;
        for(int i=0; i<n; i++) if(in.nextInt()==1) c++;

        if(c==0){
            System.out.println(((n%2==0)?"YES":"NO"));
        }else{
            System.out.println(((c%2==0)?"YES":"NO"));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            solve(in);
        }
    }
}
